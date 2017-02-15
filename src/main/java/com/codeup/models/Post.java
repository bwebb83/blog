package com.codeup.models;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * Created by Brian on 2/8/17.
 */
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    @NotBlank(message="Title cannot be empty.")
    private String title;

    @Column(nullable=false, length = 2000)
    @NotBlank(message="The body of the post cannot be empty.")
    @Size(min=5, message ="The body must be at least 5 characters.")
    private String body;

    @ManyToOne
    @JoinColumn (name="user_id")
    @JsonManagedReference
    private User user;


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }



    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public Post(Long id,String title, String body) {
        this.title = title;
        this.body = body;
        this.id = id;
    }

    public Post(){}


}
