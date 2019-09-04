package com.balazssipos.rest.models;

public class LogEntryDTO {
  private int id;
  private String endpoint;
  private String data;

  public LogEntryDTO(int id, String endpoint, String data) {
    this.id = id;
    this.endpoint = endpoint;
    this.data = data;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getEndpoint() {
    return endpoint;
  }

  public void setEndpoint(String endpoint) {
    this.endpoint = endpoint;
  }

  public String getData() {
    return data;
  }

  public void setData(String data) {
    this.data = data;
  }
}
