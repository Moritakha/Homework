package com.example.Homework.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UserDTO {

    private Integer id;
    private String username;
    private String password;
    private String email;
    private LocalDateTime createdAt;
    private String firstName;
    private String lastName;
    private Integer age;
    private LocalDate birthday;
    private List<Integer> rolsIds;

    public UserDTO() {
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public List<Integer> getRolsIds() {
        return rolsIds;
    }

    public void setRolsIds(List<Integer> rolsIds) {
        this.rolsIds = rolsIds;
    }
}
