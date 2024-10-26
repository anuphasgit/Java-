import java.io.FileNotFoundException;
import java.util.ArrayList;  
import java.util.Scanner;
import java.io.File;

/**
 * 
 * The JukeBoxHero class is a driver class for the Song class.
 * It allows user to load a catalog of songs from a file, search for songs by title,analyze
 * the catalog, and print the entire catalog of songs.
 * @author Anup
 */
public class JukeboxHero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Song> songList= new ArrayList<Song>();
       
        String userInput;
        boolean input = true;

        displayMenu();// Displays the menu initially//

        while (input) {
            System.out.print("Please enter a command: ");
            userInput = scanner.nextLine();

            switch (userInput.trim().toLowerCase()) {
                case "l":// Loads catalog
                    System.out.println("Load catalog...");
                    System.out.println("Enter filename: ");
                    String fileName= scanner.nextLine();
                    
                    try{
                        File file= new File(fileName);// Opening file
                        Scanner fileScanner= new Scanner (file);
                        songList.clear();
                         while (fileScanner.hasNextLine())
                        {
                            String line= fileScanner.nextLine();
                            Scanner lineScanner= new Scanner(line);
                            lineScanner.useDelimiter(",");
                            String artist = lineScanner.next();
                            String album = lineScanner.next();
                            String title= lineScanner.next();
                            int playTime= lineScanner.nextInt();
                            Song song = new Song(title, artist, album, playTime);
                            songList.add(song);
                            lineScanner.close();
                        }
                        System.out.println("Sucessfully loaded "+ songList.size()+" songs!");
                        fileScanner.close();
                    }
                    catch (FileNotFoundException e){
                        System.out.println("Unable to open file: "+fileName);
                    }   
                            
                    break;
                
                //Searches catalog
                case "s":
                System.out.println("Search catalog....");
                System.out.println("Please enter the search query: ");
                String query= scanner.nextLine();
                query = query.toLowerCase();
                ArrayList<Song> searchResults= new ArrayList<Song>();

                for (Song song:songList){
                    if (song.getTitle().toLowerCase().contains(query)){
                        searchResults.add(song);
                    }
                }
                System.out.println("Found "+ searchResults.size()+" matches");
                System.out.println("---------------------------------");
                for(Song song: searchResults){  
                    System.out.println(song);
                }
                    break;
                
                 // Analyzes catalog
                case "a":
                ArrayList<String> artistList= new ArrayList<>();
                ArrayList<String> albumList=new ArrayList<>();
                for (Song song:songList ){
                    String artist= song.getArtist();
                    String album= song.getAlbum();

                    if(!albumList.contains(album)){
                        albumList.add(album);
                    }

                    if(!artistList.contains(artist)){
                        artistList.add(artist);
                    }
                }
                    int numArtist= artistList.size();
                    int numAlbum= albumList.size();
                    int numSongs= songList.size();
                    System.out.println("Catalogue analysis...");
                    System.out.println("Number of artist: "+numArtist);
                    System.out.println("Number of album: "+numAlbum);
                    System.out.println("Number of songs: "+numSongs);
                
                    int playTime=0;
                for(Song song:songList){
                    playTime= playTime+song.getPlayTime();
                }
                System.out.println("Catalog Playtime: "+ playTime);
                    break;

                //Prints catalog
                case "p":
                System.out.println("Song list contains "+songList.size()+" songs...");
                System.out.println("---------------------------------");
                    for(Song song: songList){
                        System.out.println(song);
                    }
                    break;

                //Displays menu
                case "m":
                    displayMenu();
                    break;

                // Quits program
                case "q":
                    System.out.println("Goodbye!");
                    input = false;
                    break;

                default:
                    System.out.println("Invalid Selection");
                    break;
            }

        }
        scanner.close();
    }

    public static void displayMenu() {
        System.out.println("*****************************");
        System.out.println("*      Program Menu         *");
        System.out.println("*****************************");
        System.out.println("(L)oad catalog");
        System.out.println("(S)earch catalog");
        System.out.println("(A)nalyse catalog");
        System.out.println("(P)rint catalog");
        System.out.println("(M)enu");
        System.out.println("(Q)uit");
    }
}