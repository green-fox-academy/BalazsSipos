package com.balazssipos.todo;

import com.balazssipos.todo.models.Todo;
import com.balazssipos.todo.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

  @Qualifier("todoRepository")
  @Autowired
  private TodoRepository todoRepository;

  public static void main(String[] args) {
    SpringApplication.run(TodoApplication.class, args);
//    SpringApplication.run("asdd");
  }

  public void run(String... args) {
    this.todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    this.todoRepository.save(new Todo("I need to eat"));
    this.todoRepository.save(new Todo("I need to be cool"));
  }
}
