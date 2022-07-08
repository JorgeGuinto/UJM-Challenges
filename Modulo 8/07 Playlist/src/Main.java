import java.util.*;
import java.util.Iterator;

public class Main {
    private static ArrayList<Album> albums = new ArrayList<>();

    public static void main(String[] args) {

        Album red = new Album("Red (Taylor's Version)", "Taylor Swift");
        Album tasteOfLove = new Album("Taste of Love", "Twice");
        Album theAlbum = new Album("The Album", "Blackpink");

        albums.add(red);
        albums.add(tasteOfLove);
        albums.add(theAlbum);

        Song hYLT = new Song("How You Like That", 3);
        Song prettySavage = new Song("Pretty Savage", 3.2);
        Song lSG = new Song("Lovesick Girls", 3.13);
        Song alcoholFree = new Song("Alcohol-Free", 3.3);
        Song firstTime = new Song("First Time", 3.03);
        Song babyBlueL = new Song("Baby Blue Love", 2.46);
        Song allTooWell = new Song("All Too Well", 4.55);
        Song holyGround = new Song("Holy Ground", 3.22);
        Song theLastTime = new Song("The Last Time", 4.58);
        Song tenerifeSea = new Song("Tenerife Sea", 3.28);

        red.addSong(allTooWell);
        red.addSong(holyGround);
        red.addSong(theLastTime);
        tasteOfLove.addSong(alcoholFree);
        tasteOfLove.addSong(firstTime);
        tasteOfLove.addSong(babyBlueL);
        theAlbum.addSong(hYLT);
        theAlbum.addSong(prettySavage);
        theAlbum.addSong(lSG);

        LinkedList<Song> playlist = new LinkedList<>();

        red.printSongs();
        tasteOfLove.printSongs();
        theAlbum.printSongs();

        addSongToPlaylist(playlist, allTooWell);
        addSongToPlaylist(playlist, lSG);
        addSongToPlaylist(playlist, alcoholFree);
        addSongToPlaylist(playlist, firstTime);
        addSongToPlaylist(playlist, tenerifeSea);
        addSongToPlaylist(playlist, prettySavage);
        addSongToPlaylist(playlist, theLastTime);
        addSongToPlaylist(playlist, babyBlueL);

        printPlaylist(playlist);
        playPlaylist(playlist);

    }

    public static void playPlaylist(LinkedList playlist){
        Scanner scanner = new Scanner(System.in);
        boolean quit = false;
        boolean goingForward = true;
        ListIterator<Song> listIterator = playlist.listIterator();

        if (playlist.isEmpty()){
            System.out.println("No songs in the playlist");
            return;
        } else {
            System.out.println("Now playing " + listIterator.next().toString());
            printMenu();
        }

        while(!quit){
            int action = scanner.nextInt();
            scanner.nextLine();
            switch(action){
                case 0:
                    System.out.println("Ending playlist");
                    quit = true;
                    break;
                case 1:
                    if (!goingForward){
                        if (listIterator.hasNext()){
                            listIterator.next();
                        }
                        goingForward = true;
                    }
                    if (listIterator.hasNext()){
                        System.out.println("Now playing " + listIterator.next().toString());
                    } else {
                        System.out.println("Reached the end of the playlist");
                        goingForward = false;
                    }
                    break;
                case 2:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.previous();
                        }
                        goingForward = false;
                    }
                    if (listIterator.hasPrevious()){
                        System.out.println("Now playing " + listIterator.previous().toString());
                    } else {
                        System.out.println("We are at the start of the playlist");
                        goingForward = true;
                    }
                    break;
                case 3:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            System.out.println("Now playing " + listIterator.previous().toString());
                            listIterator.next();
                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            System.out.println("Now playing " + listIterator.next().toString());
                            listIterator.previous();
                        } else {
                            System.out.println("Reached the end of the playlist");
                        }
                    }
                    break;
                case 4:
                    printPlaylist(playlist);
                    break;
                case 5:
                    if (goingForward){
                        if (listIterator.hasPrevious()){
                            listIterator.remove();
                            System.out.println("Removed successfully");
                            if (listIterator.hasNext()){
                                System.out.println("Now playing " + listIterator.next().toString());
                            } else {
                                System.out.println("Reached the end of the playlist");
                                listIterator.previous();
                                listIterator.next();
                            }

                        } else {
                            System.out.println("We are at the start of the playlist");
                        }
                    } else {
                        if (listIterator.hasNext()){
                            listIterator.remove();
                            System.out.println("Removed successfully");
                            System.out.println("Now playing " + listIterator.next().toString());
                            listIterator.previous();
                        } else {
                            System.out.println("Reached the end of the playlist");
                        }
                    }
                    break;
                case 6:
                    printMenu();
                    break;
            }
        }

    }

    private static void addSongToPlaylist (LinkedList playlist, Song song){
        if (searchInAlbums(song)){
            if (playlist.contains(song)){
                System.out.println("Song already in the playlist");
                return;
            } else {
                playlist.add(song);
            }
        } else {
            System.out.println("Can't find the song " + song.getTitle() + " in any album.");
        }
    }

    private static boolean searchInAlbums(Song song){
        for (int i = 0; i < albums.size(); i++){
            if (albums.get(i).findSong(song)){
                return true;
            }
        }
        return false;
    }
    private static void printPlaylist (LinkedList playlist){
        Iterator<Song> i = playlist.iterator();
        while (i.hasNext()){
            System.out.println(i.next().toString());
        }
        System.out.println("================================");
    }

    private static void printMenu (){
        System.out.println("Available actions: \npress ");
        System.out.println("0 - to quit\n" +
                "1 - Skip forward\n" +
                "2 - Skip backwards\n" +
                "3 - Replay song\n" +
                "4 - List songs in playlist\n" +
                "5 - Remove song form playlist^\n" +
                "6 - Print menu");
    }
}
