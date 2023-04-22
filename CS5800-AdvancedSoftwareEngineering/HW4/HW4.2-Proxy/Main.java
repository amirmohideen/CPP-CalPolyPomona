class Main {
  public static void main(String[] args) {

    RealSongServiceServer realSongServiceServer = new RealSongServiceServer();
    SongService songProxy = new SongServiceProxy(realSongServiceServer);

    System.out.println(songProxy.searchByID(1)); // Fetch from server and store in cache
    System.out.println(songProxy.searchByID(2)); // Fetch from server and store in cache
    System.out.println(songProxy.searchByID(1)); // Fetch from cache

    System.out.println(songProxy.searchByTitle("Song 3")); // Fetch from server and store in cache
    System.out.println(songProxy.searchByTitle("Song 2")); // Fetch from server and store in cache
    System.out.println(songProxy.searchByTitle("Song 3")); // Fetch from cache

    System.out.println(songProxy.searchByAlbum("Album 1")); // Fetch from server and store in cache
    System.out.println(songProxy.searchByAlbum("Album 2")); // Fetch from server and store in cache
    System.out.println(songProxy.searchByAlbum("Album 1")); // Fetch from cache
    System.out.println(songProxy.searchByAlbum("Album 1")); // Fetch from cache
  }
}