//item is where it all starts
//this is the building block for everything else


import java.text.*;
public class Item {
    private static final Exception IllegalArgumentException = null;
    // You will need to add more instance variables
    private double price;
    private double bulkPrice;
    private String Name;
    private int blukQuantity;

    //there are two different constructes based on bulk vs no bulk produts
    public Item(String name, double price) throws Exception {
        if (price >= 0){
            this.Name = name;
            this.price = price;
        }else{
            throw IllegalArgumentException;
        }
    }

    public Item(String name, double price, int bulkQuantity, double bulkPrice) throws Exception {
        if(price >= 0 && bulkPrice >= 0){
            this.Name = name;
            this.price = price;
            this.bulkPrice = bulkPrice;
            this.blukQuantity = bulkQuantity;
        }else {
            throw IllegalArgumentException;
        }
    }


//this is a method that calculates the price with or without bulk pricing

// in my old code there was an infinite loop here because I had a while statement that counted on bulkQuantity
//not to be 0. quantity-bulk quantity is still the same number so it will never end.
    public double priceFor(int quantity) throws Exception {
        //this makes sure that your not / by 0
        if(quantity >= 0 && blukQuantity !=0){
            return (quantity/blukQuantity*bulkPrice) + (quantity%blukQuantity*price);
        }else if(quantity >= 0){
            return (quantity*price);
        }else{
            throw IllegalArgumentException;
        }

    }

    //this method will return for print out name, $0.00 (0 for $0.00) or name, $0.00
    public String toString() {
        NumberFormat nf = NumberFormat.getCurrencyInstance();
        if(bulkPrice != 0 && blukQuantity != 0){
            return Name + ", " + nf.format(price) + "(" + blukQuantity + " for " + nf.format(bulkPrice) + ")";
        }
        return Name + ", " + nf.format(price);
    }

    //this is the method that takes in 2 items and will tell if they are the same or different items 
    public boolean equals(Object o){
        if(o == null){
            return false;
        }
        if(getClass() != o.getClass()){
            return false;
        }
        Item other = (Item) o; //this is convrting an object to an item so you can compare them
        //this is your do these two items refur to the same item
        if(this == o){
            return true;
        }
        //if two items are identical but dont refur to the same this this if statment will check for that
        if(other.price == price && Name.equals(other.Name) && bulkPrice == other.bulkPrice && blukQuantity == other.blukQuantity){
            return true;
        }
        return false;
    }
}
