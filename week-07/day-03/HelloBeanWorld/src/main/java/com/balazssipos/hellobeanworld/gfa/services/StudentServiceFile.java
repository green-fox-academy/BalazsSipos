package com.balazssipos.hellobeanworld.gfa.services;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceFile implements StudentInterface {
//  String names;
  FileIOInterface fileIO;

  public StudentServiceFile(FileIOInterface fileIO) {
    this.fileIO = fileIO;

    List<String> names = new ArrayList<>();
    names.add("Sanyi");
    names.add("Lilla");
    names.add("John");
    this.fileIO.writeFileContent("/names.txt", names);
  }

  public List<String> findAll() {
    return this.names;
  }

  public void save(String student) {
    names.add(student);
  }

  public int countStudents() {
    return this.names.size();
  }

  public boolean checkIfStudentNameExist(String name) {
    if(this.names.indexOf(name) >-1) {
      return true;
    }
    return false;
  }
}
