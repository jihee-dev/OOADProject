public class Item {
    String itemName;
    int itemID;
    int itemPrice;
    int itemAmount;

    Item() {
        this.itemName = "null";
        this.itemID = -1;
        this.itemPrice = 0;
        this.itemAmount = 0;
    }

    public Item(String itemName, int itemID, int itemPrice, int itemAmount) {
        this.itemName = itemName;
        this.itemID = itemID;
        this.itemPrice = itemPrice;
        this.itemAmount = itemAmount;
    }

    public String getItemName() {
        return itemName;
    }

    public int getItemPrice() {
        return itemPrice;
    }

    public int getItemAmount() {
        return itemAmount;
    }

    public boolean changeAmount(String ItemName, int newAmount){
        if(newAmount>=0) {
            this.itemAmount = newAmount;
            return true;
        }
        else
            return false;
    }

    public void reduceAmount() {
        itemAmount -= 1;
    }
}