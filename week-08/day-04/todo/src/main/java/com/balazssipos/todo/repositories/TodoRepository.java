package com.balazssipos.todo.repositories;

import com.balazssipos.todo.models.Todo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {

}
