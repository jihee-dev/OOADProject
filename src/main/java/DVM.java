import java.util.*;

public class DVM {
    String region;
    Pair location;
    int totalCash;
    String adminID;
    String adminPW;
    ArrayList<Item> itemList;
    double dist;
    static HashMap<String,String> codeTable = new HashMap<>();
    static ArrayList<DVM> DVMList  = new ArrayList<>();
    Payment myPayment;

    public class Pair{
        int x;
        int y;
        Pair(int x , int y){
            this.x = x;
            this.y = y;
        }
        public int getX(){return this.x;}
        public int getY(){return this.y;}
    }

    public DVM(String region, int x, int y, int totalCash, String adminID, String adminPW, ArrayList<Item> itemList, double dist, Payment myPayment) {
        if (DVMList.size() == 10) {
            System.out.println("자판기는 최대 10개까지만 생성 가능합니다.");
            System.out.println("[" + region + "]자판기는 생성되지 않았습니다.");
        } else if (itemList.size() != 20) {
            System.out.println("아이템리스트는 반드시 20개의 아이템을 보유해야 합니다.");
            System.out.println("[" + region + "]자판기는 생성되지 않았습니다.");
        }  else {
            int availableItem = 0;
            for (int i=0; i<20; i++) {
                if (itemList.get(i).getItemAmount() > 0) {
                    availableItem += 1;
                }
            }
            if (availableItem != 7) {
                System.out.println("재고가 유효한 상품이 7개가 아닌 자판기는 생성할 수 없습니다.");
                System.out.println("[" + region + "]자판기는 생성되지 않았습니다.");                
            } else {
                this.region = region;
                this.location = new Pair(x,y);
                this.totalCash = totalCash;
                this.adminID = adminID;
                this.adminPW = adminPW;
                this.itemList = itemList;
                this.dist = dist;
                this.myPayment = myPayment;
                boolean duplicated = false;
                for(int i=0;i<DVMList.size();i++){
                    if(DVMList.get(i).location.x == x && DVMList.get(i).location.y ==y){
                        duplicated=true;
                    }
                }
                if(!duplicated){
                    DVMList.add(this);
                }

            }
        }
    }

    double getDist(){
        return this.dist;
    }
    void setDist(double dist){
        this.dist = dist;
    }

    public String getRegion() {
        return region;
    }

    public Pair getLocation() {
        return location;
    }

    public ArrayList<Item> getItemList() {
        return itemList;
    }

    public static HashMap<String, String> getCodeTable() {
        return codeTable;
    }

    Item getItemFromName(String itemName) {
        // string값을 기반으로 item을 가져옴
        Item findItem = new Item();
        for(Item it : this.itemList){
            if(it.getItemName().equals(itemName))
                findItem = it;
        }
        return findItem;
    }
    ArrayList<DVM> getAnotherDVMInfo(String ItemName) {
        ArrayList<DVM> anotherDVMs = new ArrayList<>();
        for(DVM dvm : DVMList){
            if(dvm == this) continue;
            ArrayList<Item> temp = dvm.getItemList();
            for(int i = 0;i<temp.size();i++){
                if(temp.get(i).getItemName().equals(ItemName) && temp.get(i).getItemAmount() > 0){
                    anotherDVMs.add(dvm);
                    break;
                }
            }
        }
        return anotherDVMs;
    }

    void removeCode(String code) {
        String ret = codeTable.get(code);
        if (ret!=null) codeTable.remove(code);
    }

    ArrayList<DVM> sortDVM(ArrayList<DVM> DVMList) {
        DVMList.sort(Comparator.comparing(DVM::getDist));
        return DVMList;
    }

    ArrayList<DVM> getNoneItemLocation(String ItemName){
       // abs(x1-x2) + abs(y1-y2);
        ArrayList<DVM> otherDVM = getAnotherDVMInfo(ItemName);

        int cur_x = this.location.x;
        int cur_y = this.location.y;

        for(int i=0;i<otherDVM.size();i++){
            int next_x = otherDVM.get(i).location.x;
            int next_y = otherDVM.get(i).location.y;
            otherDVM.get(i).setDist(Math.round(Math.sqrt(Math.pow(cur_x - next_x,2) + Math.pow(cur_y-next_y,2))*100)/100.0);
        }
        otherDVM = sortDVM(otherDVM);

        return otherDVM;
    }

    int inputCode(String code) {
        boolean codeValidity = codeValidation(code);
        if (codeValidity) {
            Item findItem = getItemFromCode(code);
            int itemAmount = findItem.getItemAmount();
            if (itemAmount > 0) {
                return 1;
            } else {
                return 0;
            }
        } else {
            return -1;
        }
    }
    // 코드 존재하는지 확인하는 함수
    boolean codeValidation(String code) {
        return codeTable.keySet().contains(code);
    }

    // 코드에 해당하는 아이템 리턴해주는 함수
    Item getItemFromCode(String code) {
        Item item = new Item();
        String itemName = codeTable.get(code);
        for(int i=0;i<itemList.size();i++){
            if(itemList.get(i).getItemName().equals(itemName)){
                item = itemList.get(i);
            }
        }
        return item;
    }

    //로그인
    boolean login(String id, String pw){
        if(this.adminID.equals(id) && this.adminPW.equals(pw))
            return true;
        else
            return false;
    }

    //재고관리
    boolean manageAmount(String ItemName, int newAmount){
        boolean flag = false;
        for(int i=0; i<itemList.size();i++){
            if(itemList.get(i).getItemName().equals(ItemName)){
                if(itemList.get(i).changeAmount(newAmount)){
                    flag=true;
                    break;
                }
                else
                    flag=false;
            }
        }
        return flag;
    }

    boolean manageAmountCash(int newAmountCash){
        if(newAmountCash>=0) {
            this.totalCash = newAmountCash;
            return true;
        }
        else
            return false;
    }

    // cash
    int inputCash(int inputCash, Item selectedItem) {
        int result = myPayment.calculatePriceCash(inputCash,selectedItem);
        if (checkTotalCash(result)) {
            result = -2;
        }
        return result;
    }
    boolean checkTotalCash(int change) {
        // totalCash보다 change가 크다면 true리턴
        return change > this.totalCash;
    }

    // card
    int insertCard(String cardNumber, Item selectedItem) {
        int result = myPayment.calculatePriceCard(cardNumber,selectedItem);
        return result;
    }

    void giveItem(Item selectedItem, Boolean payByCash) {
        if (selectedItem.getItemAmount() > 0) {
            for (Item item: itemList) {
                if (item.getItemName().equals(selectedItem.getItemName())) {
                    item.reduceAmount();
                    if (payByCash) totalCash += item.getItemPrice();
                }
            }
        }
    }

    String giveCode(Item selectedItem, Boolean payByCash) {
        char[] tmp;
        String code = "000000";
        while (code == "000000" || codeTable.keySet().contains(code)) {
            tmp = new char[6];
            for(int i=0; i<tmp.length; i++) {
                int div = (int) Math.floor( Math.random() * 2 );

                if(div == 0) { // 0이면 숫자로
                    tmp[i] = (char) (Math.random() * 10 + '0') ;
                }else { //1이면 알파벳
                    tmp[i] = (char) (Math.random() * 26 + 'A') ;
                }
            }
            code = new String(tmp);
        }
        codeTable.put(code, selectedItem.getItemName());
        if (payByCash) totalCash += selectedItem.getItemPrice();
        return code;
    }
}