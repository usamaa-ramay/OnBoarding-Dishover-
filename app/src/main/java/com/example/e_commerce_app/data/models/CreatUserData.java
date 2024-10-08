package com.example.e_commerce_app.data.models;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.String;

public class CreatUserData implements Serializable {
  private String password;

  private String role;

  private String creationAt;

  private String name;

  private String avatar;

  private Integer id;

  private String email;

  private String updatedAt;

  public String getPassword() {
    return this.password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  public String getRole() {
    return this.role;
  }

  public void setRole(String role) {
    this.role = role;
  }

  public String getCreationAt() {
    return this.creationAt;
  }

  public void setCreationAt(String creationAt) {
    this.creationAt = creationAt;
  }

  public String getName() {
    return this.name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAvatar() {
    return this.avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public Integer getId() {
    return this.id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public String getEmail() {
    return this.email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getUpdatedAt() {
    return this.updatedAt;
  }

  public void setUpdatedAt(String updatedAt) {
    this.updatedAt = updatedAt;
  }
}
