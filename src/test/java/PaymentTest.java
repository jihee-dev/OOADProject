import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PaymentTest {


    @Test
    //정상경우
    void calculatePriceCash() {
        Payment myPayment  = new Payment();
        int inputCash = 2000; Item selectedItem = new Item("Coke", 1234, 1200, 3);
        int result = myPayment.calculatePriceCash(inputCash, selectedItem);
        assertEquals(800, result);
    }@Test
    //입금이 부족한 경우
    void calculatePriceCash2() {
        Payment myPayment  = new Payment();
        int inputCash = 1000; Item selectedItem = new Item("Coke", 1234, 1200, 3);
        int result = myPayment.calculatePriceCash(inputCash, selectedItem);
        assertTrue(result == -1);
    }@Test
    //itemPrice 가 음수일 경우
    void calculatePriceCash3() {
        Payment myPayment  = new Payment();
        int inputCash = 0; Item selectedItem = new Item("Coke", 1234, -1200, 3);
        int result = myPayment.calculatePriceCash(inputCash, selectedItem);
        assertTrue(result == -2);
    }

    //============================================================

    @Test
    //정상경우
    void isSufficient() {
        Payment myPayment  = new Payment();
        int limit = 2000; int itemPrice = 1200;
        boolean result = myPayment.isSufficient(limit, itemPrice);
        assertTrue(result);
    }@Test
    //입금이 부족한 경우
    void isSufficient2() {
        Payment myPayment  = new Payment();
        int limit = 2000; int itemPrice = 2200;
        boolean result = myPayment.isSufficient(limit, itemPrice);
        assertTrue(!result);
    }

    //============================================================

    @Test
    //정상경우
    void calculateChange() {
        Payment myPayment  = new Payment();
        int inputCash = 2000; int itemPrice = 1200;
        int result = myPayment.calculateChange(inputCash, itemPrice);
        assertEquals(800,result);
    }

    //============================================================

    @Test
    //정상 캐이스
    void calculatePriceCard() {
        Payment myPayment  = new Payment();
        String inputCardNumber = "1234"; Item selectedItem = new Item("Coke", 1234, 1200, 3);
        int result = myPayment.calculatePriceCard(inputCardNumber, selectedItem);
        assertEquals(1,result);
    }
    @Test
    //불량카드
    void calculatePriceCard2() {
        Payment myPayment  = new Payment();
        String inputCardNumber = "0000"; Item selectedItem = new Item("Coke", 1234, 1200, 3);
        int result = myPayment.calculatePriceCard(inputCardNumber, selectedItem);
        assertEquals(-1,result);
    }
    @Test
    //잔액부족
    void calculatePriceCard3() {
        Payment myPayment  = new Payment();
        String inputCardNumber = "3572"; Item selectedItem = new Item("Coke", 1234, 1200, 3);
        int result = myPayment.calculatePriceCard(inputCardNumber, selectedItem);
        assertEquals(0,result);
    }
    @Test
    //아이템가격 음수
    void calculatePriceCard4() {
        Payment myPayment  = new Payment();
        String inputCardNumber = "3572"; Item selectedItem = new Item("Coke", 1234, -1200, 3);
        int result = myPayment.calculatePriceCard(inputCardNumber, selectedItem);
        assertEquals(-2,result);
    }

    //============================================================

    @Test
    //정상경우
    void consumeCard() {
        Payment myPayment  = new Payment();
        String cardNumber = "0088"; int itemPrice = 1200;
        myPayment.consumeCard(cardNumber, itemPrice);
        int remain = Payment.validCardList.get("0088");
        assertEquals(2800,remain);
    }

    //============================================================

    @Test
    //정상경우
    void isValidCard() {
        Payment myPayment  = new Payment();
        String cardNumber = "1234";
        boolean result = myPayment.isValidCard("1234");
        assertTrue(result);
    }
    @Test
    //유효아지 않은 카드인 경우
    void isValidCard2() {
        Payment myPayment  = new Payment();
        String cardNumber = "0000";
        boolean result = myPayment.isValidCard("0000");
        assertTrue(!result);
    }
}