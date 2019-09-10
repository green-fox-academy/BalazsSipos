package controllers;

import models.DTOs.SecretCodeDTO;
import services.AliasService;

@RestController
public class AliasRestController {
    private AliasService aliasService;

    @Autowired
    public AliasController(AliasService aliasService) {
        this.aliasService = aliasService;
    }

    @GetMapping("/api/links")
    public ResponseEntity sendLinks() {
        return ResponseEntity.status(200).body(this.aliasService.findAllAliasDTOs());
    }

    @DeleteMapping("/api/links/{id}")
    public ResponseEntity deleteLink(@RequestBody SecretCodeDTO secretCodeDTO, @PathVariable(value="id") Long id) {
        if(this.aliasService.findAliasById(id) == null) {
            return ResponseEntity.status(404).body("Id does not exist");
        } else if(this.aliasService.findAliasById(id).getSecretCode() != secretCodeDTO.getSecretCode()) {
            return ResponseEntity.status(403).body("Secred code is incorrect");
        } else {
            this.aliasService.deleteAliasById(id);
            return ResponseEntity.status(204).body("Alias with id: " + id + " deleted!");
        }
    }
}
