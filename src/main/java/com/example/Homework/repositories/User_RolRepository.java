package com.example.Homework.repositories;

import com.example.Homework.domain.entities.User;
import com.example.Homework.domain.entities.User_Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface User_RolRepository extends JpaRepository<User_Rol, Long> {
    @Query("SELECT ur FROM User_Rol ur WHERE ur.user = :user")
    List<User_Rol> findByUser(@Param("user") User user);
}
