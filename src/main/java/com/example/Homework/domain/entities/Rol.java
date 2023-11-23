package com.example.Homework.domain.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import org.antlr.v4.runtime.misc.NotNull;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "rol")
public class Rol {

    @Id
    @SequenceGenerator(name = "rol_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "rol_sequence")
    @Column(nullable = false)
    private Integer id;

    @Column(name = "nombre", length = 100, nullable = false)
    private String nombre;

    @ManyToMany(mappedBy = "rols")
    private Set<User> users = new HashSet<>();

    public Rol(){
    }

    public Rol(String nombre, Set<User> users) {
        this.nombre = nombre;
        this.users = users;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Rol{" +
                "id=" + id +
                ", name='" + nombre + '\'' +
                ", users=" + users +
                '}';
    }
}
