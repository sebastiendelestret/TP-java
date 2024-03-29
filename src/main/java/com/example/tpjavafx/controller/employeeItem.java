package com.example.tpjavafx.controller;

import com.example.tpjavafx.Objects.Employe;
import com.example.tpjavafx.Objects.Posts;
import javafx.scene.control.ChoiceBox;

public class employeeItem {

    private final Employe employee;
    private final ChoiceBox<String> post;

    public employeeItem(Employe employee) {
        this.employee = employee;
        this.post = new ChoiceBox<String>();
        for (Posts posts : Posts.values()) {
            this.post.getItems().add(posts.toString());
        }
        this.post.setValue(employee.getPost());
    }

    public String getName() {
        return employee.getName();
    }

    public String getFirstName() {
        return employee.getFirstname();
    }

    public Integer getNbSoirs(){ return employee.getNbSoirs();}

    public Employe getEmployee() {
        return employee;
    }

    public ChoiceBox<String> getPost() {
        return post;
    }


}
