package br.edu.iftm.LOG.service;

import br.edu.iftm.LOG.entity.Log;
import br.edu.iftm.LOG.message.LogMessage;
import br.edu.iftm.LOG.repository.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LogService {
    @Autowired
    private LogRepository logRepository;

    @Autowired
    private LogMessage logMessage;

    public List<Log> findAll() {
        return logRepository.findAll();
    }

    public Optional<Log> findById(String id) {
        return logRepository.findById(id);
    }

    public Optional<Log> findByUser(String id) {
        return logRepository.findByUser(id);
    }

}
