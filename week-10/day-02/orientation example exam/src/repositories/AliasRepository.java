package repositories;

import com.sun.tools.javac.util.List;
import models.entities.Alias;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AliasRepository extends CrudRepository<Alias, Long> {
    public Alias findByAlias(String alias);
    public List<Alias> findAll();
}
