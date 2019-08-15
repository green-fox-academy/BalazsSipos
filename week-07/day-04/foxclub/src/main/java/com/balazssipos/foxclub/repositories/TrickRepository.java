package com.balazssipos.foxclub.repositories;

import com.balazssipos.foxclub.models.entities.Trick;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.util.HashMap;

@Component
public interface TrickRepository {
  HashMap<String, Trick> findAll();
  void createTrickRepositoryMap();
}
