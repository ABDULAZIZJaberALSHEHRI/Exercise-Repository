package com.example.exerciserepository.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@Entity
@NoArgsConstructor
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "name should not be empty!")
    @Size(min = 4, message = "name length should be more than 4")
    @Pattern(regexp = "^[a-z A-Z]+$",message = "name must contain only characters")
    @Column(columnDefinition = "varchar(20) not null")
    private String name;

    @NotEmpty(message = "name should not be empty!")
    @Size(min = 4, message = "name length should be more than 4")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "Password should not be empty!")
    @Column(columnDefinition = "varchar(15) not null")
    private String password;

    @NotEmpty(message = "Email should not be empty")
    @Email(message = "not valid email!")
    @Column(columnDefinition = "varchar(30) unique")
    private String email;


//  @Column(columnDefinition = "varchar(11) not null check (role='user' or role ='admin')")
    @NotEmpty(message = "Role cannot be empty!")
    @Pattern(regexp = "^(user|admin)$",message = "role must match : 'user or admin' !")
    @Column(columnDefinition = "varchar(11) not null")
    private String role;

    @NotNull(message = "Age should not be empty!")
    @Positive(message = "age must be positive number")
    @Column(columnDefinition = "int not null")
    private int age;


}
