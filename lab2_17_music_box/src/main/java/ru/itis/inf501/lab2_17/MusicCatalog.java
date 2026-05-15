package ru.itis.inf501.lab2_17;

import com.fasterxml.jackson.annotation.JsonProperty;
import ru.itis.inf501.lab2_17.MusicTrack;

import java.util.List;

public class MusicCatalog {

    @JsonProperty("traks")
    private List<MusicTrack> musicTrack;

    public MusicCatalog() {
    }

    public List<MusicTrack> getMusicTrack() {
        return musicTrack;
    }

    public void setMusicTrack(List<MusicTrack> musicTrack) {
        this.musicTrack = musicTrack;
    }
}
