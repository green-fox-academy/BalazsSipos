package com.balazssipos.rest.models.arrayHandler;

public class ArrayHandlerError {
  private String errormsg;

  public ArrayHandlerError(String errormsg) {
    this.errormsg = errormsg;
  }

  public String getErrormsg() {
    return errormsg;
  }

  public void setErrormsg(String errormsg) {
    this.errormsg = errormsg;
  }
}
