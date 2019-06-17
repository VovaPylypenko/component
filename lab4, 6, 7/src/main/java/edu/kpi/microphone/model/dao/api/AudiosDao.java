package edu.kpi.microphone.model.dao.api;

import edu.kpi.microphone.model.entity.Audios;

import java.util.Optional;

public interface AudiosDao extends Dao<Audios> {
    Optional<Audios> findByUsername(String username);
}
