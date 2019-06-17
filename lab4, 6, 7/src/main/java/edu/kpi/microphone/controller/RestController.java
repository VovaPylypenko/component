package edu.kpi.microphone.controller;

import edu.kpi.microphone.model.entity.Audio;
import edu.kpi.microphone.model.entity.Audios;
import edu.kpi.microphone.model.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

@org.springframework.web.bind.annotation.RestController

public class RestController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/audio/{id}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Audio audio(@PathVariable("id") Long id) {

        var audiosOptional = userService.currentAudios();
        Audios audios = new Audios();
        if (audiosOptional.isPresent()) {
            audios = audiosOptional.get();
        }
        Audio audio1 = new Audio();
        audio1.setAudio("lalal-lalal");
        audio1.setName("vova");
        if (id == 2)
            return audio1;
        Audio audio = audios.getAudios().get(Math.toIntExact(id - 1));
//        Audios audios2 = new Audios();
//        audios2.setAudios(List.of(audio));
//        model.addAttribute("audios", audios2);
//        model.addAttribute("audioForDel", new AudioForDeleteDto());

        return audio;
    }
}
