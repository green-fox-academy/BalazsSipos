package com.bs.fog.repositories;

import com.bs.fog.models.entities.Prov;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProvRepository extends CrudRepository<Prov, Integer> {
}
