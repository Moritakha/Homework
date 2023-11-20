package com.example.Homework.dto;

import java.sql.Timestamp;

public class User_RolDTO {

    private Long id;
    private Boolean active;
    private Timestamp createdAt;
    private UserDTO user;
    private RolDTO rol;

    public User_RolDTO() {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    public RolDTO getRol() {
        return rol;
    }

    public void setRol(RolDTO rol) {
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