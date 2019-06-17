package edu.kpi.microphone.model.dao.morphia;

import edu.kpi.microphone.model.dao.api.UserDao;
import edu.kpi.microphone.model.entity.User;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserMorphiaDao extends MorphiaDao<User> implements UserDao {

    public UserMorphiaDao() {
        super(User.class);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        var query = datastore.createQuery(entityClass)
                .filter("username", username);
        return Optional.ofNullable(query.find().tryNext());
    }
}
