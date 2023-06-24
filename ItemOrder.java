public class ItemOrder {
    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice() throws Exception {
        return item.priceFor(quantity);//calls on the price method from item to do the calculations
    }

    //this method just returves the item (it will be importand for the shoppingCart class)
    public Item getItem() {
        return item;
    }

    //I added this for testing my code
    public String toString(){
        return item.toString();
    }
}
