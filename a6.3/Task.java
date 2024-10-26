import java.util.Locale.Category;

public class Task {
    private string description;
    private int priority;
    private boolean isComplete;
    private Category category;

    public Task( String description){
        this.description= description;
    }

    public Task(String description,int priority){
        this.description=description;
        this.priority=2;
        this.isComplete= false;
        this.category= Category.NONE;
    }

    public String toString(){
     String complete;
     if(isComplete){
       complete="[]";
     }
     else{
        complete="[x]";
    }
    String descriptionString= description;
    String priorityString= Integer.toString(priority);
    return complete+ " "+ descriptionString+", "+priorityString+", "+category;

    }

    public String getdescription(){
        return description;
    }
    public void setdescription(String newDescription){
        this.description=newDescription;
    }

    public int getpriority(){
        return priority;
    }
    
    public void setpriority(int newPriority){
        this.priority= newPriority;
    }

    public boolean getisComplete(){
        return isComplete;
    }

    public Category getcategory(){
        return category;
    }

    public void setcategory(Category category){
        this.category=category;
    }
}




