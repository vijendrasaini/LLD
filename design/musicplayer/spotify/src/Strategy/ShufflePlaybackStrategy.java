package design.musicplayer.spotify.src.Strategy;

import java.util.Collections;
import java.util.List;

import design.musicplayer.spotify.src.Song;

public class ShufflePlaybackStrategy implements PlaybackStrategy {
    private int currentSongIndex;

    public ShufflePlaybackStrategy(int currentSongIndex) {
        this.currentSongIndex = currentSongIndex;
    }

    public void shuffleSongList(List<Song> list) {
        Collections.shuffle(list);
    }
    
    @Override
    public int next() {
        return ++currentSongIndex;
    }

    @Override
    public int previous() {
        return --currentSongIndex;
    }
}
