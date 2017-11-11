package com.greenfox.nezihcihanp2p.repository;

import com.greenfox.nezihcihanp2p.model.Message;
import org.springframework.data.repository.CrudRepository;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findAllByOrderByTimestampDesc();
}
