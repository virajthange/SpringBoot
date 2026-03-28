package com.example.__student_management_system.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RegisterDTO {
    private String name;
    private String email;
    private Long phone;
    private String password;
}
