package com.balazssipos.todomysql;

import com.balazssipos.todomysql.models.Todo;
import com.balazssipos.todomysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodomysqlApplication implements CommandLineRunner {

  @Qualifier("todoRepository")
  @Autowired
  private TodoRepository todoRepository;

  public static void main(String[] args) {
    SpringApplication.run(TodomysqlApplication.class, args);
  }

  public void run(String... args) {
    this.todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
    this.todoRepository.save(new Todo("I need to eat"));
    this.todoRepository.save(new Todo("I need to be cool"));
    this.todoRepository.save(new Todo("Drink", true, false));
    this.todoRepository.save(new Todo("Fish", true, true));
  }
}