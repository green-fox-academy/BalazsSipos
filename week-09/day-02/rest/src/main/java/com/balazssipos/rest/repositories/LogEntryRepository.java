package com.balazssipos.rest.repositories;

import com.balazssipos.rest.models.logs.LogEntry;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LogEntryRepository extends CrudRepository<LogEntry, Integer> {
}
