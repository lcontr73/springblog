package com.example.codeup.springblog;

import com.example.codeup.springblog.model.User;

import javax.persistence.*;


@Entity
@Table(name = "posts")
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String title;

    @Column(nullable = false, columnDefinition = "Text")
    private String body;

    @ManyToOne
    @JoinColumn (name = "user_id") //to specify the foreign key
    private User user;

    public Post() {

    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public User getUser() {
        return user;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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



    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }


    public void setUser(User user) {
        this.user = user;
    }
}
