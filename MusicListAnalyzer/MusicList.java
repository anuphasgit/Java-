import java.util.Scanner;
/**
 * This main method inputs track information from the user, creates three track objects and perform the following calculations:
 * 1. Calculates the average play time and prints it.
 * 2. Identifies the track with play time closest to 180 seconds and prints it.
 * 3. Creates a sorted music list with tracks sorted by play time in descending order. 
 * @author Anup Bhattarai
 */
public class MusicList{
    public static void main(String[] args) {
        
        Scanner keyBoardScanner= new Scanner(System.in);

        // Track0
        System.out.print("Enter album:");
        String album0= keyBoardScanner.nextLine();

        System.out.print("Enter artist:");
        String artist0= keyBoardScanner.nextLine();

        System.out.print("Enter title:");
        String title0= keyBoardScanner.nextLine();

        System.out.print("Enter play time(mm:ss):");
        String playTime0= keyBoardScanner.nextLine();

        int colonIndex=playTime0.indexOf(':');
        String minutes=playTime0.substring(0,colonIndex);
        String seconds= playTime0.substring(colonIndex+1);
        int minutesTime= Integer.parseInt(minutes);
        int secondsTime= Integer.parseInt(seconds);
        int songLength= minutesTime*60+secondsTime;

        Track track0=new Track(title0, artist0, album0, songLength);

        //Track1

        System.out.print("Enter album:");
        String album1= keyBoardScanner.nextLine();

        System.out.print("Enter artist:");
        String artist1= keyBoardScanner.nextLine();

        System.out.print("Enter title:");
        String title1= keyBoardScanner.nextLine();

        System.out.print("Enter play time(mm:ss):");
        String playTime1= keyBoardScanner.nextLine();

        int colonIndex1=playTime1.indexOf(':');
        String minutes1=playTime1.substring(0,colonIndex1);
        String seconds1= playTime1.substring(colonIndex1+1);
        int minutesTime1= Integer.parseInt(minutes1);
        int secondsTime1= Integer.parseInt(seconds1);
        int songLength1= minutesTime1*60+secondsTime1;

        Track track1=new Track(title1, artist1, album1, songLength1);
        
        //Track2

        System.out.print("Enter album:");
        String album2= keyBoardScanner.nextLine();

        System.out.print("Enter artist:");
        String artist2= keyBoardScanner.nextLine();

        System.out.print("Enter title:");
        String title2= keyBoardScanner.nextLine();

        System.out.print("Enter play time(mm:ss):");
        String playTime2= keyBoardScanner.nextLine();

        int colonIndex2=playTime2.indexOf(':');
        String minutes2=playTime2.substring(0,colonIndex2);
        String seconds2= playTime2.substring(colonIndex2+1);
        int minutesTime2= Integer.parseInt(minutes2);
        int secondsTime2= Integer.parseInt(seconds2);
        int songLength2= minutesTime2*60+secondsTime2;

        Track track2=new Track(title2, artist2, album2, songLength2);

        //Calculating average playtime

        int playTimeSum= track0.getPlayTime()+track1.getPlayTime()+track2.getPlayTime();
        double playTimeAverage= playTimeSum/3.0;
        System.out.println();
        System.out.printf("Average play time: %.2f\n",playTimeAverage);
        System.out.println();
        
       //Calculating track closest to 180 seconds.

       int absPlayTime0= Math.abs(180-track0.getPlayTime());
       int absPlayTime1= Math.abs(180-track1.getPlayTime());
       int absPlayTime2= Math.abs(180-track2.getPlayTime());

       if (absPlayTime0<=absPlayTime1&&absPlayTime0<=absPlayTime2){
            System.out.println("Track with play time closest to 180 secs is: " + track0.getTitle());
        }
      else if(absPlayTime1<=absPlayTime0&&absPlayTime1<=absPlayTime2){
            System.out.println("Track with play time closest to 180 secs is: " + track1.getTitle());
        }
      else{
            System.out.println("Track with play time closest to 180 secs is: "+ track2.getTitle());
        }
        System.out.println();
       
        //Building a sorted music list

        String border="========================================================================================";
        System.out.println(border);
        System.out.println("Title                          Artist               Album                           Time");
        System.out.println(border);

        
           
        if (track0.getPlayTime() >= track1.getPlayTime() && track0.getPlayTime() >= track2.getPlayTime()) {
            if (track1.getPlayTime() >= track2.getPlayTime()) {
                System.out.println(track0.toString());
                System.out.println(track1.toString());
                System.out.println(track2.toString());
            } else {
                System.out.println(track0.toString());
                System.out.println(track2.toString());
                System.out.println(track1.toString());
            }
        } else if (track1.getPlayTime() >= track0.getPlayTime() && track1.getPlayTime() >= track2.getPlayTime()) {
            if (track0.getPlayTime() >= track2.getPlayTime()) {
                System.out.println(track1.toString());
                System.out.println(track0.toString());
                System.out.println(track2.toString());
            } else {
                System.out.println(track1.toString());
                System.out.println(track2.toString());
                System.out.println(track0.toString());
            }
        } else {
            if (track0.getPlayTime() >= track1.getPlayTime()) {
                System.out.println(track2.toString());
                System.out.println(track0.toString());
                System.out.println(track1.toString());
            } else {
                System.out.println(track2.toString());
                System.out.println(track1.toString());
                System.out.println(track0.toString());
            }
        }
      
        System.out.println(border);
        

        keyBoardScanner.close();
    }
}
