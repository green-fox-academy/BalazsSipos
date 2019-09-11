package com.example.integrationtest.controllers;

import com.example.integrationtest.models.User;
import com.example.integrationtest.models.UserControllerResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

  @PostMapping("/users")
  public ResponseEntity<UserControllerResponse> addNewUser(@RequestBody User user) {
    if (user.getEmail() == null || user.getEmail().length() == 0) {
      return new ResponseEntity(new UserControllerResponse("fail", "Email is missing"), HttpStatus.BAD_REQUEST);
    } else {
      return new ResponseEntity(new UserControllerResponse("success", "User is added"), HttpStatus.OK);
    }
  }
}
