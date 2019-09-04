package com.balazssipos.rest.services;

import com.balazssipos.rest.models.arrayHandler.ArrayHandlerError;
import com.balazssipos.rest.models.arrayHandler.Receive;
import com.balazssipos.rest.models.arrayHandler.ResultDTO;
import org.springframework.stereotype.Service;

@Service
public class ArrayHandlerServiceImpl implements ArrayHandlerService {
  @Override
  public ResultDTO arrayHandler(Receive receiveObject) {
    ResultDTO resultDTO = new ResultDTO();
    if(receiveObject.getWhat().equals("sum")) {
      resultDTO.setResult(receiveObject.sum());
    } else if(receiveObject.getWhat().equals("multiple")) {
      resultDTO.setResult(receiveObject.multiply());
    } else if(receiveObject.getWhat().equals("double")) {
      resultDTO.setResult(receiveObject.doubleNumbers());
    }
    return resultDTO;
  }

  public boolean inputValidator(Receive receivedObject) {
    if((receivedObject.getWhat() != null && receivedObject.getNumbers() != null) && (receivedObject.getWhat().equals(
            "sum") || receivedObject.getWhat().equals("multiple") || receivedObject.getWhat().equals("double"))) {
      return true;
    }
    return false;
  }
}
