package edu.kpi.microphone.model.entity;

import dev.morphia.annotations.Embedded;
import dev.morphia.annotations.Entity;
import dev.morphia.annotations.Id;
import org.bson.types.ObjectId;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity("audios")
public class Audios {
    @Id
    private ObjectId id;

    @NotNull
    @Size(min = 2, max = 21)
    private String userName;

    @Embedded
    @Size(max = 10)
    private List<Audio> audios = new ArrayList<>();

    public ObjectId getId() {
        return id;
    }

    public Audios setId(ObjectId id) {
        this.id = id;
        return this;
    }

    public String getUserName() {
        return userName;
    }

    public Audios setUserName(String userName) {
        this.userName = userName;
        return this;
    }

    public List<Audio> getAudios() {
        return audios;
    }

    public Audios setAudios(List<Audio> audios) {
        this.audios = audios;
        return this;
    }

    public boolean haveAudios() {
        return !audios.isEmpty();
    }

    public boolean emptyAudios() {
        return audios.isEmpty();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Audios audios1 = (Audios) o;
        return Objects.equals(id, audios1.id) &&
                Objects.equals(userName, audios1.userName) &&
                Objects.equals(audios, audios1.audios);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userName, audios);
    }
}
