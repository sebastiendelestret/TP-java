package com.example.tpjavafx.controller;

public class employeeItem {

    private final String name;
    private final String firstName;
    private final String post;

    public employeeItem(String name, String firstName, String post) {
        this.name = name;
        this.firstName = firstName;
        this.post = post;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getPost() {
        return post;
    }
}
