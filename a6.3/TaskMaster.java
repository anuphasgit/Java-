public class TaskMaster {
    public static void main(String[] args) {
        // Task 1
        Task task1 = new Task("Finish Activity 6.3");
        System.out.println("Task 1");
        System.out.println(task1); 
        task1.setComplete(true);
        System.out.println("Task 1 is complete: " + task1.getisComplete()); 
        System.out.println(task1); 
        task1.setcategory(Category.SCHOOL);
        System.out.println("Task 1 category: " + task1.getcategory()); 
        System.out.println(task1); 

        // Task 2
        Task task2 = new Task("Give Tigger a bath", 10);
        System.out.println("\nTask 2");
        System.out.println(task2); 
        task2.setpriority(20);
        System.out.println("Task 2 priority: " + task2.getpriority());
        System.out.println(task2); 
    }
}