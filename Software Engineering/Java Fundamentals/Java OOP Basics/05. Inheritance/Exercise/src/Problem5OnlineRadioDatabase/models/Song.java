package Problem5OnlineRadioDatabase.models;

import Problem5OnlineRadioDatabase.exceptions.*;

public class Song {
    private String artistName;
    private String songName;
    private int minutes;
    private int seconds;

    public Song(String artistName, String songName, String duration) {
        this.setArtistName(artistName);
        this.setSongName(songName);
        this.setDuration(duration);
    }

    private String getArtistName() {
        return this.artistName;
    }

    private void setArtistName(String artistName) {
        if (artistName == null || artistName.length() < 3 || artistName.length() > 20) {
            throw new InvalidArtistNameException();
        }
        this.artistName = artistName;
    }

    private String getSongName() {
        return this.songName;
    }

    private void setSongName(String songName) {
        if (songName.length() < 3 || songName.length() > 30) {
            throw new InvalidSongNameException();
        }
        this.songName = songName;
    }

    int getMinutes() {
        return this.minutes;
    }

    private void setMinutes(int minutes) {
        if (minutes < 0 || minutes > 14) {
            throw new InvalidSongMinutesException();
        }
        this.minutes = minutes;
    }

    int getSeconds() {
        return this.seconds;
    }

    private void setSeconds(int seconds) {
        if (seconds < 0 || seconds > 59) {
            throw new InvalidSongSecondsException();
        }
        this.seconds = seconds;
    }

    private void setDuration(String duration) {
        String[] durationParams = duration.split(":");
        int minutes;
        int seconds;
        try {
            minutes = Integer.parseInt(durationParams[0]);
            seconds = Integer.parseInt(durationParams[1]);
        } catch (NumberFormatException e) {
            throw new InvalidSongLengthException();
        }

        this.setMinutes(minutes);
        this.setSeconds(seconds);
    }
}
