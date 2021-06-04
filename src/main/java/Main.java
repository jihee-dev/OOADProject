import java.util.ArrayList;

public class Main {


    public static void main(String[] args) {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 1));
        myItems.add(new Item("Milk Coffee", 9, 1000, 0));
        myItems.add(new Item("Latte", 10, 1000, 10));

        myItems.add(new Item("Espresso", 11, 1000, 0));
        myItems.add(new Item("Beer", 12, 1000, 0));
        myItems.add(new Item("Fanta Orange", 13, 1000, 0));
        myItems.add(new Item("Fanta Grape", 14, 1000, 0));
        myItems.add(new Item("2%", 15, 1000, 0));
        myItems.add(new Item("Tonic Water", 16, 1000, 0));
        myItems.add(new Item("Whisky", 17, 1000, 0));
        myItems.add(new Item("Vodka", 18, 1000, 0));
        myItems.add(new Item("Brandy", 19, 1000, 0));
        myItems.add(new Item("Champagne", 20, 2000, 0));

        ArrayList<Item> anotherItems1 = new ArrayList<>();
        anotherItems1.add(new Item("Sprite", 1, 1000, 10));
        anotherItems1.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems1.add(new Item("Coke", 3, 1000, 0));
        anotherItems1.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems1.add(new Item("Water", 5, 1000, 10));
        anotherItems1.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems1.add(new Item("Coffee", 7, 1000, 0));
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 1));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 0));
        anotherItems1.add(new Item("Latte", 10, 1000, 0));

        anotherItems1.add(new Item("Espresso", 11, 1000, 10));
        anotherItems1.add(new Item("Beer", 12, 1000, 0));
        anotherItems1.add(new Item("Fanta Orange", 13, 1000, 0));
        anotherItems1.add(new Item("Fanta Grape", 14, 1000, 0));
        anotherItems1.add(new Item("2%", 15, 1000, 0));
        anotherItems1.add(new Item("Tonic Water", 16, 1000, 0));
        anotherItems1.add(new Item("Whisky", 17, 1000, 0));
        anotherItems1.add(new Item("Vodka", 18, 1000, 0));
        anotherItems1.add(new Item("Brandy", 19, 1000, 0));
        anotherItems1.add(new Item("Champagne", 20, 2000, 0));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 0));
        anotherItems2.add(new Item("Water", 5, 1000, 0));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 0));
        anotherItems2.add(new Item("Coffee", 7, 1000, 0));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 2));
        anotherItems2.add(new Item("Latte", 10, 1000, 10));

        anotherItems2.add(new Item("Espresso", 11, 1000, 0));
        anotherItems2.add(new Item("Beer", 12, 1000, 0));
        anotherItems2.add(new Item("Fanta Orange", 13, 1000, 0));
        anotherItems2.add(new Item("Fanta Grape", 14, 1000, 1));
        anotherItems2.add(new Item("2%", 15, 1000, 0));
        anotherItems2.add(new Item("Tonic Water", 16, 1000, 0));
        anotherItems2.add(new Item("Whisky", 17, 1000, 0));
        anotherItems2.add(new Item("Vodka", 18, 1000, 0));
        anotherItems2.add(new Item("Brandy", 19, 1000, 0));
        anotherItems2.add(new Item("Champagne", 20, 2000, 1));

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2);
//        DVM anotherDVM3 = new DVM("Another DVM 3",16,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM4 = new DVM("Another DVM 4",14,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM5 = new DVM("Another DVM 5",15,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM6 = new DVM("Another DVM 6",11,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM7 = new DVM("Another DVM 7",9,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM8 = new DVM("Another DVM 8",52,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM9 = new DVM("Another DVM 9",158,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
//        DVM anotherDVM10 = new DVM("Another DVM 10",187,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        MainGUI thirdUI = new MainGUI(anotherDVM2, 0, 0);
        MainGUI secondMainGUI = new MainGUI(anotherDVM, 0, 0);
        MainGUI mainGUI = new MainGUI(mainDVM, 0, 0);
//        MainGUI testGUI = new MainGUI(anotherDVM10, 0, 0);
    }

}