package com.codeup.models;

import javax.persistence.*;
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
    private String title;

    @Column(nullable=false, length = 2000)
    private String body;

    @ManyToOne
    @JoinColumn (name="user_id")
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
