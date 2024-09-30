package com.example.userscrud.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Size(min = 2, message = "name should have at least 2 characters.")
    private String name;

    @NotBlank(message = "email is blank, please enter valid email address.")
    @JsonProperty("email_address")
    private String email;

    @JsonIgnore
    private String password;

    @OneToMany(mappedBy = "user")
    private List<Post> posts;

}