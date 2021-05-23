import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.*;

class DVMTest {

    @Test
    void getItemFromName() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        String[] SuccessItemNames = {"Sprite","Mint Sprite","Coke","Mint Coke","Water","Sparkling","Coffee","Mint Coffee","Milk Coffee","Latte"};

        //success
        boolean flag = true;
        for(int i=0;i<SuccessItemNames.length;i++){
            String Item_name = SuccessItemNames[i];
            if(mainDVM.getItemFromName(Item_name) != mainDVM.getItemList().get(i))flag = false;
        }
        //Else fail

        assertEquals(true,flag);
        mainDVM.DVMList.clear();

    }

    @Test
    void getAnotherDVMInfo1() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
        //TestCase 1
        ArrayList<DVM> TestDVMList1 =  mainDVM.getAnotherDVMInfo("Sprite");
        assertEquals(2,TestDVMList1.size());
        mainDVM.DVMList.clear();
    }

    @Test
    void getAnotherDVMInfo2() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("5",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("6",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("7 ",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        ArrayList<DVM> TestDVMList2 = mainDVM.getAnotherDVMInfo("Coke");
        assertEquals(0,TestDVMList2.size());
        mainDVM.DVMList.clear();
    }

    @Test
    void getAnotherDVMInfo3() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        ArrayList<DVM> TestDVMList3 = mainDVM.getAnotherDVMInfo("Water");
        int cnt = 0;
        for(int i=0;i<TestDVMList3.size();i++){
            System.out.println(TestDVMList3.get(i).region);
            cnt++;
        }
        System.out.println(cnt);
        assertEquals(2,cnt);
        mainDVM.DVMList.clear();
    }
    @Test
    void removeCode() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
        //Testing Success
        HashMap<String,String> test_table = mainDVM.getCodeTable();

        Item testItem = myItems.get(0);
        String code = mainDVM.giveCode(testItem,false);
        mainDVM.removeCode(code);

        String result = test_table.get(code);
        assertEquals(null ,result);
        mainDVM.DVMList.clear();
    }

    @Test
    void removeCode2() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        //Testing 부여되지 않은 코드일 경우
        //런타임 에러가 나지 않는다면 flag = true
        String Invalid_code = "INVALID_CODE";
        boolean flag = true;
        try{
            mainDVM.removeCode(Invalid_code);
        }catch(RuntimeException e){
            flag = false;
        }
        assertEquals(true ,flag);
        mainDVM.DVMList.clear();
    }
    @Test
    void sortDVM() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        //sorted_list 가 오름차순이 아닐경우 flag = false.

        boolean flag = true;
        ArrayList<DVM> temp = mainDVM.sortDVM(mainDVM.DVMList);
        for(int i=0;i<temp.size()-1;i++){
            if(temp.get(i).dist > temp.get(i+1).dist)flag = false;
        }
        assertEquals(true,flag);
        mainDVM.DVMList.clear();
    }

    @Test
    void getNoneItemLocation() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);
        String test_Item = "Sprite";
        ArrayList<DVM> lists = mainDVM.getNoneItemLocation(test_Item);
        boolean flag = true;
        //스프라이트는 서로 다른 두개의 DVM 이 가지고있으므로 2개가 아니면 flag = false
        if(lists.size()!=2)flag = false;
        assertEquals(true,flag);
        mainDVM.DVMList.clear();
    }

    @Test
    void inputCode() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        HashMap<String,String> test_table = mainDVM.getCodeTable();
        Item test_item = mainDVM.getItemList().get(0);
        String test_code = mainDVM.giveCode(test_item,false);
        int success_ret_code = mainDVM.inputCode(test_code);
        // 성공 = 1
        assertEquals(1,success_ret_code);
        mainDVM.DVMList.clear();
    }

    @Test
    void inputCode2() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        HashMap<String,String> test_table = mainDVM.getCodeTable();

        Item No_Amount_Item = anotherDVM2.getItemList().get(2);
        String Fail_code = mainDVM.giveCode(No_Amount_Item,false);
        int No_Amount_ret_code = mainDVM.inputCode(Fail_code);
        //현재 재고가 부족하므로 코드 반환값 = 0
        assertEquals(0,No_Amount_ret_code);
        mainDVM.DVMList.clear();
    }
    @Test
    void inputCode3() {

        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        HashMap<String,String> test_table = mainDVM.getCodeTable();


        int Invalid_ret_code = mainDVM.inputCode("INVALID_CODE");
        //등록되지 않은 쿠폰일 경우 코드 반환값 = -1
        assertEquals(-1,Invalid_ret_code);
        mainDVM.DVMList.clear();
    }
    @Test
    void codeValidation() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        //등록된 코드일경우 success = true
        HashMap<String,String> test_table = mainDVM.getCodeTable();
        Item test_item = mainDVM.getItemList().get(0);
        String success_test_code = mainDVM.giveCode(test_item,false);
        boolean success = test_table.containsKey(success_test_code);
        assertEquals(true,success);
        mainDVM.DVMList.clear();

    }

    @Test
    void codeValidation2() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
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
        anotherItems1.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems1.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems1.add(new Item("Latte", 10, 1000, 10));

        ArrayList<Item> anotherItems2 = new ArrayList<>();
        anotherItems2.add(new Item("Sprite", 1, 1000, 10));
        anotherItems2.add(new Item("Mint Sprite", 2, 1000, 10));
        anotherItems2.add(new Item("Coke", 3, 1000, 0));
        anotherItems2.add(new Item("Mint Coke", 4, 1000, 10));
        anotherItems2.add(new Item("Water", 5, 1000, 10));
        anotherItems2.add(new Item("Sparkling", 6, 1000, 10));
        anotherItems2.add(new Item("Coffee", 7, 1000, 10));
        anotherItems2.add(new Item("Mint Coffee", 8, 1000, 10));
        anotherItems2.add(new Item("Milk Coffee", 9, 1000, 10));
        anotherItems2.add(new Item("Latte", 10, 1000, 0));

        Payment mainDVMPayment = new Payment();
        Payment anotherDVM1Payment = new Payment();
        Payment anotherDVM2Payment = new Payment();

        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        DVM anotherDVM = new DVM("Another DVM 1",3,4, 5000000, "admin", "1234", anotherItems1,0, anotherDVM1Payment);
        DVM anotherDVM2 = new DVM("Another DVM 2",17,15, 5000000, "admin", "1234", anotherItems2,0, anotherDVM2Payment);

        //등록되지 않은 코드 failed = false
        HashMap<String,String> test_table = mainDVM.getCodeTable();
        String failed_test_code = "INVALID_CODE";
        boolean failed = test_table.containsKey(failed_test_code);
        assertEquals(false,failed);
        mainDVM.DVMList.clear();
    }

    //============================================================

    @Test
    void getItemFromCode() { // DVM에 존재하는 아이템에 대한 실행
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String code = mainDVM.giveCode(sprite,false);
        Item findItem = mainDVM.getItemFromCode(code);
        assertEquals(sprite, findItem);
    }

    @Test
    void getItemFromCode2() { // DVM에 존재하지 않는 아이템에 대한 실행
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        Item latte = new Item("Latte", 10, 1000, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String code = mainDVM.giveCode(latte,false);
        Item findItem = mainDVM.getItemFromCode(code);
        assertTrue(findItem.getItemName()=="null");
    }

//==================================================================

    @Test
        //정상입력
    void login() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        String id = "admin"; String pw = "1234";
        assertTrue(dvm.login(id, pw));
    }@Test
        //id만 다를 경우
    void login2() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        String id = "ad"; String pw = "1234";
        assertTrue(!dvm.login(id, pw));
    }@Test
        //pw만 다를 경우
    void login3() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        String id = "admin"; String pw = "134";
        assertTrue(!dvm.login(id, pw));
    }@Test
        //id, pw 둘다 다를 경우
    void login4() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        String id = "ad"; String pw = "134";
        assertTrue(!dvm.login(id, pw));
    }

