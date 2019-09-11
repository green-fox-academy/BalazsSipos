package com.balazssipos.fog.models.DTOs;

public abstract class StatusMessage {
  private String status;

  public StatusMessage() {
  }

  public StatusMessage(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
