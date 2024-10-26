import java.util.ArrayList;
/**
 * 
 * 
 */
public class OnlineStore {
    public static void main(String[] args) {
        ArrayList<BagOfCoffee> inventory = new ArrayList<BagOfCoffee>();

        BagOfCoffee bag1 = new BagOfCoffee("Buzzsaw Blend", 10.5);
        inventory.add(bag1);
        BagOfCoffee bag2 = new BagOfCoffee("Sleepytime", 9.9);
        inventory.add(bag2);


        inventory.add(new BagOfCoffee("Night Blend",11.0));
        inventory.add(new BagOfCoffee("Heartstopper Blend",13.25,500));

        for(BagOfCoffee bag: inventory){
            System.out.println(bag);
            System.out.println();
        }
        
        System.out.println("Updated unit price: "+ bag1.getUnitPrice());
        System.out.println("Updated bag is "+bag1.toString());

    }
}