package com.balazssipos.oxe.models.DTOs;

public class MessageDTO {
  private String errorMessage;
  private String successMessage;

  public MessageDTO() {
  }

  public MessageDTO(String errorMessage, String successMessage) {
    this.errorMessage = errorMessage;
    this.successMessage = successMessage;
  }

  public String getErrorMessage() {
    return errorMessage;
  }

  public void setErrorMessage(String errorMessage) {
    this.errorMessage = errorMessage;
  }

  public String getSuccessMessage() {
    return successMessage;
  }

  public void setSuccessMessage(String successMessage) {
    this.successMessage = successMessage;
  }
}
