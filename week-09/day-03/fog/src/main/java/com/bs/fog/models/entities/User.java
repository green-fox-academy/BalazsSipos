package com.bs.fog.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {
  @Id
  @GeneratedValue
  private int id;
  private String name;
  private String password;
  private int couId;

  public User() {
  }

  public User(String name, String password, int couId) {
    this.name = name;
    this.password = password;
    this.couId = couId;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public int getCouId() {
    return couId;
  }

  public void setCouId(int couId) {
    this.couId = couId;
  }

  @Override
  public String toString() {
    return "User{" + "id=" + id + ", name='" + name + '\'' + ", password='" + password + '\'' + ", couId=" + couId + '}';
  }
}
