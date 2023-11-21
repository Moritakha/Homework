package com.example.Homework.dto;

import java.util.List;

public class RolDTO {

    private Integer id;
    private String nombre;
    private List<String> nombreUsers;

    public RolDTO() {
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

    public List<String> getNombreUsers() {
        return nombreUsers;
    }

    public void setNombreUsers(List<String> nombreUsers) {
        this.nombreUsers = nombreUsers;
    }

    @Override
    public String toString() {
        return "RolDTO{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", nombreUsers=" + nombreUsers +
                '}';
    }
}