import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements SongService {
    private SongService realSongServiceServer;
    private Map<Integer, Song> songIDCache;
    private Map<String, List<Song>> songTitleCache;
    private Map<String, List<Song>> songAlbumCache;

    public SongServiceProxy(SongService realSongService) {
        this.realSongServiceServer = realSongService;
        this.songIDCache = new HashMap<>();
        this.songTitleCache = new HashMap<>();
        this.songAlbumCache = new HashMap<>();
    }

    @Override
    public Song searchByID(Integer songID) {
        // Check if song ID metadata is present in cache
        if (songIDCache.containsKey(songID)) {
            System.out.println("Fetching song with ID " + songID + " from cache.");
            return songIDCache.get(songID);
        }

        // If not present in cache, fetch from server
        System.out.println("Fetching song with ID " + songID + " from real server.");
        Song song = realSongServiceServer.searchByID(songID);
        // Store song ID metadata in cache
        songIDCache.put(songID, song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        if (songTitleCache.containsKey(title)) {
            System.out.println("Fetching songs with title '" + title + "' from cache.");
            return songTitleCache.get(title);
        }

        System.out.println("Fetching songs with title '" + title + "' from real server.");
        List<Song> songs = realSongServiceServer.searchByTitle(title);
        songTitleCache.put(title, songs);
        return songs;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        if (songAlbumCache.containsKey(album)) {
            System.out.println("Fetching songs from album '" + album + "' from cache.");
            return songAlbumCache.get(album);
        }

        System.out.println("Fetching songs from album '" + album + "' from real server.");
        List<Song> songs = realSongServiceServer.searchByAlbum(album);
        songAlbumCache.put(album, songs);
        return songs;
    }
}