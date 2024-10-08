package com.example.e_commerce_app.data.models;

import java.io.Serializable;
import java.lang.String;

public class AuthToken implements Serializable {
  private String access_token;

  private String refresh_token;

  public String getAccess_token() {
    return this.access_token;
  }

  public void setAccess_token(String access_token) {
    this.access_token = access_token;
  }

  public String getRefresh_token() {
    return this.refresh_token;
  }

  public void setRefresh_token(String refresh_token) {
    this.refresh_token = refresh_token;
  }
}
