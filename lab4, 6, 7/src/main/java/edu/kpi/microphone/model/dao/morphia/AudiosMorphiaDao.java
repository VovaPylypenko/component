package edu.kpi.microphone.model.dao.morphia;

import edu.kpi.microphone.model.dao.api.AudiosDao;
import edu.kpi.microphone.model.entity.Audios;

import java.util.Optional;

public class AudiosMorphiaDao extends MorphiaDao<Audios> implements AudiosDao {

    public AudiosMorphiaDao() {
        super(Audios.class);
    }

    @Override
    public Optional<Audios> findByUsername(String username) {
        var query = datastore.createQuery(entityClass)
                .filter("userName", username);
        return Optional.ofNullable(query.find().tryNext());
    }
}
