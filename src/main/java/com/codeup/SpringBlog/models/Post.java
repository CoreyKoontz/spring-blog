package com.codeup.SpringBlog.models;

import javax.persistence.*;

@Entity
@Table(name="posts") // Applies to entire table. Here we are just naming it
public class Post {

    @Id // PRIMARY KEY
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementing
    @Column(columnDefinition = "INT UNSIGNED")
    private long id;

    // @Column allows us to customize the data type and values
    @Column(nullable = false, length = 200)// VARCHAR(200) NOT NULL
    private String title;

    //@ColumnDefinition = "TEXT" - Would change the data type to TEXT instead of VARCHAR
    // *** Be aware that ColumnDefinition may override other specifications
    @Column(columnDefinition = "TEXT NOT NULL")
    private String body;

    // One-To-One Relationship to post_details
    @OneToOne(cascade = CascadeType.ALL)
    private PostDetails postDetails;

    public Post() {
    }

    public Post( String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body, PostDetails postDetails) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
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

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }
}
