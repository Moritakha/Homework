package com.example.Homework.domain.entities;

import jakarta.persistence.*;

import java.sql.Timestamp;

@Entity
@Table(name = "User_Rols")
public class User_Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column(name = "active", nullable = false)
    private Boolean active;
    @Column(name = "create_at", nullable = false)
    private Timestamp createdAt;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @ManyToOne
    @JoinColumn(name = "rol_id", referencedColumnName = "id")
    private Rol rol;

    public User_Rol(){
    }

    public User_Rol(Boolean active, Timestamp createdAt) {
        this.active = active;
        this.createdAt = createdAt;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }


    @Override
    public String toString() {
        return "UserRol{" +
                "id=" + id +
                ", active=" + active +
                ", created_at=" + createdAt +
                ", user=" + user +
                ", rol=" + rol +
                '}';
    }
}
