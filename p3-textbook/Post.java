import java.util.ArrayList;
import java.time.Instant;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;

public class Post implements PostInterface {
    private String author;
    private String text;
    private Instant timestamp;
    private int postID;
    private ArrayList<String> comments;


    public Post(int postID, String author, String text){
        this.postID = postID;
        this.author = author.replace(" ", "");
        this.text = text;
        this.timestamp = Instant.now();
        this.comments=new ArrayList<String>();

        DecimalFormat format= new DecimalFormat("00000");
        String formattedPostID = format.format(postID);

        String filename = this.getFilename();
        try{
            PrintWriter pw = new PrintWriter(new File(filename));
            pw.println(formattedPostID+" "+this.timestamp + " "+ author+" "+text);//confirm for full stop 
            pw.close();
        }catch(FileNotFoundException e){
            System.out.println("Could not create.");
        }

    }
    
 
    public Post(int postID){
        this.postID = postID;
        this.text="";
        this.comments=new ArrayList<String>();
        String filename=this.getFilename();
        File file = new File(filename);

        try (Scanner scanner= new Scanner(file)){
            Scanner lineScanner= new Scanner(scanner.nextLine());
            lineScanner.useDelimiter(" ");
            this.postID=Integer.parseInt(lineScanner.next());
            this.timestamp=Instant.parse(lineScanner.next());
            this.author=lineScanner.next();
            while(lineScanner.hasNext())
            {
                this.text+=lineScanner.next()+" ";
            }
            this.text=this.text.trim();
            while(scanner.hasNextLine()){
                String comment = scanner.nextLine();
                this.comments.add(comment);
            }
        }catch(FileNotFoundException e){
            System.out.println("Couldnot open file");
        }

    }

    public void addComment(String author, String text){
        Instant commentTimestamp= Instant.now();

        this.comments.add(commentTimestamp+" "+author+" "+text);

        String filename = this.getFilename();
            try{
                PrintWriter pw = new PrintWriter(new FileOutputStream(new File(filename), true));
                pw.println(timestamp + " " + author + " " + text);
                pw.close();
            }catch(FileNotFoundException e){
                System.out.println("Could not create.");
            }

    }
    
    public String getFilename(){
        DecimalFormat format= new DecimalFormat("00000");
        String formattedPostID = format.format(postID);
        String filename = "Post-" + formattedPostID + ".txt";
        return filename;
    }

    public String toStringPostOnly(){
        return String.format("%05d %s %s %s", this.postID,this.timestamp,this.author,this.text);
    }
    
    public String toString(){
        String postHeader= String.format("Post:\n%s\n", this.toStringPostOnly());
        String commentHeader= "Comments:";
        String commentBody= "";
        for (String comment : this.comments){
             commentBody += "\n"+comment;
        }
        return postHeader+commentHeader+commentBody;
       }

    public int getPostID(){
        return this.postID;
    }

    public String getAuthor(){
        return this.author;
    }

    public String getText(){
        return this.text;
    }
    public Instant getTimestamp(){
        return this.timestamp;
    }

}
