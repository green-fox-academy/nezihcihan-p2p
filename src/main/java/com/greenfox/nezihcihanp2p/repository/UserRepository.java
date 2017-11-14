package com.greenfox.nezihcihanp2p.repository;

import com.greenfox.nezihcihanp2p.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {
    List<User> findUserByUsername(String username);
}
