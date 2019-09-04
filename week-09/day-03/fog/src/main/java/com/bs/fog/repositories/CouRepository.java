package com.bs.fog.repositories;

import com.bs.fog.models.entities.Cou;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CouRepository extends CrudRepository<Cou, Integer> {
}
