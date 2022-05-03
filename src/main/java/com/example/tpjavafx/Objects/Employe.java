package com.example.tpjavafx.Objects;

/**
 * La classe Employé d'écris un employé du restaurant, ses attributs ...
 */

public class Employe {
    private String name;
    private String firstname;
    private String post;
    private long id;

    public Employe(String name_, String firstname_, String _post, long id) {
        this.name = name_;
        this.firstname = firstname_;
        this.post = _post;
    }

    public String getPost() {
        return post;
    }

    public String getName() {
        return name;
    }

    public String getFirstname() {
        return firstname;
    }

    public long getId() {
        return id;
    }

    public void setPost(String post) {
        this.post = post;
    }
}
