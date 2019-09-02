package com.balazssipos.todomysql.repositories;

import com.balazssipos.todomysql.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
  List<Todo> findAll();
  List<Todo> findByDone(boolean isDone);
  List<Todo> findByTitleContaining(String title);
}