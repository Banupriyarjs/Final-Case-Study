package com.perscholas.twistntreats.formbean;

import jakarta.persistence.Entity;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import java.util.Date;

@Getter
@Setter
public class RegisterUserFormBean {
    @Email(message="Email must be a valid email addreas")
    private String email;

    @Length(min=8,message="Password must be at least 8 characters long ")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$",message="Password must contain at least one lowercase letter, one uppercase letter, and one digit")
    private String password;

    @NotEmpty(message="Confirm Password cannot be empty")
    private String confirmPassword;


    private String firstName;

    private String lastName;

    private String address;

    private String city;

    private String areaCode;

    private String phone;

    private Date createdDate;
}
