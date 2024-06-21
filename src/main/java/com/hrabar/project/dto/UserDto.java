package com.hrabar.project.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {

    @NotEmpty
    private String username;

    @NotEmpty
    private String country;

    @NotEmpty
    private String zip_code;

    @NotEmpty
    private String city;

    @NotEmpty
    @Email
    private String email;

    @NotEmpty
    private String first_name;

    @NotEmpty
    private String last_name;

    @NotEmpty
    private String password;
}
