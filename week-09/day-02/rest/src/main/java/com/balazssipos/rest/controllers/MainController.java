package com.balazssipos.rest.controllers;

import com.balazssipos.rest.models.Greeting.Greeting;
import com.balazssipos.rest.models.Greeting.GreetingError;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;

@Controller
public class MainController {
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
}
