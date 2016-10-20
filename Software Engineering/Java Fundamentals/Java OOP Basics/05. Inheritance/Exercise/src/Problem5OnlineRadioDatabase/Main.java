package Problem5OnlineRadioDatabase;

import Problem5OnlineRadioDatabase.exceptions.InvalidSongException;
import Problem5OnlineRadioDatabase.models.Playlist;
import Problem5OnlineRadioDatabase.models.Song;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Integer numberOfSongs = Integer.parseInt(reader.readLine());
        Playlist playlist = new Playlist();

        for (int i = 0; i < numberOfSongs; i++) {
            String[] inputParams = reader.readLine().split(";");
            String artistName = inputParams[0];
            String songName = inputParams[1];
            String duration = inputParams[2];
            try {
                Song song = new Song(artistName, songName, duration);
                playlist.addSong(song);
                System.out.println("Song added.");
            } catch (InvalidSongException e) {
                System.out.println(e.getMessage());
            }
        }
        System.out.println(playlist);
    }
}
