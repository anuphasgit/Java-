import java.util.Scanner;

/**
 * This is a method that text book site menu to the user.
 * The menu includes options to print TextBook posts, add new post,
 * delete a post, comment a post, read a post and quit application.
 * 
 * @author Anup
 */

public class TextBookDriver {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        System.out.print("Please enter your name to enter TextBook: ");
        String audience = keyboard.nextLine();
        System.out.println(audience+ ", welcome to TextBook - the totally text social media site! ");
        
        String userInput;
        boolean input = true;

        
        displayMenu();

        while(input){
            System.out.print("Select a menu option or reprint the (M)enu:");
            userInput = keyboard.nextLine();
            TextBook newTextBook = new TextBook();
            switch(userInput.trim().toLowerCase()){

                case "m":

                displayMenu();

                break;

                case "p":
                System.out.println("TextBook has "+ newTextBook.getPostCount()+" post:");
                System.out.println(newTextBook.toString());
                break;

                case "a":
                System.out.println("Enter the text for your new post: ");
                userInput = keyboard.nextLine();
                break;

                case "d":
                System.out.print("Enter the index of the post you want to delete: ");
                if (keyboard.hasNextInt()){
                    int index = keyboard.nextInt();
                    keyboard.nextLine();
                    if(index>=0 && index<newTextBook.getPostCount()){
                        if(!(newTextBook.removePost(index)==null)){
                            System.out.println("Post at index "+index+ " deleted.");
                        }else{
                            System.out.println("Post at index"+ index +" does not exist");
                        }
                    }else{
                        System.out.println("Invalid Index.");
                    }
                }else{
                    System.out.println("Invalid input. Please enterr an integer.");
                }
                

                break;

                
                case "c":
                System.out.print("Enter the index of the post to comment on:");
                userInput = keyboard.nextLine();
                System.out.print("Enter your comment: ");
                userInput = keyboard.nextLine();
                break;

                case "r":
                System.out.print("Please enter the index of the Post to read: ");
                userInput = keyboard.nextLine();
                

                break;

                case "q":
                    System.out.println("GoodBye, "+ audience);
                    input = false;
                   
                break;

                default:
                System.out.println("Choice is invalid.");

            }

        }
        keyboard.close();
    }

    public static void displayMenu(){
        System.out.println("Text Book Site Menu");
        System.out.println("-----------------------------------");
        System.out.println("    (P)rint TextBook posts");
        System.out.println("    (A)dd a new post");
        System.out.println("    (D)elete a post");
        System.out.println("    (C)omment on a post");
        System.out.println("    (R)ead a post with comments");
        System.out.println("    (Q)uit");
        System.out.println("-----------------------------------");

    }
}
