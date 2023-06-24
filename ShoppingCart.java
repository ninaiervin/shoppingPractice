//Nina Ervin
//3/30/23
//

import java.util.*;

public class ShoppingCart {

    public static final double DISCOUNT_PERCENT = 0.9;
    private ArrayList<ItemOrder> list;
    private boolean discount;

    public ShoppingCart() {
         list = new ArrayList<>();
    }

    public void add(ItemOrder next) {
        int index = -1;
        Item nextItem = next.getItem();//retrives the item from the itemOrder (we want to use the equals method from item so we need to get these just to an item)
        //runs through the ArrayList to check for any of the same lists before
        for(int i = 0; i < list.size(); i++){
            Item itemForList = list.get(i).getItem();//you start with an array of ItemOrders -> just the idemOrder at index i -> just the item from the itemOrder
            //this sets the index var to the index of the matching item so that it can be replaces
            if(nextItem.equals(itemForList)){
                index = i;
                list.set(i, next);
                return;
            }
        }
        //the item gets added pr replaces an older if the same item
        if(index == -1){
            list.add(next);
        }

    }

    public void setDiscount(boolean discount) {
        this.discount = discount;
    }

    //this metod runs throught all the itemOrders and gets the price of each and adds it together to get the total and then will take the discount if the box is checked
    public double getTotal() throws Exception {
        double price = 0;
        for(int i = 0; i < list.size(); i++){
            price = price + list.get(i).getPrice();
        }
        if (discount == false){
            return price;
        }
        return price*DISCOUNT_PERCENT;
    }

    //this was to help for testing the add method.
    public String toString(){
        String print = "";
        for(int i = 0; i < list.size(); i++){
            print = print + ", " + list.get(i).getItem();
        }
        return print;
    }
}
