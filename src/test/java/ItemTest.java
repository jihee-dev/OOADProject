import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;

import static org.junit.jupiter.api.Assertions.*;

class ItemTest {

    @Test
    void changeAmount() { // 양수입력
        Item testItem = new Item("Test",1,1000,10);
        testItem.changeAmount(5);
        assertEquals(5, testItem.getItemAmount());
    }

    @Test
    void changeAmount2() { // 음수로 입력할 경우
        Item testItem = new Item("Test",1,1000,10);
        testItem.changeAmount(-1);
        assertEquals(10, testItem.getItemAmount());
    }

    //============================================================

    @Test
    void reduceAmount() { // 줄어드는지 테스트
        Item testItem = new Item("Test",1,1000,10);
        testItem.reduceAmount();
        assertEquals(9, testItem.getItemAmount());
    }

    @Test
    void reduceAmount2() { // 여러번했을때 0이하로 안떨어지는지 테스트
        Item testItem = new Item("Test",1,1000,10);
        for (int i=0; i<100; i++) {
            testItem.reduceAmount();
        }
        assertEquals(0, testItem.getItemAmount());
    }
}