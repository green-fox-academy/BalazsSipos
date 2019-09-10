package services;

import models.DTOs.AliasDTO;
import models.entities.Alias;

public interface AliasService {
    public AliasDTO convertFromAliasToAliasDTO(Alias alias);
    public Alias findAliasById(Long id);
    public Alias updateNewAlias(Alias alias);
    public Alias convertFromAliasDTOToAlias(AliasDTO aliasDTO);
}
