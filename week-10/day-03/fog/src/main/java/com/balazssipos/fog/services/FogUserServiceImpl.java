package com.balazssipos.fog.services;

import com.balazssipos.fog.models.entities.FogUser;
import com.balazssipos.fog.repositories.FogUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FogUserServiceImpl implements FogUserService {
  private FogUserRepository fogUserRepository;

  @Autowired
  public FogUserServiceImpl(FogUserRepository fogUserRepository) {
    this.fogUserRepository = fogUserRepository;
  }

  @Override
  public FogUser findUserByName(String userName) {
    return this.fogUserRepository.findByName(userName);
  }

  @Override
  public Long createUser(FogUser fogUser) {
    FogUser foundFogUser = this.findUserByName(fogUser.getName());
    if(foundFogUser == null) {
      FogUser newFogUser = this.fogUserRepository.save(fogUser);
      return newFogUser.getId();
    }
    return foundFogUser.getId();
  }

  @Override
  public FogUser findUserById(Long id) {
    Optional<FogUser> optFogUser = this.fogUserRepository.findById(id);
    if(optFogUser.isPresent()) {
      return optFogUser.get();
    }
    return null;
  }

  @Override
  public FogUser updateUser(FogUser fogUser) {
    FogUser foundFogUser = this.findUserById(fogUser.getId());
    if(foundFogUser != null) {
      this.fogUserRepository.save(fogUser);
    }
    return fogUser;
  }
}
