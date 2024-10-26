import java.util.scanner;

public class ConvertToHMS
{
    public static void main(string[]args)
    {
        Scanner kbd= new Scanner(System.in);
        String input=kbd.nextline();
        System.out.println("Enter the number of seconds:");
        
        int time= Integer.parse.Int(input);
        int hours= time / 3600;
        int minutes= time % 3600/60;
        int seconds= time % 60;

        System.out.println(
     kbd.close();
    }

}