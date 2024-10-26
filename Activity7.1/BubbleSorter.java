import java.util.Random;

public class BubbleSorter{
    private int[] array;//@array declaration

    public BubbleSorter(int size){//@ array initialization
        array = new int[size];
        Random rand = new Random();
        for(int i=0; i<size; i++){
            array[i]= rand.nextInt();
        }
    }

public String toString(){
    String finalString = "";

    for(int i=0 ; i< array.length; i++){
        finalString += array[i];
        if (i!= array.length-1){
            finalString+= ",";
        }
    }
    return finalString;
}

private void swap(int x, int y){
    int swapper = array[x];//@ array element
    array[x]= array[y];
    array [y] = swapper;
} 

public void sort() {
    boolean done = false;
    while (!done) {
        done = true;
        for (int i = 1; i < array.length; i++) {//@bounds checking 
            if (array[i-1] > array[i]) {
                swap(i-1, i);
                done = false;
            }
        }
    }

}

}
