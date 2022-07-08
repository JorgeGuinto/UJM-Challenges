import java.lang.reflect.Array;
import java.util.ArrayList;

public class Album {
    private String name;
    private String artist;
    private ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String getArtist() {
        return artist;
    }

    public void printSongs(){
        System.out.println(this.name);
        for (int i = 0; i < songs.size(); i++){
            System.out.println((i+1) + ". -" + songs.get(i).toString());
        }
        System.out.println("=============================");
    }

    public boolean findSong (Song song){
        for (int i = 0; i < this.songs.size(); i++){
            if (this.songs.get(i).equals(song)){
                return true;
            }
        }
        return false;
    }
    public boolean addSong (Song song){
        if (findSong(song)){
            return false;
        } else {
            this.songs.add(song);
            return true;
        }
    }
}
