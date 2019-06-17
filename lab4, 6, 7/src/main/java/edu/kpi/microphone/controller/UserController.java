package edu.kpi.microphone.controller;

import com.mongodb.DuplicateKeyException;
import edu.kpi.microphone.controller.dto.AudioDto;
import edu.kpi.microphone.controller.dto.AudioForDeleteDto;
import edu.kpi.microphone.controller.dto.UserDto;
import edu.kpi.microphone.model.entity.Audio;
import edu.kpi.microphone.model.entity.Audios;
import edu.kpi.microphone.model.exception.NoMemoryException;
import edu.kpi.microphone.model.service.api.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;
import java.util.List;

@Controller
public class UserController {

    private UserService userService;

    @Autowired
    public void setUserService(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String index(Model model) {
        model.addAttribute("audio", new AudioDto());

        return "index";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.GET)
    public String signUpForm(Model model) {
        model.addAttribute("user", new UserDto());

        return "signup";
    }

    @RequestMapping(value = "/signup", method = RequestMethod.POST)
    public ModelAndView signUp(@ModelAttribute("user") @Valid UserDto userDto, BindingResult result,
                               Model model) {
        if (!userDto.getPassword().equals(userDto.getPassword2())) {
            model.addAttribute("error", "Passwords is not equals!");
            return new ModelAndView("signup", "user", new UserDto());
        }

        try {
            if (!result.hasErrors())
                userService.createAccount(userDto.getUsername(), userDto.getPassword());
        } catch (DuplicateKeyException e) {
            model.addAttribute("error", "Username or email already in use!");
            return new ModelAndView("signup", "user", new UserDto());
        }

        if (result.hasErrors())
            return new ModelAndView("signup", "user", userDto);
        else
            return new ModelAndView("redirect:/login");
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public String addGet(Model model) {
        model.addAttribute("audio", new AudioDto());
        return "add";
    }

    @RequestMapping(value = "/audios", method = RequestMethod.GET)
    public String audios(Model model) {

        var audiosOptional = userService.currentAudios();
        Audios audios = new Audios();
        if (audiosOptional.isPresent()) {
            audios = audiosOptional.get();
        }
        model.addAttribute("audios", audios);
        model.addAttribute("audioForDel", new AudioForDeleteDto());

        return "audios";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ModelAndView add(@ModelAttribute("audio") @Valid AudioDto audioDto, BindingResult result,
                            Model model) {
        if (result.hasErrors()) {
            ModelAndView modelAndView = new ModelAndView();
            modelAndView.setViewName("add");
            modelAndView.addObject("audio", new AudioDto());
            return modelAndView;
        }
        var audiosOptional = userService.currentAudios();
        if (audiosOptional.isPresent()) {
            Audios audios = audiosOptional.get();
            Audio audio = new Audio();
            audio.setName(audioDto.getName())
                    .setAudio(audioDto.getAudio());

            try {
                userService.addAudios(audios, audio);
            } catch (NoMemoryException e) {
                model.addAttribute("error", e.getMessage());
            }
        }
        return new ModelAndView("add", "audio", new AudioDto());
    }

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public ModelAndView delete(@ModelAttribute("audioForDel") @Valid AudioForDeleteDto audioForDeleteDto) {
        var audiosOptional = userService.currentAudios();
        if (audiosOptional.isPresent()) {
            Audios audios = audiosOptional.get();
            userService.deleteAudios(audios, Integer.valueOf(audioForDeleteDto.getAudioID()));
        }
        Audios audios = audiosOptional.get();
        return new ModelAndView("audios", "audios", audios);
    }
}
