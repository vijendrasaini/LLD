package design.musicplayer.spotify.src.Strategy;

public class NormalPlaybackStrategy implements PlaybackStrategy{
    private int currentSongIndex;

    public NormalPlaybackStrategy(int currentSongIndex) {
        this.currentSongIndex = currentSongIndex;
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
