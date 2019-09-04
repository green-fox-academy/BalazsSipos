package com.balazssipos.rest.services;

import com.balazssipos.rest.models.LogCollectorDTO;
import com.balazssipos.rest.models.LogEntry;
import com.balazssipos.rest.models.LogEntryDTO;
import com.balazssipos.rest.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class LogServiceImpl implements LogService {
  @Autowired
  private LogRepository logRepository;

  public void saveLog(String endpoint, String data) {
    LogEntry logEntry = new LogEntry(LocalDateTime.now(), endpoint, data);
    this.logRepository.save(logEntry);
  }

  public LogCollectorDTO createLogCollector() {
    List<LogEntry> logEntryList = this.logRepository.findAll();
    List<LogEntryDTO> logEntryDTOs = new ArrayList<>();
    for (int i=0;i<logEntryList.size();i++) {
      logEntryDTOs.add(this.createLogEntryDTO(logEntryList.get(i)));
    }
    return new LogCollectorDTO(logEntryDTOs, logEntryList.size());
  }

  public LogEntryDTO createLogEntryDTO(LogEntry logEntry) {
    return new LogEntryDTO(logEntry.getId(), logEntry.getEndpoint(), logEntry.getData());
  }
}
