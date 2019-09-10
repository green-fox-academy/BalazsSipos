package controllers;

import models.DTOs.AliasDTO;
import models.DTOs.ErrorMessage;
import models.entities.Alias;
import services.AliasService;

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
            model.addAttribute("errorMessage", new ErrorMessage("Please fill both URL and alias!", ""));
            model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(null));
        } else if(this.aliasService.findAliasByAlias(aliasDTO.getAlias()) != null) {
            model.addAttribute("errorMessage", new ErrorMessage("Your alias is already in use!", ""));
            model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(this.aliasService.findAliasByAlias(aliasDTO.getAlias())));
        } else {
            this.aliasService.updateNewAlias(this.aliasService.convertFromAliasDTOToAlias(aliasDTO));
            model.addAttribute("errorMessage", new ErrorMessage("", "Your URL is aliased to " + aliasDTO.getAlias() + and your secret code is +
                    this.aliasService.findAliasByAlias(aliasDTO.getAlias()).getSecretCode + "!"));
            model.addAttribute("aliasDTO", this.aliasService.convertFromAliasToAliasDTO(null));
        }
        return "main";
    }

    @GetMappint("/a/{alias}")
    public String redirectToURL(@PathVariable(value="alias") String alias) {
        Alias foundAndIncreasedAlias = this.aliasService.increaseHitCount(alias);
        if(foundAndIncreasedAlias != null) {
            return "redirect:" + foundAndIncreasedAlias.getUrl();
        } else {
            return "notfound";
        }
    }
}
