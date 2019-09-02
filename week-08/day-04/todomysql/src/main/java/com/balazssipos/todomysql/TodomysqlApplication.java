package com.balazssipos.todomysql;

import com.balazssipos.todomysql.models.Assignee;
import com.balazssipos.todomysql.models.Todo;
import com.balazssipos.todomysql.repositories.AssigneeRepository;
import com.balazssipos.todomysql.repositories.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TodomysqlApplication implements CommandLineRunner {


  private TodoRepository todoRepository;
  private AssigneeRepository assigneeRepository;

  @Autowired
  public TodomysqlApplication(TodoRepository todoRepository, AssigneeRepository assigneeRepository) {
    this.todoRepository = todoRepository;
    this.assigneeRepository = assigneeRepository;
  }





  public static void main(String[] args) {
    SpringApplication.run(TodomysqlApplication.class, args);
  }

  public void run(String... args) {
//    this.todoRepository.save(new Todo("I have to learn Object Relational Mapping"));
//    this.todoRepository.save(new Todo("I need to eat"));
//    this.todoRepository.save(new Todo("I need to be cool"));
//    this.todoRepository.save(new Todo("Drink", true, false));
//    this.todoRepository.save(new Todo("Fish", true, true));

    Assignee assignee1 = new Assignee("Jani", "janika@jani.hu");
    assignee1.addTodo(new Todo("Chill", false, false));
    assignee1.addTodo(new Todo("I have to learn Object Relational Mapping"));
    assignee1.addTodo(new Todo("I need to eat"));
    this.assigneeRepository.save(assignee1);
    Assignee assignee2 = new Assignee("Sanyi", "sanyika@jani.hu");
    assignee2.addTodo(new Todo("I need to be cool"));
    assignee2.addTodo(new Todo("Drink", true, false));
    assignee2.addTodo(new Todo("Fish", true, true));
    this.assigneeRepository.save(assignee2);
//    this.assigneeRepository.save(new Assignee("Sanyi", "sanyika@jani.hu"));
  }
}