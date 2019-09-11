package com.balazssipos.fog.services;

import com.balazssipos.fog.models.entities.FogUser;

public interface FogUserService {
  public FogUser findUserByName(String userName);
  public Long createUser(FogUser fogUser);
  FogUser findUserById(Long id);
  FogUser updateUser(FogUser fogUser);
}
