package com.example.tpjavafx.Objects;

public class Employe {
    private String name;
    private String firstname;
    public int salary;
    private String post;

    public Employe(String name_, String firstname_,String _post) {
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
}
