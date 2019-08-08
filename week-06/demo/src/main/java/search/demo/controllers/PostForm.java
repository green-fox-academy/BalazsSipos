package search.demo.controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import search.demo.models.FormData;

@Controller
public class PostForm {

  @GetMapping("")
  public String homePage() {
    return "form";
  }

  @PostMapping("/w")
  public String sendForm(@ModelAttribute FormData formData2) {
    System.out.println(formData2.getSearchField2());
    System.out.println("s");
    return "form";
  }
}
