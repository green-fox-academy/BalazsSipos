package com.balazssipos.rest.controllers;

import com.balazssipos.rest.models.Greeting.Greeting;
import com.balazssipos.rest.models.Greeting.GreetingError;
import com.balazssipos.rest.models.appenda.AppendA;
import com.balazssipos.rest.models.arrayHandler.ArrayHandlerError;
import com.balazssipos.rest.models.arrayHandler.Receive;
import com.balazssipos.rest.models.models.doUntil.DoUntil;
import com.balazssipos.rest.models.models.doUntil.Result;
import com.balazssipos.rest.services.ArrayHandlerServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@Controller
public class MainController {
  private ArrayHandlerServiceImpl arrayHandlerServiceImpl;

  @Autowired
  public MainController(ArrayHandlerServiceImpl arrayHandlerServiceImpl) {
    this.arrayHandlerServiceImpl = arrayHandlerServiceImpl;
  }

  @GetMapping("/")
  public String renderIndex() {
    return "index";
  }

  @GetMapping("/doubling")
  @ResponseBody
  public HashMap Doubling(@RequestParam(value = "input", required = false) String inputNumber) {
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

  @GetMapping("/greeter")
  @ResponseBody
  public ResponseEntity greeting(@RequestParam(value = "name", required = false) String name,
                                 @RequestParam(value = "title", required = false) String title) {

    if(name != null && title != null) {
      Greeting greeting = new Greeting(name, title);
      return ResponseEntity.status(200).body(greeting);
    } else if(name != null && title == null) {
      GreetingError greetingError = new GreetingError("Please provide a name!");
      return ResponseEntity.status(400).body(greetingError);
    } else if(name == null && title != null) {
      GreetingError greetingError = new GreetingError("Please provide a title!");
      return ResponseEntity.status(400).body(greetingError);
    } else {
      GreetingError greetingError = new GreetingError("Please provide a name and a title!");
      return ResponseEntity.status(400).body(greetingError);
    }
  }

  @GetMapping("/appenda/{appendable}")
  public ResponseEntity appendA(@PathVariable("appendable") String appendable) {
    AppendA appendA = new AppendA(appendable);
    appendA.setAppended(appendable + "a");
    return ResponseEntity.status(400).body(appendA);
  }

  @PostMapping("/dountil/{action}")
  public ResponseEntity doUntil(@PathVariable("action") String action, @RequestBody() DoUntil doUntil) {
    if(action.equals("sum")) {
      int sumNumbers = doUntil.sumNumbers();
      return ResponseEntity.status(200).body(new Result(sumNumbers));
    } else if(action.equals("factor")) {
      int sumNumbers = doUntil.factorNumbers();
      return ResponseEntity.status(200).body(new Result(sumNumbers));
    }
    if(doUntil.getUntil() == 0) {
      return ResponseEntity.status(400).body(new Error("Please provide a number!"));
    }
    return ResponseEntity.status(400).body(new Error("Please provide a number!"));
  }

  @PostMapping("/arrays")
  public ResponseEntity arrayHandling(@RequestBody() Receive receivedObject) {
    if(this.arrayHandlerServiceImpl.inputValidator(receivedObject)) {
      return ResponseEntity.status(200).body(this.arrayHandlerServiceImpl.arrayHandler(receivedObject));
    } else {
      return ResponseEntity.status(400).body(new ArrayHandlerError("Please provide numbers, and what to do with the " +
              "numbers!"));
    }
  }
}
