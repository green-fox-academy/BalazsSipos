package com.balazssipos.fog.repositories;

import com.balazssipos.fog.models.entities.FogUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FogUserRepository extends CrudRepository<FogUser, Long> {
  FogUser findByName(String userName);
}
