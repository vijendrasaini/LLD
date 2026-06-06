package design.musicplayer.spotify.src;

import java.util.ArrayList;
import java.util.List;

import design.musicplayer.spotify.src.Strategy.NormalPlaybackStrategy;
import design.musicplayer.spotify.src.Strategy.PlaybackStrategy;
import design.musicplayer.spotify.src.Strategy.ShufflePlaybackStrategy;

public class Player {
    private Playlist playlist;
    private Song selectedSong; // current song
    private List<Song> list;
    private boolean isShuffleEnabled;
    private RepeatMode repeatMode;
    private PlaybackStrategy playbackStrategy;
    private PlayerStatus playerStatus;

    private static final Player INSTANCE = new Player();
    public Player() {
        this.repeatMode = RepeatMode.OFF;
        this.playbackStrategy = new NormalPlaybackStrategy(0);
        this.playerStatus = PlayerStatus.PAUSED; // initially first song will be visible but as paused so user can tap on play / result button
    }

    public static Player getInstance() {
        return Player.INSTANCE;
    }

    public void setSelectedSong(Song song) {
        this.selectedSong = song;
    }

    public void playSong(Song song) {
        System.out.println(song);
        this.setPlayerStatus(PlayerStatus.PLAYING);

        this.setSelectedSong(song);
    }

    public void setPlaybackStrategy(PlaybackStrategy playbackStrategy) {
        this.playbackStrategy = playbackStrategy;
    }

    public void setRepeatMode(RepeatMode repeatMode) {
        this.repeatMode = repeatMode;
    }

    public void setShuffleEnabled(boolean isShuffleEnabled) {
        this.isShuffleEnabled = isShuffleEnabled;

        if(isShuffleEnabled) {
            ShufflePlaybackStrategy shufflePlaybackStrategy = new ShufflePlaybackStrategy(this.selectedSong.getId());
            shufflePlaybackStrategy.shuffleSongList(this.list);
            this.setPlaybackStrategy(playbackStrategy);
            return;
        }


        this.list = new ArrayList<>(playlist.getSongs());
        this.setPlaybackStrategy(new NormalPlaybackStrategy(this.selectedSong.getId()));
    }

    public void setPlayerStatus(PlayerStatus playerStatus) {
        System.out.println("Player is %s ...!!!".formatted(playerStatus));
        this.playerStatus = playerStatus;
    }

    public Song getSelectedSong() {
        return selectedSong;
    }

    public List<Song> getList() {
        return list;
    }

    public void setPlaylist(Playlist playlist) {
        if(!playlist.getSongs().isEmpty()) {
            this.setSelectedSong(playlist.getSongs().get(0));
        }

        list = new ArrayList<>(playlist.getSongs());
        this.playlist = playlist;
    }

    public void playInLoop() {
        setPlayerStatus(PlayerStatus.PLAYING);
        for (Song song : list) {
            System.out.println("Running : " + song);
            System.out.println("Finished in %d secs.".formatted(song.getDuration()));
        }
    }
}
