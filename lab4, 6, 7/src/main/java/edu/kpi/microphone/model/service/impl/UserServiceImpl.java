package edu.kpi.microphone.model.service.impl;

import edu.kpi.microphone.model.dao.api.AudiosDao;
import edu.kpi.microphone.model.dao.api.UserDao;
import edu.kpi.microphone.model.entity.Audio;
import edu.kpi.microphone.model.entity.Audios;
import edu.kpi.microphone.model.entity.User;
import edu.kpi.microphone.model.exception.NoMemoryException;
import edu.kpi.microphone.model.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    private UserDao userRepository;
    private AudiosDao audiosRepository;
    private PasswordEncoder encoder;

    @Autowired
    public void setUserRepository(UserDao userRepository) {
        this.userRepository = userRepository;
    }

    @Autowired
    public void setAudiosRepository(AudiosDao audiosRepository) {
        this.audiosRepository = audiosRepository;
    }

    @Autowired
    public void setEncoder(PasswordEncoder encoder) {
        this.encoder = encoder;
    }

    @Override
    public User createAccount(String username, String password) {
        var user = new User();

        user.setUsername(username);

        var passwordHash = encoder.encode(password);
        user.setPasswordHash(passwordHash);

        userRepository.save(user);

        var audios = new Audios();
        
        audios.setUserName(username);

        audiosRepository.save(audios);

        return user;
    }

    @Override
    public void addAudios(Audios audios, Audio audio) throws NoMemoryException {
        if (audios.getAudios().size() == 10)
            throw new NoMemoryException("You can save only 10 audios.");

        int size = 0;
        for (var a : audios.getAudios())
            size += (a.getAudio().length() * 4);

        if ((size + (audio.getAudio().length() * 4)) > 1001)
            throw new NoMemoryException("You can not use more then 1000MB.");

        audios.getAudios().add(audio);

        audiosRepository.update(audios);
    }

    @Override
    public void deleteAudios(Audios audios, Integer audioID) {
        audios.getAudios().remove(audioID.intValue());

        audiosRepository.update(audios);
    }

    @Override
    public Optional<User> findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<Audios> findAudiosByUsername(String username) {
        return audiosRepository.findByUsername(username);
    }

    @Override
    public Optional<User> currentUser() {
        var username = SecurityContextHolder.getContext().getAuthentication().getName();
        return userRepository.findByUsername(username);
    }

    @Override
    public Optional<Audios> currentAudios() {
        Optional<User> user = currentUser();
        if (user.isPresent()){
            return audiosRepository.findByUsername(user.get().getUsername());
        }
        return Optional.empty();
    }

}
