package com.balazssipos.library.models;

public class Book {
  private static int nextid=0;

  private int id;
  private String title;
  private String author;
  private Integer releaseYear;
  private String additional;

  public Book(String title, String author, Integer releaseYear) {
    this.id = nextid++;
    this.title = title;
    this.author = author;
    this.releaseYear = releaseYear;
    this.additional = "ez";
  }

  public String getTitle() {
    return title;
  }

  public int getId() {
    return id;
  }

  public String getAuthor() {
    return author;
  }

  public Integer getReleaseYear() {
    return releaseYear;
  }
}
