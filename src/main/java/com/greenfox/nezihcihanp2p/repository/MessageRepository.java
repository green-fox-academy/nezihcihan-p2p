package com.greenfox.nezihcihanp2p.repository;

import com.greenfox.nezihcihanp2p.model.Message;
import com.greenfox.nezihcihanp2p.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MessageRepository extends CrudRepository<Message, Long> {

    Iterable<Message> findAllByOrderByTimestampDesc();
    List<Message> findByUser(User user);
}
