package Problem5OnlineRadioDatabase.models;

public class Playlist {
    private Integer songCount = 0;
    private long durationInSeconds = 0;

    public void addSong(Song song) {
        this.songCount++;
        long duration = song.getSeconds() + song.getMinutes() * 60;
        this.durationInSeconds += duration;
    }

    @Override
    public String toString() {
        long totalTime = this.durationInSeconds;
        long hours = totalTime / 3600;
        totalTime %= 3600;
        long mins = totalTime / 60;
        totalTime %= 60;
        long secs = totalTime;

        String time = String.format("%dh %dm %ds", hours, mins, secs);
        String output = String.format("Songs added: %d%nPlaylist length: %s", this.songCount, time);
        return output;
    }
}
