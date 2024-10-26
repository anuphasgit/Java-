import java.text.NumberFormat;

/**
 * Represents one bag of coffee for sale.
 * @author mvail and CS121
 */
public class BagOfCoffee {
    private String productName;
    private int bagSize; 
    private int units;
    private double unitPrice;
    private boolean isWholeBean;
    private boolean isDecaf;
    private double rating;
    private static final int DEFAULT_BAG_SIZE= 16;
    private static final boolean DEFAULT_IS_WHOLE_BEAN= true;
    private static final boolean DEFAULT_IS_DECAF= false;
    private static final int DEFAULT_UNITS=0;
    private static final double DEFAULT_RATING=5;


/**
 * 
 *
 * @param productName
 * @param unitPrice
 * @param numberOfUnits
 */
public BagOfCoffee(String productName, double unitPrice){
    this(productName,unitPrice, DEFAULT_UNITS);
}
public BagOfCoffee(String productName, double unitPrice, int numberOfUnits){
    this.productName = productName;
    this.unitPrice= unitPrice;
    bagSize= DEFAULT_BAG_SIZE;
    units =numberOfUnits;
    isWholeBean = DEFAULT_IS_WHOLE_BEAN;
    isDecaf= DEFAULT_IS_DECAF;
    rating= DEFAULT_RATING;

}
    public String toString(){
        NumberFormat currencyFormatter= NumberFormat.getCurrencyInstance();
        return"product Name:"+ productName
            +"\nunitPrice"+ currencyFormatter.format(unitPrice)
            +"\nNumber of Units: "+units
            +"\nBag Size(oz): "+bagSize
            +"\nWhole Bean? "+isWholeBean
            +"\nDecaf?"+isDecaf
            +"\nRating out of 5: "+rating;
    }
    /**
     * 
     * Return current number of units.
     * @return current number of units
     */
    public int getNumberOfUnits(){
        return units;
    }

    public double getUnitPrice(){
        return unitPrice;
    }

    public void setNumberOfUnits(int newNumberOfUnits){
        units= newNumberOfUnits;
    }

    public void setUnitPrice(int newUnitPrice){
        unitPrice= newUnitPrice;
    }
}
