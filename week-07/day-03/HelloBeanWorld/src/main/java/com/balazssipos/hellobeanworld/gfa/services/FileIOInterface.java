package com.balazssipos.hellobeanworld.gfa.services;

import java.util.List;

public interface FileIOInterface {
  public List<String> readFileContent(String fileName);
  public void writeFileContent(String fileName, List<String> fileContent);
}
