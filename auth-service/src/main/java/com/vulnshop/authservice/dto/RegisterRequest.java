package com.vulnshop.authservice.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

    @Data
    public class RegisterRequest {

        @NotBlank(message = "Username is Required")
        @Size(min = 3 , max = 20)
        private String username;

        @NotBlank(message ="email is required")
        @Email(message = "Must be a Valid email")
        private String email;

        @NotBlank(message = "password is required")
        @Size(min = 6, message = "password must be atleast 5 characters")
        private String password;



    }
    

