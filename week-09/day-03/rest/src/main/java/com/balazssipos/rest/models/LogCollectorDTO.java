package com.balazssipos.rest.models;

import java.util.List;

public class LogCollectorDTO {
  List<LogEntryDTO> logEntries;
  int entry_count;

  public LogCollectorDTO(List<LogEntryDTO> logEntrieDTOs, int entry_count) {
    this.logEntries = logEntrieDTOs;
    this.entry_count = entry_count;
  }

  public List<LogEntryDTO> getLogEntries() {
    return logEntries;
  }

  public void setLogEntries(List<LogEntryDTO> logEntries) {
    this.logEntries = logEntries;
  }

  public int getEntry_count() {
    return entry_count;
  }

  public void setEntry_count(int entry_count) {
    this.entry_count = entry_count;
  }
}
