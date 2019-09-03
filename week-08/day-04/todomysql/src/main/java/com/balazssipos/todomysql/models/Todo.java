package com.balazssipos.todomysql.models;

import org.apache.tomcat.jni.Local;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Todo {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String title;
  private boolean urgent;
  private boolean done;
  private LocalDateTime dateOfCreation;
  private LocalDateTime dueDate;

  @ManyToOne
  private Assignee assignee;

  public Todo() {
    this("", false, false, LocalDateTime.now());
  }

  public Todo(String title) {
    this(title, false, false, LocalDateTime.now());
  }

  public Todo(String title, boolean urgent, boolean done, LocalDateTime dueDate) {
    this.title = title;
    this.urgent = urgent;
    this.done = done;
    this.dateOfCreation = LocalDateTime.now();
    this.dueDate = dueDate;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public boolean isUrgent() {
    return urgent;
  }

  public void setUrgent(boolean urgent) {
    this.urgent = urgent;
  }

  public boolean isDone() {
    return done;
  }

  public void setDone(boolean done) {
    this.done = done;
  }

    public Assignee getAssignee() {
        return assignee;
    }

    public void setAssignee(Assignee assignee) {
        this.assignee = assignee;
    }

  public String getDateOfCreation() {
    String formatDateTime = this.dateOfCreation.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    return formatDateTime;
  }

  public void setDateOfCreation(String dateOfCreation) {
    LocalDateTime formatDateTime = LocalDateTime.parse(dateOfCreation, DateTimeFormatter.ofPattern("yyyy-MM-ddTHH:mm"));
    System.out.println(dueDate);
    this.dateOfCreation = formatDateTime;
  }

  public LocalDateTime getDueDate() {
    return dueDate;
  }

  public void setDueDate(String dueDate) {
//    System.out.println("IIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII");
    LocalDateTime formatDateTime = LocalDateTime.parse(dueDate, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
    System.out.println(dueDate);
    this.dueDate = formatDateTime;
  }

  @Override
  public String toString() {
    return "Todo{" +
            "id=" + id +
            ", title='" + title + '\'' +
            ", urgent=" + urgent +
            ", done=" + done +
            '}';
  }
}
