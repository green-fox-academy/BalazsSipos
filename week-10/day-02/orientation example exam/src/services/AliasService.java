package services;

import com.sun.tools.javac.util.List;
import models.DTOs.AliasDTO;
import models.entities.Alias;

public interface AliasService {
    public AliasDTO convertFromAliasToAliasDTO(Alias alias);
    public Alias findAliasByAlias(String alias);
    public Alias findAliasById(Long id);
    public Alias updateNewAlias(Alias alias);
    public Alias convertFromAliasDTOToAlias(AliasDTO aliasDTO);
    public Alias increaseHitCount(Alias alias);
    public List<AliasDTO> findAllAliasDTOs();
    public void deleteAliasById(Long id);
}
