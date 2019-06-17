package edu.kpi.microphone.controller.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class AudioDto {
    @NotNull
    @Size(min = 1, message = "can not be empty")
    private String name;

    @NotNull
    @Size(min = 1, message = "can not be empty")
    private String audio;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAudio() {
        return audio;
    }

    public void setAudio(String audio) {
        this.audio = audio;
    }
}
