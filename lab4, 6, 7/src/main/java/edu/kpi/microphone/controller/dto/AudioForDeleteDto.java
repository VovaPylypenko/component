package edu.kpi.microphone.controller.dto;

import javax.validation.constraints.NotNull;

public class AudioForDeleteDto {
    @NotNull
    private String audioID;

    public String getAudioID() {
        return audioID;
    }

    public AudioForDeleteDto setAudioID(String audioID) {
        this.audioID = audioID;
        return this;
    }
}
