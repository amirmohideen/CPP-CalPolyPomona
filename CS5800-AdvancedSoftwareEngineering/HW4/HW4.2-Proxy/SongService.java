import java.util.List;

public interface SongService 
{
    Song searchByID(Integer SongID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}