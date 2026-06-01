package com.spider.__BlogPlatform.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Integer id;
    private String username;
    private String email;
    private String name;
    private String password;

    @Override
    public String toString() {
        return "UserDTO{" +
                "username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", fullname='" + name + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
