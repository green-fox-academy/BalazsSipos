package com.balazssipos.todomysql.controllers;

import com.balazssipos.todomysql.models.Todo;
import com.balazssipos.todomysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/todo")
public class TodoController {


  @Qualifier("todoRepository")
  @Autowired
  private TodoRepository todoRepository;

  @GetMapping(value={"/","/list"})
//  @ResponseBody
  public String list(Model model, @RequestParam(value = "isActive", required = false) String isActive) {
    if(isActive != null) {
      if(isActive.equals("true")) {
        model.addAttribute("todos", this.todoRepository.findByDone(false));
      } else {
        model.addAttribute("todos", this.todoRepository.findByDone(true));
      }
    } else {
      model.addAttribute("todos", this.todoRepository.findAll());
    }
    return "todolist";
  }

  @GetMapping("/add")
  public String renderAddNewTodo(Model model) {
    model.addAttribute("todo", new Todo());
    return "add-todo";
  }

  @PostMapping("/add")
  public String addNewTodo(@ModelAttribute Todo todo) {
    this.todoRepository.save(todo);
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/delete")
  public String deleteTodo(@PathVariable("id") String id) {
    this.todoRepository.deleteById(Long.parseLong(id));
    return "redirect:/todo/list";
  }

  @GetMapping("/{id}/edit")
  public String renderEditPage(@PathVariable("id") String id, Model model) {
    model.addAttribute("todo", this.todoRepository.findById(Long.parseLong(id)));
    return "edit-todo";
  }

  @PostMapping("/edit")
  public String editTodo(@ModelAttribute Todo todo) {
    this.todoRepository.save(todo);
    return "redirect:/todo/list";
  }
}
