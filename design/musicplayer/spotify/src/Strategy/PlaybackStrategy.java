package design.musicplayer.spotify.src.Strategy;

public interface PlaybackStrategy {
    int next();
    int previous();
}