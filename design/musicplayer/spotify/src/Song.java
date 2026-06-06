package design.musicplayer.spotify.src;

public class Song {
    private int id;
    private String name;
    private int duration; // let's say in seconds

    public Song(int id, String name, int duration) {
        this.id = id;
        this.name = name;
        this.duration = duration;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song { id : %d, Name : %s }".formatted(this.id, this.name);
    }
}
