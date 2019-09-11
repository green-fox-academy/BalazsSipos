package com.balazssipos.oxe.services;

import com.balazssipos.oxe.models.DTOs.AliasDTO;
import com.balazssipos.oxe.models.entities.Alias;
import com.balazssipos.oxe.repositories.AliasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class AliasServiceImpl implements AliasService {
  private AliasRepository aliasRepository;

  @Autowired
  public AliasServiceImpl(AliasRepository aliasRepository) {
    this.aliasRepository = aliasRepository;
  }

  @Override
  public AliasDTO convertFromAliasToAliasDTO(Alias alias) {
    AliasDTO aliasDTO;
    if(alias != null) {
      aliasDTO = new AliasDTO(alias.getId(), alias.getUrl(), alias.getAlias(), alias.getHitCount());
    } else {
      aliasDTO = new AliasDTO();
    }
    return aliasDTO;
  }

  @Override
  public Alias findAliasByAlias(String alias) {
    Optional<Alias> optionalAlias = this.aliasRepository.findByAlias(alias);
    if(optionalAlias.isPresent()) {
      return optionalAlias.get();
    }
    return null;
  }

  @Override
  public Alias findAliasById(Long id) {
    Optional<Alias> optionalAlias = this.aliasRepository.findById(id);
    if(optionalAlias.isPresent()) {
      return optionalAlias.get();
    }
    return null;
  }

  @Override
  public Alias updateNewAlias(Alias alias) {
    this.aliasRepository.save(alias);
    return alias;
  }

  @Override
  public Alias convertFromAliasDTOToAlias(AliasDTO aliasDTO) {
    Alias alias;
    if(aliasDTO != null) {
      alias = new Alias(aliasDTO.getUrl(), aliasDTO.getAlias(), aliasDTO.getHitCount(), this.randomGenerator(1000,
              9000.0));
    } else {
      alias = new Alias();
    }
    return alias;
  }

  @Override
  public Alias increaseHitCount(String alias) {
    Optional<Alias> optFoundAlias = this.aliasRepository.findByAlias(alias);
    if(optFoundAlias.isPresent()) {
      Alias foundAlias = optFoundAlias.get();
      foundAlias.setHitCount(foundAlias.getHitCount() + 1);
      this.aliasRepository.save(foundAlias);
      return foundAlias;
    }
    return null;
  }

  @Override
  public List<AliasDTO> findAllAliasDTOs() {
    List<AliasDTO> aliasDTOList = new ArrayList<>();
    List<Alias> aliasList = this.aliasRepository.findAll();
    for (int i=0;i<aliasList.size();i++) {
      aliasDTOList.add(this.convertFromAliasToAliasDTO(aliasList.get(i)));
    }
    return aliasDTOList;
  }

  @Override
  public void deleteAliasById(Long id) {
    Optional<Alias> optionalAlias = this.aliasRepository.findById(id);
    if(optionalAlias.isPresent()) {
      this.aliasRepository.deleteById(id);
    }
  }

  private int randomGenerator(int minValue, Double maxValue) {
    return (int) (maxValue * Math.random() + minValue);
  }


}
