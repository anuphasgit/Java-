
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Scanner;

public class TextBook implements TextBookInterface {
    private ArrayList<Post> posts;
    private int lastID;

    public static final String POST_LIST_FILENAME = "posts.txt";
    
    public TextBook() {
        this.posts = new ArrayList<>();
        this.lastID = 0;
        File postsFile=new File(POST_LIST_FILENAME);
        if(postsFile.exists()){
            try{
                Scanner fileScanner = new Scanner(postsFile);
                while(fileScanner.hasNext()){
                    int postID=Integer.parseInt(fileScanner.nextLine());
                    //for(int i=1;i<=postID;i++){
                    Post post=new Post(postID);
                    this.posts.add(post);
                    this.lastID=postID;
                    }
                fileScanner.close();
            }catch(FileNotFoundException fnfe){
                System.out.println("File Not Found!");
            }
        }else{
            try
            {
                PrintWriter pw = new PrintWriter(new File(POST_LIST_FILENAME));
                pw.close();
            }
            catch (FileNotFoundException fnfe)
            {
                System.out.println("couldn't create file");
            }

            this.lastID=0;
        }
    }

    public boolean addPost(String author, String text){
        this.lastID++;
        Post newPost = new Post(this.lastID, author,text );
        this.posts.add(newPost);

        try{PrintWriter pw = new PrintWriter(new FileOutputStream(new File(POST_LIST_FILENAME), true));
            pw.println(this.lastID);
            pw.close();
            return true;
        }catch (IOException e){
            return false;
        }
    }

    public Post removePost(int index){
        if(index<0||index>=getPostCount()){
            return null;
        }

        Post removePost = this.posts.remove(index);
        try(PrintWriter pw = new PrintWriter(new File(POST_LIST_FILENAME))){
            for (Post post: this.posts){
                pw.println(post.getPostID());
            }
        } catch(IOException e){
             
        }
        return removePost;
    }
   
    public boolean addComment(int postIndex, String author, String text) {
        if (postIndex < 0 || postIndex >= posts.size())
            return false;
        Post post = posts.get(postIndex);
        post.addComment(author, text);
        return true;
    }

  
    public String getPostString(int postIndex) {
        if (postIndex < 0 || postIndex >= posts.size())
            return null;

        Post post = posts.get(postIndex);
        return post.toString();
    }

   
    public ArrayList<Post> getPosts() {
        ArrayList<Post> copyPosts = new ArrayList<>();
        for (Post post : posts) {
            copyPosts.add(post);
        }
        return copyPosts;
    }

    public String toString(){
        String string= "TextBook contains "+ getPostCount()+ " posts:";
        for (int i=0; i<getPostCount(); i++){
            string +="\n" +i + " - "+ posts.get(i).toStringPostOnly();
        }
        return string;
    }

    public int getPostCount() {
        return posts.size();
    }

    
    public int getLastID() {
        return this.lastID;
    }
}
