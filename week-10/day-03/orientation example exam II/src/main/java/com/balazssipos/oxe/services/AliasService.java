package com.balazssipos.oxe.services;

import com.balazssipos.oxe.models.DTOs.AliasDTO;
import com.balazssipos.oxe.models.entities.Alias;
import java.util.List;

public interface AliasService {
  public AliasDTO convertFromAliasToAliasDTO(Alias alias);
  public Alias findAliasByAlias(String alias);
  public Alias findAliasById(Long id);
  public Alias updateNewAlias(Alias alias);
  public Alias convertFromAliasDTOToAlias(AliasDTO aliasDTO);
  public Alias increaseHitCount(String alias);
  public List<AliasDTO> findAllAliasDTOs();
  public void deleteAliasById(Long id);
}
