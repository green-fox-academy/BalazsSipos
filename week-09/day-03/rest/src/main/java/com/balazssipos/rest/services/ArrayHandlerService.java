package com.balazssipos.rest.services;

import com.balazssipos.rest.models.Receive;
import com.balazssipos.rest.models.ResultDTO;

import java.util.List;

public interface ArrayHandlerService {
  public ResultDTO arrayHandler(Receive receiveObject);
}