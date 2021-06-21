public class Song{
    private String Artist;
    private String musicItemName;
    private String Genre;
    private int yearOfRelease;
    private int numberOfSongs;
    private String totalPlayingTime;

    public String getArtist() {
        return Artist;
    }

    public void setArtist(String artist) {
        Artist = artist;
    }

    public String getMusicItemName() {
        return musicItemName;
    }

    public void setMusicItemName(String musicItemName) {
        this.musicItemName = musicItemName;
    }

    public String getGenre() {
        return Genre;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public int getYearOfRelease() {
        return yearOfRelease;
    }

    public void setYearOfRelease(int yearOfRelease) {
        this.yearOfRelease = yearOfRelease;
    }

    public int getNumberOfSongs() {
        return numberOfSongs;
    }

    public void setNumberOfSongs(int numberOfSongs) {
        this.numberOfSongs = numberOfSongs;
    }

    public String getTotalPlayingTime() {
        return totalPlayingTime;
    }

    public void setTotalPlayingTime(String totalPlayingTime) {
        this.totalPlayingTime = totalPlayingTime;
    }
}