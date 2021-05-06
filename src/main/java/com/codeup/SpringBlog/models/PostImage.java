package com.codeup.SpringBlog.models;

import javax.persistence.*;

@Entity
@Table(name="post_images")
public class PostImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private long id;

    @Column(nullable = false, length = 100)
    private String imageTitle;

    @Column(nullable = false, length = 1000)
    private String url;

    @ManyToOne
    private Post post;



    public PostImage() {
    }

    public PostImage(String imageTitle, String url, Post post) {
        this.imageTitle = imageTitle;
        this.url = url;
        this.post = post;
    }




    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public void setImageTitle(String imageTitle) {
        this.imageTitle = imageTitle;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
