package com.balazssipos.oxe2.controllers;

import com.balazssipos.oxe2.models.DTOs.StatusMessageError;
import com.balazssipos.oxe2.models.DTOs.StatusMessageOk;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GrootRestController {
  @GetMapping("/groot")
  public ResponseEntity translate(@RequestParam(value = "message", required = false) String message) {
    if(message != null) {
      return ResponseEntity.status(200).body(new StatusMessageOk(message, "I am Groot!"));
    } else {
      return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new StatusMessageError("I am Groot!"));
    }
  }
}
