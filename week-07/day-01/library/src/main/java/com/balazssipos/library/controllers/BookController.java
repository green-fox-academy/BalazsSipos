package com.balazssipos.library.controllers;

import com.balazssipos.library.models.Book;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Controller
public class BookController {
  private List<Book> books = new ArrayList<>();

  public BookController() {
    books.add(new Book("Cat's Cradle", "Kurt Vonnegut", 1963));
    books.add(new Book("Do Androids Dream of Electric Sheep?", "Philip K. Dick", 1968));
  }

  @RequestMapping(path = "/books", method = RequestMethod.GET)
  public String showBooks(Model model, @RequestParam(name="author", required = false) String author) {
    List<Book> queriedBooks;

    if(author != null) {
      queriedBooks = this.filterBooksByAuthor(author);
    } else {
      queriedBooks = this.books;
    }

    model.addAttribute("books", queriedBooks);
    return "index";
  }

  @GetMapping("/books/{id}/details")
  public String getBookById(Model model, @PathVariable(name = "id") int id) {
    Book bookById = null;

    for(Book book : this.books) {
      if(book.getId() == id) {
        bookById = book;
      }
    }

    if(bookById != null) {
      model.addAttribute("book", bookById);
    } else {
      model.addAttribute("book", "No book found");
    }

    return "details";
  }

  @GetMapping("books/add")
  public String addBookForm(Model model, @ModelAttribute(name="book2") Book book2) {
    model.addAttribute("book2", book2);
    return "create";
  }

  @PostMapping("books/add")
  public String addBook(@ModelAttribute() Book book2) {
    this.books.add(book2);
    return "redirect:/books";
  }

  private List<Book> filterBooksByAuthor(String author) {
    return this.books.stream()
            .filter(book -> book.getAuthor().equals(author))
            .collect(Collectors.toList());
  }
}



