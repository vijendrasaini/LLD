package design.musicplayer.spotify.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Catalog {
    private static final Catalog instance = new Catalog();
    private Map<Integer, Song> songs;
    private Catalog() {
        this.songs = new HashMap<>();
        this.loadSongs();
    }

    public static Catalog getInstance() {
        
        return instance;
    }

    public void loadSongs() {
        // let's user's phone gets music from here
        // for now creating some 10 songs and adding in this list songs

        for(int i = 1; i < 10; i++) {
            this.songs.put(i, new Song(i, "Song - " + i, 120 + (int) (Math.random() * 120))); // passing some random duration 2 - 4 minutes
        }
    }

    public List<Song> getSongs() {
        return new ArrayList<Song>(this.songs.values());
    }
}
