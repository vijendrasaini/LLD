package design.musicplayer.spotify.src;

public class Main {
    public static void main(String[] args) {
        Catalog catalog = Catalog.getInstance();

        // let's create a playlist
        Playlist playlist = new Playlist(1, "Favorite");
        
        // let's add all songs for now into this.
        for (Song song : catalog.getSongs()) {
            playlist.addSong(song);
        }

        Player player = Player.getInstance();

        player.setPlaylist(playlist);
        player.setPlayerStatus(PlayerStatus.PLAYING);

        player.setShuffleEnabled(true);

        player.playInLoop();
    }
}
