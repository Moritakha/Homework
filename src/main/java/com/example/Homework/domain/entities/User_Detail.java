package com.example.Homework.domain.entities;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Date;
@Entity
@Table(name = "user_detail")
public class User_Detail {
    @Id
    @SequenceGenerator(name = "user_detail_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_detail_sequence")
    @Column(nullable = false)
    private Integer id;
    @Column(name = "first_name", length = 100, nullable = false)
    private String firstName;
    @Column(name = "last_name", length = 100, nullable = false)
    private String lastName;
    @Column(name = "age")
    private Integer age;
    @Column(name = "birth_day")
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    public User_Detail(){
    }

    public User_Detail(String firstName, String lastName, Integer age, LocalDate birthday, User user) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.birthday = birthday;
        this.user = user;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getBirthay() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", age=" + age +
                ", birth_day=" + birthday +
                ", user=" + user +
                '}';
    }
}
