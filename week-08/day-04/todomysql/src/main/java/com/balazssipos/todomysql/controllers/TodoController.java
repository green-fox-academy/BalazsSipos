package com.balazssipos.todomysql.controllers;

import com.balazssipos.todomysql.models.Assignee;
import com.balazssipos.todomysql.models.Todo;
import com.balazssipos.todomysql.repositories.AssigneeRepository;
import com.balazssipos.todomysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import sun.awt.SunToolkit;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class TodoController {




  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

    @Autowired
    public TodoController(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
        this.todoRepository = todoRepository;
        this.assigneeRepository = assigneeRepository;
    }

    @GetMapping(value={"/","/list"})
//  @ResponseBody
  public String list(Model model, @RequestParam(value = "isActive", required = false) String isActive)
  {
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

  @PostMapping("/")
  public String search(Model model, @RequestParam(value = "search", required = false) String searchWord) {
    if(searchWord != null) {
      List<Todo> searchedTodos = this.todoRepository.findByTitleContaining(searchWord);
      if(!searchedTodos.isEmpty()) {
        model.addAttribute("todos", searchedTodos);
      } else {
        model.addAttribute("todos", this.todoRepository.findAll());
        model.addAttribute("errormsg", "The searched title has not found");
      }
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
    model.addAttribute("assignees", this.assigneeRepository.findAll());
    return "edit-todo";
  }

  @PostMapping("/edit")
  public String editTodo(@ModelAttribute Todo todo, @RequestParam("assignee_id") String assigneID) {
      System.out.println("assigneeIDAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" + assigneID);
      Optional<Assignee> assigneById = this.assigneeRepository.findById(Integer.parseInt(assigneID));
      if(assigneById.isPresent()) {
          todo.setAssignee(assigneById.get());
      }
        this.todoRepository.save(todo);
    return "redirect:/todo/list";
  }
}
