package com.balazssipos.todomysql.models;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Assignee {
    @Id
    @GeneratedValue
    Integer id;
    String name;
    String email;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "assignee_id")
    List<Todo> todoList;

    public Assignee() {
        this("", "");
    }

    public Assignee(String name, String email) {
        this.name = name;
        this.email = email;
        this.todoList = new ArrayList<>();
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Assignee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public void addTodo(Todo todo) {
        this.todoList.add(todo);
    }

    public List<Todo> getTodoList() {
        return todoList;
    }
}
