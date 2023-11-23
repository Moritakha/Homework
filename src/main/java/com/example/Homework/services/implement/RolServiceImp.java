package com.example.Homework.services.implement;

import com.example.Homework.domain.entities.Rol;
import com.example.Homework.domain.entities.User;
import com.example.Homework.dto.RolDTO;
import com.example.Homework.repositories.RolRepository;
import com.example.Homework.services.RolService;
import com.example.Homework.services.mapper.RolMapper;
import jakarta.persistence.Version;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RolServiceImp implements RolService {

    private final RolRepository rolRepository;
    private final RolMapper rolMapper;

    public RolServiceImp(RolRepository rolRepository, RolMapper rolMapper) {
        this.rolRepository = rolRepository;
        this.rolMapper = rolMapper;
    }

    @Override
    public List<RolDTO> listRols() {
        return rolRepository.findAll()
                .stream()
                .map(rolMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public List<RolDTO> listRolsConUsers() {
        List<Rol> rols = rolRepository.findAll();

        List<RolDTO> rolsDTO = new ArrayList<>();

        for (Rol rol : rols) {
            RolDTO rolDTO = new RolDTO();
            rolDTO.setId(rol.getId());
            rolDTO.setNombre(rol.getNombre());

            List<String> nombresUsers = rol.getUsers().stream()
                    .map(User::getUsername)
                    .collect(Collectors.toList());

            rolDTO.setNombreUsers(nombresUsers);

            rolsDTO.add(rolDTO);
        }

        return rolsDTO;
    }

    @Override
    public RolDTO save(RolDTO dto) {
        Rol rol = rolRepository.save(rolMapper.toEntity(dto));
        return rolMapper.toDto(rol);
    }

    @Override
    public Optional<RolDTO> getRolById(Integer id) {
        return rolRepository.findById(id).map(rolMapper::toDto);
    }



    @Override
    public void delete(Integer id) {
        rolRepository.deleteById(id);
    }

}