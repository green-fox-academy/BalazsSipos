package com.balazssipos.oxe.repositories;
import com.balazssipos.oxe.models.entities.Alias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {
  public Optional<Alias> findByAlias(String alias);
  public List<Alias> findAll();
}
