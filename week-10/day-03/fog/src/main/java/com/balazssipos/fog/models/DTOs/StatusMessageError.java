package com.balazssipos.fog.models.DTOs;

public class StatusMessageError extends StatusMessage {
  private String message;

  public StatusMessageError(String message) {
    super("error");
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
