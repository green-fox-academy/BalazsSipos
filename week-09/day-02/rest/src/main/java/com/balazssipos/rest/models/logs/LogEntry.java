package com.balazssipos.rest.models.logs;


import javax.persistence.Entity;
import java.time.LocalDateTime;

@Entity
public class LogEntry {
  private LocalDateTime createdAt;
  private String endpoint;
  private String data;

  public LogEntry() {
  }

  public LogEntry(LocalDateTime createdAt, String endpoint, String data) {
    this.createdAt = createdAt;
    this.endpoint = endpoint;
    this.data = data;
  }

  public LocalDateTime getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(LocalDateTime createdAt) {
    this.createdAt = createdAt;
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
