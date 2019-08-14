package com.balazssipos.hellobeanworld.gfa.services;

import java.util.List;

public interface StudentInterface {
  public List<String> findAll();
  public void save(String student);
  public int countStudents();
  public boolean checkIfStudentNameExist(String name);


}
