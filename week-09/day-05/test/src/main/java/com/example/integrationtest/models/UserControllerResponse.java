package com.example.integrationtest.models;

public class UserControllerResponse {
  private String response;
  private String message;

  public UserControllerResponse() {
  }

  public UserControllerResponse(String response, String message) {
    this.response = response;
    this.message = message;
  }

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
