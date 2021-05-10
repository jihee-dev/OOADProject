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
        this.region = region;
        this.location = new Pair(x,y);
        this.totalCash = totalCash;
        this.adminID = adminID;
        this.adminPW = adminPW;
        this.itemList = itemList;
        this.dist = dist;
        this.myPayment = myPayment;
        DVMList.add(this);
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

    Item getItemFromName(String itemName) {
        // string값을 기반으로 item을 가져옴
        Item findItem = new Item();
        for(Item it : this.itemList){
            if(it.getItemName() == itemName)
                findItem = it;
        }
        return findItem;
    }
    ArrayList<DVM> getAnotherDVMInfo(String ItemName) {
        ArrayList<DVM> anotherDVMs = new ArrayList<>();

        for(DVM dvm : DVMList){
            ArrayList<Item> temp = dvm.getItemList();
            for(int i = 0;i<temp.size();i++){
                if(temp.get(i).getItemName() == ItemName && temp.get(i).getItemAmount() > 0){
                    anotherDVMs.add(dvm);
                    break;
                }
            }
        }
        return anotherDVMs;
    }

    void removeCode(String code) {
        codeTable.remove(code);
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

    //true이면 카드 false 현금
    boolean SelectPaymentMethod(boolean flag){
        return true;
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
            if(itemList.get(i).getItemName() == itemName){
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
                if(itemList.get(i).changeAmount(ItemName, newAmount)){
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

    void giveItem(Item selectedItem) {
        for (Item item: itemList) {
            if (item.getItemName() == selectedItem.getItemName()) {
                item.reduceAmount();
            }
        }
    }

    String giveCode(Item selectedItem) {
        Random random = new Random(); //랜덤 객체 생성(디폴트 시드값 : 현재시간)
        random.setSeed(System.currentTimeMillis()); //시드값 설정을 따로 할수도 있음
        int randomResult = random.nextInt(8999);
        randomResult += 1000;
        String code = Integer.toString(randomResult);
        while (codeTable.keySet().contains(code)) {
            randomResult = random.nextInt(8999);
            randomResult += 1000;
            code = Integer.toString(randomResult);
        }
        codeTable.put(code, selectedItem.getItemName());
        return code;
    }
}