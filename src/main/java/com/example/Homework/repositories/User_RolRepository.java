package com.example.Homework.repositories;

import com.example.Homework.domain.entities.User_Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface User_RolRepository extends JpaRepository<User_Rol, Long> {
}
