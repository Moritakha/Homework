package com.example.Homework.domain.entities;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Entity
@Table(name = "usuario")
public class User {

    @Id
    @SequenceGenerator(name = "user_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_sequence")
    @Column(nullable = false)
    private Integer id;

    @Column(name = "username", length = 150, nullable = false)
    private String username;

    @Column(name = "password", length = 150, nullable = false)
    private String password;

    @Column(name = "email", length = 150, nullable = false)
    private String email;

    @Column(name = "created_at")
    private String createdAt;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User_Detail userDetail;

    @ManyToMany
    @JoinTable(
            name = "user_Rol",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "rol_id")
    )
    private List<Rol> rols = new ArrayList<>();

    public User() {}

    public User(String username, String password, String email, String createdAt, User_Detail userDetail, List<Rol> rols) {
        this.username = username;
        this.password = password;
        this.email = email;
        this.createdAt = createdAt;
        this.userDetail = userDetail;
        this.rols = rols;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public User_Detail getUserDetail() {
        return userDetail;
    }

    public void setUserDetail(User_Detail userDetail) {
        this.userDetail = userDetail;
    }

    public List<Rol> getRols() {
        return rols;
    }

    public void setRols(List<Rol> rols) {
        this.rols = rols;
    }
}