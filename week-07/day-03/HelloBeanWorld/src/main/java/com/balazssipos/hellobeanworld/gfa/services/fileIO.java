package com.balazssipos.hellobeanworld.gfa.services;

import org.springframework.stereotype.Service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Service
public class fileIO implements FileIOInterface {
  @Override
  public List<String> readFileContent(String fileName) {
    try { // Required by Files.readAllLines(filePath);
      // Reads the content from `lorem-psum.txt` in the `assets` folder line by line to a String List
      Path filePath = Paths.get(fileName);
      List<String> lines = Files.readAllLines(filePath);
//      System.out.println(lines.get(0)); // Prints the first line of the file
      return lines;
    } catch (Exception e) {
      System.out.println("Uh-oh, could not read the file!");
    }
    return null;
  }

  @Override
  public void writeFileContent(String fileName, List<String> fileContent) {
//    List<String> content = new ArrayList();
//    content.add(fileContent);
    try { // Required by Files.write(filePath, content)
      // Creates a new file if not exists and overwrites it's content
      // The elements of the content lists will become the lines of the file
      Path filePath = Paths.get(fileName);
      Files.write(filePath, fileContent);
    } catch (Exception e) {
      System.out.println("Uh-oh, could not write the file!");
    }
  }
}
