package com.codeup.SpringBlog.models;

import javax.persistence.*;

@Entity
@Table(name = "dogs", uniqueConstraints = @UniqueConstraint(name = "UK_name_AND_reside_state", columnNames = {"name", "resideState"}))
public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(columnDefinition = "INT UNSIGNED")
    private long id; // Can we add a length to int? or tinyint?

    @Column(columnDefinition = "TINYINT(3) UNSIGNED NOT NULL ")
    private int age;

    @Column(nullable = false, length = 200, unique = true)
    private String name;

    @Column(columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String resideState;

    public Dog() {
    }

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
