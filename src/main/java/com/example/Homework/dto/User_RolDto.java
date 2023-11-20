package com.example.Homework.dto;

import java.sql.Timestamp;

public class User_RolDto {

    private Long id;
    private Boolean active;
    private Timestamp createdAt;
    private UserDto user;
    private RolDto rol;

    public User_RolDto() {
    }



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public UserDto getUser() {
        return user;
    }

    public void setUser(UserDto user) {
        this.user = user;
    }

    public RolDto getRol() {
        return rol;
    }

    public void setRol(RolDto rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "UserRolDTO{" +
                "id=" + id +
                ", active=" + active +
                ", createdAt=" + createdAt +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
}