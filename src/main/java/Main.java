import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 10));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 9, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems1 = new ArrayList<>();
        anotherItems1.add(new Item("Sprite", 1, 1000, 10));
        anotherItems1.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems1.add(new Item("Coke", 3, 1000, 0));
        anotherItems1.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems1.add(new Item("Water", 5, 1000, 10));
        anotherItems1.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems1.add(new Item("Coffee", 7, 1000, 10));
        anotherItems1.add(new Item("Mint Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();

        DVM mainDVM = new DVM("Gangnam",10,3, 5000000, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("GuangJinGu",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);

        MainGUI mainGUI = new MainGUI(mainDVM, 0, 0);
        MainGUI secondMainGUI = new MainGUI(anotherDVM, 0, 0);
    }

}