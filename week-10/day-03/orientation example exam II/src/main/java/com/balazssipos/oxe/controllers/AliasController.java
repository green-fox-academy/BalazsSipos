package com.balazssipos.oxe.controllers;

import com.balazssipos.oxe.models.DTOs.AliasDTO;
import com.balazssipos.oxe.models.DTOs.MessageDTO;
import com.balazssipos.oxe.models.entities.Alias;
import com.balazssipos.oxe.services.AliasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AliasController {
  private AliasService aliasService;

  @Autowired
  public AliasController(AliasService aliasService) {
    this.aliasService = aliasService;
  }

  @GetMapping("/")
  public String renderMainPage(Model model) {
    model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(null));
    return "main";
  }

  @PostMapping("/save-link")
  public String sendAlias(@ModelAttribute("aliasDTO") AliasDTO aliasDTO, Model model) {
    if(aliasDTO.getUrl().isEmpty() || aliasDTO.getAlias().isEmpty()) {
      model.addAttribute("errorMessage", new MessageDTO("Please fill both URL and alias!", ""));
      model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(null));
    } else if(this.aliasService.findAliasByAlias(aliasDTO.getAlias()) != null) {
      model.addAttribute("errorMessage", new MessageDTO("Your alias is already in use!", ""));
      model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(this.aliasService.findAliasByAlias(aliasDTO.getAlias())));
    } else {
      this.aliasService.updateNewAlias(this.aliasService.convertFromAliasDTOToAlias(aliasDTO));
      model.addAttribute("errorMessage", new MessageDTO("", "Your URL is aliased to " + aliasDTO.getAlias() + " and " +
              "your secret code is " +
              this.aliasService.findAliasByAlias(aliasDTO.getAlias()).getSecretCode() + "!"));
      model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(null));
    }
    return "main";
  }

  @GetMapping("/a/{alias}")
  public String redirectToURL(@PathVariable(value="alias") String alias) {
    Alias foundAndIncreasedAlias = this.aliasService.increaseHitCount(alias);
    if(foundAndIncreasedAlias != null) {
      return "redirect:" + foundAndIncreasedAlias.getUrl();
    } else {
      return "notfound";
    }
  }
}

