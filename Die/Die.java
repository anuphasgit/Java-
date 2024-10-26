import java.util.Random;

/**
 * 
 * 
 * 
 * 
 */

 public class Die{
    private int faceValue;
    private int numSides;
    public static final int DEFAULT_SIDES=6;

    /**
     * 
     * Constructor with default number of sides(6).
     */
    public Die(){
        this(DEFAULT_SIDES);
        // numSides=6;
        // Random rand = new Random();
        // faceValue= rand.nextInt(numSides)+1;

    }

    /**
     * 
     * @param numberOfSides
     */
    public Die(int numberOfSides){
        numSides= numberOfSides;
        // Random rand = new Random();
        // faceValue=rand.nextInt(numSides)+1;
        roll();

    }

    /**
     * 
     * Return the current facevalue.
     * @return current facee value.
     */
    public int getFaceValue(){
        return faceValue;
    }

    /**
     * 
     * Return the number of Die sides,
     * @return num of Die side,
     */
    public int getNumberOfSides(){
        return numSides;
    }

    /**
     * 
     * Update face value to given value.
     * @param new face value.
     */
    public void setFaceValue(int newValue){
        if( newValue>0&& newValue<=numSides ) {
            faceValue= newValue;
        }
    }
    public int roll(){
        Random rand= new Random();
        faceValue= rand.nextInt(numSides)+1;
        return faceValue;
    }
    /**
     * Return a String with current face value and number of sides
     */
    public String toString(){
        String str="Die: faceValue: "+ faceValue
                      +",numOfSides: "+ numSides

    }
 }