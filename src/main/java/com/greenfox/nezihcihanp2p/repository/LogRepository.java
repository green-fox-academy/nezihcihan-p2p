package com.greenfox.nezihcihanp2p.repository;

import com.greenfox.nezihcihanp2p.model.LogEntry;
import org.springframework.data.repository.CrudRepository;

public interface LogRepository extends CrudRepository<LogEntry, Long> {

}
