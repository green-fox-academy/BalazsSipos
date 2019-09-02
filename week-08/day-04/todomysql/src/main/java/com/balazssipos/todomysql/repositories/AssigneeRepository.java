package com.balazssipos.todomysql.repositories;

import com.balazssipos.todomysql.models.Assignee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AssigneeRepository extends CrudRepository<Assignee, Integer> {
    List<Assignee> findAll();
}
