package com.balazssipos.oxe2.models.DTOs;

public class StatusMessageError {
  private String error;

  public StatusMessageError() {
  }

  public StatusMessageError(String error) {
    this.error = error;
  }

  public String getError() {
    return error;
  }

  public void setError(String error) {
    this.error = error;
  }
}
