package com.example.Homework.services.implement;
import com.example.Homework.services.UserService;
import com.example.Homework.domain.entities.Rol;
import com.example.Homework.domain.entities.User;
import com.example.Homework.domain.entities.User_Detail;
import com.example.Homework.domain.entities.User_Rol;
import com.example.Homework.dto.UserDTO;
import com.example.Homework.repositories.RolRepository;
import com.example.Homework.repositories.UserRepository;
import com.example.Homework.repositories.User_DetailRepository;
import com.example.Homework.repositories.User_RolRepository;
import com.example.Homework.services.mapper.UserMapper;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.hibernate.mapping.UserDefinedType;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class UserServiceImp implements UserService{
    @PersistenceContext
    private EntityManager entityManager;
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    private final User_DetailRepository userDetailRepository;

    private final User_RolRepository userRolRepository;
    private final RolRepository rolRepository;

    public UserServiceImp(UserRepository userRepository, UserMapper userMapper, User_DetailRepository userDetailRepository, User_RolRepository userRolRepository, RolRepository rolRepository) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
        this.userDetailRepository = userDetailRepository;
        this.userRolRepository = userRolRepository;
        this.rolRepository = rolRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsers() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDto).collect(Collectors.toList());
    }

    @Override
    @Transactional(readOnly = true)
    public List<UserDTO> listUsersDetailed() {
        return userRepository.findAll()
                .stream()
                .map(userMapper::toDtoDetailed).collect(Collectors.toList());
    }

    @Override
    public UserDTO save(UserDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(LocalDateTime.now());

        userRepository.save(user);

        if (dto.getFirstName() != null && dto.getLastName() != null && dto.getAge() != null && dto.getBirthday() != null){
            User_Detail userDetail = new User_Detail();
            userDetail.setUser(user);
            userDetail.setFirstName(dto.getFirstName());
            userDetail.setLastName(dto.getLastName());
            userDetail.setAge(dto.getAge());
            userDetail.setBirthday(dto.getBirthday());
            userDetailRepository.save(userDetail);
        }

        if (dto.getRolsIds() != null){
            List<Rol> roles = rolRepository.findAllById(dto.getRolsIds());


            for (Rol rol : roles) {
                User_Rol userRol = new User_Rol();
                userRol.setUser(user);
                userRol.setRol(rol);
                userRol.setCreatedAt(LocalDateTime.now());
                userRol.setActive(true);

                userRolRepository.save(userRol);
            }
        }
        return userMapper.toDto(user);
    }

    public UserDTO editarUser(Integer id, UserDTO dto) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("user no encontrado"));

        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword());
        user.setEmail(dto.getEmail());
        user.setCreatedAt(user.getCreatedAt());

        if (dto.getFirstName() != null && dto.getLastName() != null && dto.getAge() != null && dto.getBirthday() != null) {
            User_Detail userDetail = user.getUserDetail();
            if (userDetail != null){
                userDetail.setFirstName(dto.getFirstName());
                userDetail.setLastName(dto.getLastName());
                userDetail.setAge(dto.getAge());
                userDetail.setBirthday(dto.getBirthday());
                userDetailRepository.save(userDetail);
            }
        }


        if (dto.getRolsIds() != null){
            List<User_Rol> userRoles = userRolRepository.findByUser(user);

            List<Integer> rolesIds = dto.getRolsIds();

            userRoles.stream()
                    .filter(userRol -> !rolesIds.contains(userRol.getRol().getId()))
                    .forEach(userRolRepository::delete);

            rolesIds.stream()
                    .filter(rolId -> userRoles.stream().noneMatch(userRol -> userRol.getRol().getId().equals(rolId)))
                    .forEach(rolId -> {
                        Rol rol = rolRepository.findById(rolId).orElse(null);
                        if (rol != null) {
                            User_Rol userRol = new User_Rol();
                            userRol.setUser(user);
                            userRol.setRol(rol);
                            userRol.setCreatedAt(LocalDateTime.now());
                            userRol.setActive(true);

                            userRolRepository.save(userRol);
                        }
                    });
        }


        userRepository.save(user);

        return userMapper.toDto(user);
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<UserDTO> getUserById(Integer id) {
        return userRepository.findById(id).map(userMapper::toDtoDetailed);
    }


    @Override
    public void delete(Integer id) {
        User user= userRepository.findById(id).orElse(null);
        if (user != null) {
            user.getRols().clear();
        }
        userRepository.deleteById(id);
    }

    @Transactional
    public void deleteRolesByUser(User user) {
        String jpql = "DELETE FROM User_Rol ur WHERE ur.user = :user";
        entityManager.createQuery(jpql)
                .setParameter("user", user)
                .executeUpdate();
    }
}

