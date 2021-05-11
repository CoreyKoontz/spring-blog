package com.codeup.SpringBlog.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "posts") // Applies to entire table. Here we are just naming it
public class Post {

    // ------------------------------------------------------ Fields/Properties:
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
    @OneToOne(cascade = CascadeType.ALL )
    private PostDetails postDetails;

    // One-To-Many Relationship to post_images
    @OneToMany(
            cascade = CascadeType.ALL, // allows us to CRUD images through posts
            mappedBy = "post", // Prevents the unneeded mapping table
            orphanRemoval = true // removes an image that has no owner
    )
    private List<PostImage> postImages;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    // ------------------------------------------------------ Constructors:
    public Post() {
    }

    public Post(String title, String body) {
        this.title = title;
        this.body = body;
    }

    public Post(long id, String title, String body) {
        this.id = id;
        this.title = title;
        this.body = body;
    }

    public Post(String title, String body, PostDetails postDetails) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
    }

    public Post(long id, String title, String body, PostDetails postDetails) {
        this.id = id;
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
    }

    public Post(String title, String body, PostDetails postDetails, List<PostImage> postImages) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.postImages = postImages;
    }

    public Post(String title, String body, PostDetails postDetails, User user) {
        this.title = title;
        this.body = body;
        this.postDetails = postDetails;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

    public PostDetails getPostDetails() {
        return postDetails;
    }

    public void setPostDetails(PostDetails postDetails) {
        this.postDetails = postDetails;
    }

    public List<PostImage> getPostImages() {
        return postImages;
    }

    public void setPostImages(List<PostImage> postImages) {
        this.postImages = postImages;
    }
}
