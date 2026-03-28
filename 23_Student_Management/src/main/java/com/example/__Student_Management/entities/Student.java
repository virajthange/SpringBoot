package com.example.__student_management_system.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Controller;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "student_table")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @Column(unique = true)
    private String email;
    @Column(unique = true, length = 10)
    private Long phone;
    private String password;
    @Column(updatable = false)
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @ManyToMany
    @JoinTable( joinColumns = @JoinColumn(name = "stud_id") , inverseJoinColumns = @JoinColumn(name = "course_id"))
    private List<Course> courses;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

//    left part represents the class in which you are defining the association.

//    public void setPassword(String password) {
//        this.password = password;
//    }
}
