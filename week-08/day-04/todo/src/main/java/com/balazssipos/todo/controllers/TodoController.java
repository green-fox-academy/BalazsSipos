package com.balazssipos.todo.controllers;

import com.balazssipos.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/todo")
public class TodoController {


  @Qualifier("todoRepository")
  @Autowired
  private TodoRepository todoRepository;

  @GetMapping(value={"/","/list"})
//  @ResponseBody
  public String list(Model model) {
    model.addAttribute("todos", this.todoRepository.findAll());
    return "todolist";
  }
}
