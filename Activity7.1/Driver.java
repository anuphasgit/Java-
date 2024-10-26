public class Driver{
    public static void main(String[] args){
        BubbleSorter sorter = new BubbleSorter(12);
        System.out.println("Unsorted List:"+ sorter.toString());
         sorter.sort();
        System.out.println("Sorted List"+ sorter.toString());
        
    }
}
