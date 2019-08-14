package com.balazssipos.hellobeanworld.usefulutilities.controllers;

import com.balazssipos.hellobeanworld.usefulutilities.services.UtilityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class UUController {
  UtilityService utilityService;

  @Autowired
  public UUController(UtilityService utilityService) {
    this.utilityService = utilityService;
  }
  @GetMapping("/useful")
  public String mainPage() {
    return "useful";
  }

  @GetMapping("/useful/colored")
  public String coloredBackground(Model model) {
    model.addAttribute("backgroundColor", this.utilityService.randomColor());
    return "useful";
  }

  @GetMapping("useful/email")
  public String emailValidation(Model model, @RequestParam("email") String emailToValidate) {
    boolean isEmailValid = this.utilityService.validateEmail(emailToValidate);
    String validatedEmailMessage;
    String messageColor;

    if(isEmailValid) {
      validatedEmailMessage = emailToValidate + " is a valid email address";
      messageColor = "green_message";
    } else {
      validatedEmailMessage = emailToValidate + " is not a valid email address";
      messageColor = "red_message";
    }
    model.addAttribute("validatedEmailMessage", validatedEmailMessage);
    model.addAttribute("messageColor", messageColor);
    return "emailValidation";
  }

  @GetMapping("useful/encode")
  public String encodeText(Model model, @RequestParam("text") String inputText, @RequestParam("number") int inputNumber) {
    model.addAttribute("codedText", this.utilityService.caesar(inputText, inputNumber));
    return "useful";
  }

  @GetMapping("useful/decode")
  public String decodeText(Model model, @RequestParam("text") String inputText, @RequestParam("number") int inputNumber) {
    model.addAttribute("codedText", this.utilityService.caesar(inputText, inputNumber * (-1)));
    return "useful";
  }
}
