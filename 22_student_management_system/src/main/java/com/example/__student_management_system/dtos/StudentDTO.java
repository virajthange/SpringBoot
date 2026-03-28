package com.example.__student_management_system.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class StudentDTO {
    private Integer id;
    private String name;
    private String email;
    private List<Integer> courseIds;
}
