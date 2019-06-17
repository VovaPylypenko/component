package edu.kpi.microphone.model.service.api;

import edu.kpi.microphone.model.entity.Audio;
import edu.kpi.microphone.model.entity.Audios;
import edu.kpi.microphone.model.entity.User;
import edu.kpi.microphone.model.exception.NoMemoryException;

import java.util.Optional;

public interface UserService {
    User createAccount(String username, String password);

    void addAudios(Audios audios, Audio audio) throws NoMemoryException;
    void deleteAudios(Audios audios, Integer audioID);

    Optional<User> findByUsername(String usernameOrEmail);
    Optional<Audios> findAudiosByUsername(String username);

    Optional<User> currentUser();
    Optional<Audios> currentAudios();
}
