package design.musicplayer.spotify.src;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    
    private int id;
    private String name;
    private List<Song> songs;

    public Playlist(int id, String name) {
        this.id = id;
        this.name = name;

        this.songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        this.songs.add(song);
    }

    public void removeSong(Song song) {
        this.songs.remove(song);
    }

    public List<Song> getSongs() {
        return new ArrayList<>(songs); // creating a copy list so that now one can modify the original playlist
    }
}
