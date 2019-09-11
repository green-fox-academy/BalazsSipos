package com.balazssipos.fog.models.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Food {
  @Id
  @GeneratedValue
  private Long id;
  private String name;

}
