package com.balazssipos.todomysql.controllers;

import com.balazssipos.todomysql.models.Assignee;
import com.balazssipos.todomysql.models.Todo;
import com.balazssipos.todomysql.repositories.AssigneeRepository;
import com.sun.org.apache.xpath.internal.operations.Mod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/todo")
public class AssigneeController {
  @Qualifier("assigneeRepository")
  @Autowired
  private AssigneeRepository assigneeRepository;

  @GetMapping("/assignees")
  public String listAssignees(Model model) {
    model.addAttribute("assignees", this.assigneeRepository.findAll());
    return "assigneelist";
  }

    @GetMapping("/assignee/add")
    public String renderAddNewAssignee(Model model) {
        model.addAttribute("assignee", new Assignee());
        return "add-assignee";
    }

    @PostMapping("/assignee/add")
    public String addNewAssignee(@ModelAttribute Assignee assignee) {
        this.assigneeRepository.save(assignee);
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignee/{id}/delete")
    public String deleteAssignee(@PathVariable("id") String id) {
        this.assigneeRepository.deleteById(Integer.parseInt(id));
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignee/{id}/edit")
    public String renderEditAssignee(@PathVariable("id") String id, Model model) {
        model.addAttribute("assignee", this.assigneeRepository.findById(Integer.parseInt(id)));
        return "edit-assignee";
    }

    @PostMapping("/assignee/edit")
    public String editAssignee(@ModelAttribute Assignee assignee) {
        System.out.println(assignee.toString());
        this.assigneeRepository.save(assignee);
        return "redirect:/todo/assignees";
    }

    @GetMapping("/assignee/{id}/show")
    public String showAssignee(Model model, @PathVariable("id") String assigneeId) {
      Optional assigneeOp = this.assigneeRepository.findById(Integer.parseInt(assigneeId));
      if(assigneeOp.isPresent()) {
          model.addAttribute("assignee", assigneeOp.get());
      }
      return "show-assignee";

    }
}
