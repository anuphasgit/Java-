import java.util.Scanner;

public class InputDemo
{
    public static void main(string[]args)
    {
        Scanner kbd= new Scanner(System.in);

        System.out.print("Please enter your age:");
        String input = kbd.nextline();
        int age=Integer.parseInt(input);
        System.out.println("Entered age was:"+age);
        kbd.close();
    }
}