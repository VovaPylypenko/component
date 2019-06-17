package edu.kpi.microphone.model.entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Audio {
    @NotNull
    private String name;

    @NotNull
    @Size(min = 1)
    private String audio;

    public String getName() {
        return name;
    }

    public Audio setName(String name) {
        this.name = name;
        return this;
    }

    public String getAudio() {
        return audio;
    }

    public Audio setAudio(String audio) {
        this.audio = audio;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audio audio1 = (Audio) o;
        return Objects.equals(name, audio1.name) &&
                Objects.equals(audio, audio1.audio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, audio);
    }
}
