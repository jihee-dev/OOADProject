import java.util.*;

public class Payment {
    static HashMap<String, Integer> validCardList = new HashMap<>();

    public Payment() {
        if (validCardList.isEmpty()) {
            validCardList.put("1234", 999999);
            validCardList.put("5678", 200000);
            validCardList.put("4543", 999999);
            validCardList.put("3572", 1000);
            validCardList.put("1589", 999999);
            validCardList.put("3257", 200000);
            validCardList.put("1088", 999999);
            validCardList.put("0088", 4000);
        }
    }

    public int calculatePriceCash(int inputCash, Item selectedItem) {
        int itemPrice = selectedItem.getItemPrice();
        if(itemPrice>0) {
            boolean sufficient = isSufficient(inputCash, itemPrice);
            if (sufficient) {
                return calculateChange(inputCash, itemPrice);
            } else {
                return -1;
            }
        }
        else
            return -2;
    }

    public boolean isSufficient(int limit, int itemPrice) {
        if (limit >= itemPrice) {
            return true;
        } else {
            return false;
        }
    }

    public int calculateChange(int inputCash, int itemPrice) {
        return inputCash - itemPrice;
    }

    public int calculatePriceCard(String inputCardNumber, Item selectedItem) {
        int itemPrice = selectedItem.getItemPrice();
        if(itemPrice>0) {
            if (isValidCard(inputCardNumber)) {
                if (isSufficient(validCardList.get(inputCardNumber), itemPrice)) {
                    return 1;
                } else {
                    return 0;
                }
            } else {
                return -1;
            }
        }
        else{
            return -2;
        }
    }

    public void consumeCard(String cardNumber, int itemPrice) {
        int originRaminCash = validCardList.get(cardNumber);
        validCardList.remove(cardNumber);
        validCardList.put(cardNumber, originRaminCash-itemPrice);
    }

    public boolean isValidCard(String inputCardNumber) {
        return validCardList.keySet().contains(inputCardNumber);
    }

}
