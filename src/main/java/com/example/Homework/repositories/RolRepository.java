package com.example.Homework.repositories;

import com.example.Homework.domain.entities.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


public interface RolRepository extends JpaRepository<Rol, Long> {

}