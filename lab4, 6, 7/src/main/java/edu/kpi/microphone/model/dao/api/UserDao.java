package edu.kpi.microphone.model.dao.api;

import edu.kpi.microphone.model.entity.User;

import java.util.Optional;

public interface UserDao extends Dao<User> {
    Optional<User> findByUsername(String username);
}
