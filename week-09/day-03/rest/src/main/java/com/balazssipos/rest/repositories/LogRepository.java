package com.balazssipos.rest.repositories;

import com.balazssipos.rest.models.LogEntry;
import com.balazssipos.rest.models.LogEntryDTO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LogRepository extends CrudRepository<LogEntry, Integer> {
  List<LogEntry> findAll();
}
