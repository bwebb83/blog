package com.codeup.models;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Brian on 2/13/17.
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, unique = true)
    @Email(message = "Enter a valid email address")
    @NotBlank(message="Enter an email")
    private String email;

    @Column(nullable = false, unique = true)
    @NotBlank(message="Enter a username")
    private String username;

    @Column(nullable = false)
    @NotBlank(message="You must enter a password")
    @Size(min=8, message ="Your password shold have at least 8 characters")
    @JsonIgnore
    private String password;

    @OneToMany(cascade=CascadeType.ALL, mappedBy="user")
    @JsonBackReference
    private List <Post> posts;

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public User(User user) {
        id = user.id;
        email = user.email;
        username = user.username;
        password = user.password;
        posts=user.posts;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setId(long id) {
        this.id = id;
    }
    public Long getId(){
        return id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}