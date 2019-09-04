package com.balazssipos.rest.controllers;


import com.balazssipos.rest.models.ArrayHandlerError;
import com.balazssipos.rest.models.LogCollectorDTO;
import com.balazssipos.rest.models.Receive;
import com.balazssipos.rest.services.ArrayHandlerServiceImpl;
import com.balazssipos.rest.services.LogServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class MainController {

  private ArrayHandlerServiceImpl arrayHandlerServiceImpl;
  private LogServiceImpl logServiceImpl;

  @Autowired
  public MainController(ArrayHandlerServiceImpl arrayHandlerServiceImpl, LogServiceImpl logServiceImpl) {
    this.arrayHandlerServiceImpl = arrayHandlerServiceImpl;
    this.logServiceImpl = logServiceImpl;
  }

  @GetMapping("/")
  public String renderIndex() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public HashMap Doubling(@RequestParam(value = "input", required = false) String inputNumber) {
    this.saveLog("/doubling", "imput=" + inputNumber);
    if(inputNumber != null) {
      HashMap<String, Integer> outputObject = new HashMap<>();
      outputObject.put("received", Integer.parseInt(inputNumber));
      outputObject.put("result", Integer.parseInt(inputNumber) * 2);
      return outputObject;
    } else {
      HashMap<String, String> errorObject = new HashMap<>();
      errorObject.put("error", "Please provide an input!");
      return errorObject;
    }
  }

  @PostMapping("/arrays")
  public ResponseEntity arrayHandling(@RequestBody() Receive receivedObject) {
    this.saveLog("/arrays", receivedObject.toString());
    if(this.arrayHandlerServiceImpl.inputValidator(receivedObject)) {
      return ResponseEntity.status(200).body(this.arrayHandlerServiceImpl.arrayHandler(receivedObject));
    } else {
      return ResponseEntity.status(400).body(new ArrayHandlerError("Please provide numbers, and what to do with the " +
              "numbers!"));
    }

  }

  @GetMapping("/log")
  public ResponseEntity createLogs() {
    LogCollectorDTO logCollectorDTO = this.logServiceImpl.createLogCollector();
    return ResponseEntity.status(200).body(logCollectorDTO);
  }

  private void saveLog(String endpoint, String data) {
    this.logServiceImpl.saveLog(endpoint, data);
  }
}