//==================================================================

    @Test
        //정상입력
    void manageAmount() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));

        Payment mainDVMPayment = new Payment();

        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String ItemName = "Coke"; int newAmount = 12;
        assertTrue(dvm.manageAmount(ItemName, newAmount));
    }@Test
        //아이템 이름 오류
    void manageAmount2() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));

        Payment mainDVMPayment = new Payment();

        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String ItemName = "Cola"; int newAmount = 12;
        assertTrue(!dvm.manageAmount(ItemName, newAmount));
    }@Test
        //입력 수량 오류
    void manageAmount3() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));

        Payment mainDVMPayment = new Payment();

        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String ItemName = "Coke"; int newAmount = -3;
        assertTrue(!dvm.manageAmount(ItemName, newAmount));
    }@Test
        //이름,수량 입력 오류
    void manageAmount4() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));

        Payment mainDVMPayment = new Payment();

        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String ItemName = "Cola"; int newAmount = -3;
        assertTrue(!dvm.manageAmount(ItemName, newAmount));
    }

//==================================================================

    @Test
        //newAmountCash>0
    void manageAmountCash() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        int newAmountCash = 5000;
        assertTrue(dvm.manageAmountCash(newAmountCash));
    }@Test
        //newAmountCash<0
    void manageAmountCash2() {
        ArrayList<Item> myItems = new ArrayList<>();
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        int newAmountCash = -5000;
        assertTrue(!dvm.manageAmountCash(newAmountCash));
    }

    //==================================================================

    @Test
        //정상입력
    void inputCash() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 1500, "admin", "1234", myItems,0, mainDVMPayment);
        int inputCash = 2000; Item selectedItem = new Item("Sprite", 1, 1000, 10);
        int result = dvm.inputCash(inputCash, selectedItem);
        assertEquals(1000,result);
    }@Test
        //거스름돈 부족
    void inputCash2() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);
        int inputCash = 2000; Item selectedItem = new Item("Sprite", 1, 1000, 10);
        int result = dvm.inputCash(inputCash, selectedItem);
        assertEquals(-2,result);
    }@Test
        //투입금액 부족
    void inputCash3() {
        ArrayList<Item> myItems = new ArrayList<>();
        myItems.add(new Item("Sprite", 1, 1000, 10));
        myItems.add(new Item("Mint Sprite", 2, 1000, 10));
        myItems.add(new Item("Coke", 3, 1000, 0));
        myItems.add(new Item("Mint Coke", 4, 1000, 10));
        myItems.add(new Item("Water", 5, 1000, 10));
        myItems.add(new Item("Sparkling", 6, 1000, 0));
        myItems.add(new Item("Coffee", 7, 1000, 10));
        myItems.add(new Item("Mint Coffee", 8, 1000, 10));
        myItems.add(new Item("Milk Coffee", 9, 1000, 10));
        myItems.add(new Item("Latte", 10, 1000, 10));
        Payment mainDVMPayment = new Payment();
        DVM dvm = new DVM("Main DVM",10,3, 1500, "admin", "1234", myItems,0, mainDVMPayment);
        int inputCash = 500; Item selectedItem = new Item("Sprite", 1, 1000, 10);
        int result = dvm.inputCash(inputCash, selectedItem);
        assertEquals(-1,result);
    }

    //==================================================================

    @Test
    void checkTotalCash() { // change > totalCash
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 10000, "admin", "1234", myItems,0, mainDVMPayment);

        boolean result = mainDVM.checkTotalCash(5000000);
        assertTrue(result);
    }

    @Test
    void checkTotalCash2() { // change <= totalCash
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 10000, "admin", "1234", myItems,0, mainDVMPayment);

        boolean result = mainDVM.checkTotalCash(500);
        assertFalse(result);
    }

    //============================================================

    @Test
    void insertCard() { // 정상구매
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        int result = mainDVM.insertCard("1234", sprite);
        assertEquals(1, result);
    }

    @Test
    void insertCard2() { // 잔액부족
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 999999, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        int result = mainDVM.insertCard("3572", sprite);
        assertEquals(0, result);
    }
    
    @Test
    void insertCard3() { // 잘못된카드번호
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 999999, 10);
        myItems.add(sprite);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        int result = mainDVM.insertCard("이상한번호", sprite);
        assertEquals(-1, result);
    }
    

    //============================================================

    @Test
    void giveItem() { // 재고가 떨어지는지 확인
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        Item mintSprite = new Item("Mint Sprite", 2, 1000, 10);
        Item coke = new Item("Coke", 3, 1000, 0);
        Item mindCoke = new Item("Mint Coke", 4, 1000, 10);
        Item water = new Item("Water", 5, 1000, 10);
        Item sparkling = new Item("Sparkling", 6, 1000, 0);
        Item coffee = new Item("Coffee", 7, 1000, 10);
        Item mintCoffee = new Item("Mint Coffee", 8, 1000, 10);
        Item milkCoffee = new Item("Milk Coffee", 9, 1000, 10);
        Item latte = new Item("Latte", 10, 1000, 10);
        myItems.add(sprite);
        myItems.add(mintSprite);
        myItems.add(coke);
        myItems.add(mindCoke);
        myItems.add(water);
        myItems.add(sparkling);
        myItems.add(coffee);
        myItems.add(mintCoffee);
        myItems.add(milkCoffee);
        myItems.add(latte);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        assertEquals(10, sprite.getItemAmount());
        mainDVM.giveItem(sprite,false);
        assertEquals(9, sprite.getItemAmount());
        mainDVM.giveItem(sprite,true);
        assertEquals(8, sprite.getItemAmount());
    }

    @Test
    void giveItem2() { // 0이하로 떨어지지 않는지 확인
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        Item mintSprite = new Item("Mint Sprite", 2, 1000, 10);
        Item coke = new Item("Coke", 3, 1000, 0);
        Item mindCoke = new Item("Mint Coke", 4, 1000, 10);
        Item water = new Item("Water", 5, 1000, 10);
        Item sparkling = new Item("Sparkling", 6, 1000, 0);
        Item coffee = new Item("Coffee", 7, 1000, 10);
        Item mintCoffee = new Item("Mint Coffee", 8, 1000, 10);
        Item milkCoffee = new Item("Milk Coffee", 9, 1000, 10);
        Item latte = new Item("Latte", 10, 1000, 10);
        myItems.add(sprite);
        myItems.add(mintSprite);
        myItems.add(coke);
        myItems.add(mindCoke);
        myItems.add(water);
        myItems.add(sparkling);
        myItems.add(coffee);
        myItems.add(mintCoffee);
        myItems.add(milkCoffee);
        myItems.add(latte);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        for (int i=0; i<100; i++) {
            mainDVM.giveItem(sprite, false);
        }
        assertEquals(0, sprite.getItemAmount());
    }

    //============================================================

    @Test
    void giveCode() { // 코드 생성확인 + 다른 상품에 대한 코드가 다르게 도출되는지 확인
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        Item mintSprite = new Item("Mint Sprite", 2, 1000, 10);
        Item coke = new Item("Coke", 3, 1000, 0);
        Item mindCoke = new Item("Mint Coke", 4, 1000, 10);
        Item water = new Item("Water", 5, 1000, 10);
        Item sparkling = new Item("Sparkling", 6, 1000, 0);
        Item coffee = new Item("Coffee", 7, 1000, 10);
        Item mintCoffee = new Item("Mint Coffee", 8, 1000, 10);
        Item milkCoffee = new Item("Milk Coffee", 9, 1000, 10);
        Item latte = new Item("Latte", 10, 1000, 10);
        myItems.add(sprite);
        myItems.add(mintSprite);
        myItems.add(coke);
        myItems.add(mindCoke);
        myItems.add(water);
        myItems.add(sparkling);
        myItems.add(coffee);
        myItems.add(mintCoffee);
        myItems.add(milkCoffee);
        myItems.add(latte);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String code = mainDVM.giveCode(sprite,false);
        boolean validity = mainDVM.codeValidation(code);
        assertTrue(validity);

        String code2 = mainDVM.giveCode(mintSprite,false);
        boolean validity2 = mainDVM.codeValidation(code);
        assertTrue(validity2);

        assertFalse(code==code2);
    }

    @Test
    void giveCode2() { // 코드 생성확인 + 같은 상품에 대한 코드도 다르게 도출되는지 확인
        ArrayList<Item> myItems = new ArrayList<>();
        Item sprite = new Item("Sprite", 1, 1000, 10);
        Item mintSprite = new Item("Mint Sprite", 2, 1000, 10);
        Item coke = new Item("Coke", 3, 1000, 0);
        Item mindCoke = new Item("Mint Coke", 4, 1000, 10);
        Item water = new Item("Water", 5, 1000, 10);
        Item sparkling = new Item("Sparkling", 6, 1000, 0);
        Item coffee = new Item("Coffee", 7, 1000, 10);
        Item mintCoffee = new Item("Mint Coffee", 8, 1000, 10);
        Item milkCoffee = new Item("Milk Coffee", 9, 1000, 10);
        Item latte = new Item("Latte", 10, 1000, 10);
        myItems.add(sprite);
        myItems.add(mintSprite);
        myItems.add(coke);
        myItems.add(mindCoke);
        myItems.add(water);
        myItems.add(sparkling);
        myItems.add(coffee);
        myItems.add(mintCoffee);
        myItems.add(milkCoffee);
        myItems.add(latte);

        Payment mainDVMPayment = new Payment();
        DVM mainDVM = new DVM("Main DVM",10,3, 500, "admin", "1234", myItems,0, mainDVMPayment);

        String code = mainDVM.giveCode(sprite,false);
        boolean validity = mainDVM.codeValidation(code);
        assertTrue(validity);

        String code2 = mainDVM.giveCode(sprite,false);
        boolean validity2 = mainDVM.codeValidation(code2);
        assertTrue(validity2);
        
        assertFalse(code==code2);
    }
}