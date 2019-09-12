package com.balazssipos.oxe2.models.DTOs;

public class StatusMessageOk {
  private String received;
  private String translated;

  public StatusMessageOk() {
  }

  public StatusMessageOk(String received, String translated) {
    this.received = received;
    this.translated = translated;
  }

  public String getReceived() {
    return received;
  }

  public void setReceived(String received) {
    this.received = received;
  }

  public String getTranslated() {
    return translated;
  }

  public void setTranslated(String translated) {
    this.translated = translated;
  }
}
