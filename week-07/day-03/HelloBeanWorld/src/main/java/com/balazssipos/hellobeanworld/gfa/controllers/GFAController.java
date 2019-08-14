package com.balazssipos.hellobeanworld.gfa.controllers;

import com.balazssipos.hellobeanworld.gfa.services.StudentService;
import com.balazssipos.hellobeanworld.gfa.services.StudentServiceFile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GFAController {
  StudentService studentService;
  StudentServiceFile studentServiceFile;

  public GFAController(StudentService studentService, StudentServiceFile studentServiceFile) {
    this.studentService = studentService;
    this.studentServiceFile = studentServiceFile;
  }

  @GetMapping("/gfa")
  public String mainPage(Model model) {
    model.addAttribute("numberOfStudents", this.studentService.countStudents());
    return "gfamain";
  }

  @GetMapping("gfa/list")
  public String listAllStudents(Model model) {
//    List<String> studentsList = this.studentService.findAll();
    model.addAttribute("studentsList", this.studentService.findAll());
    model.addAttribute("numberOfStudents", this.studentService.countStudents());
    return "gfamain";
  }

  @GetMapping("gfa/add")
  public String addNewStudent() {
    return "addstudent";
  }

  @GetMapping("gfa/save")
  public String saveNewStudent(@RequestParam("name") String studentName) {
    this.studentService.save(studentName);
    return "redirect:/gfa/list";
  }

  @GetMapping("gfa/check")
  public String nameChecker() {
    return "namechecker";
  }

  @PostMapping("gfa/check")
  public String nameCheckerPosted(Model model, @RequestParam("name") String nameToCheck) {
    if (this.studentService.checkIfStudentNameExist(nameToCheck)) {
      model.addAttribute("nameCheckerResponse", nameToCheck + " is already in the list.");
      model.addAttribute("messageColor", "red_message");
    } else {
      model.addAttribute("nameCheckerResponse", nameToCheck + " is not in the list yet.");
      model.addAttribute("messageColor", "green_message");
    }
    return "namechecker";
  }
}
