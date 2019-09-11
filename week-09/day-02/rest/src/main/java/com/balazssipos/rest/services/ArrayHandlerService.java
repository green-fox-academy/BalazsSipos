package com.balazssipos.rest.services;

import com.balazssipos.rest.models.arrayHandler.Receive;
import com.balazssipos.rest.models.arrayHandler.ResultDTO;

import java.util.List;

public interface ArrayHandlerService {
  public ResultDTO arrayHandler(Receive receiveObject);
  public boolean inputValidator(Receive receivedObject);
}