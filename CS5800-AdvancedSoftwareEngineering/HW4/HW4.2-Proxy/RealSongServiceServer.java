import java.util.ArrayList;
import java.util.List;

public class RealSongServiceServer implements SongService {

    private List<Song> songList;

    public RealSongServiceServer() {
        songList = new ArrayList<>();
        songList.add(new Song(1, "Song 1", "Artist 1", "Album 1", 180));
        songList.add(new Song(2, "Song 2", "Artist 2", "Album 1", 240));
        songList.add(new Song(3, "Song 3", "Artist 1", "Album 2", 200));
        songList.add(new Song(4, "Song 4", "Artist 3", "Album 2", 220));
        songList.add(new Song(5, "Song 5", "Artist 2", "Album 3", 190));
    }

    @Override
    public Song searchByID(Integer songID) {
        simulateServerDelay();
        for (Song song : songList) {
            if (song.getID().equals(songID)) {
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        simulateServerDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songList) {
            if (song.getTitle().equals(title)) {
                result.add(song);
            }
        }
        return result;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        simulateServerDelay();
        List<Song> result = new ArrayList<>();
        for (Song song : songList) {
            if (song.getAlbum().equals(album)) {
                result.add(song);
            }
        }
        return result;
    }

    public void addSong(Song song) {
        songList.add(song);
    }

    private void simulateServerDelay() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
