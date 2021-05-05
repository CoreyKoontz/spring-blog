package com.codeup.SpringBlog.models;

import javax.persistence.*;

@Entity
@Table(name = "post_details")
public class PostDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // auto incrementing
    @Column(columnDefinition = "INT UNSIGNED")
    private long id;



}
