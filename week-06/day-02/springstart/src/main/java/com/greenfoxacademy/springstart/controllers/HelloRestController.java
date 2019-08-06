package com.greenfoxacademy.springstart.controllers;

import com.greenfoxacademy.springstart.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class HelloRestController {
    AtomicLong atomicLong = new AtomicLong(1);

    @GetMapping(value="/greeting")
    public Greeting greeting(@RequestParam(value="name") String name) {
        return new Greeting(atomicLong.getAndIncrement(),"Hello, " + name + "!");
    }
}
