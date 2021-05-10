import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ItemListGUI extends JFrame {

    DVM DVM;

    JButton button1;
    Container ct = getContentPane();
    JButton cancelButton = new JButton("취소");
    JLabel emptyLabel = new JLabel("");

    ItemListGUI(DVM dvm, int x, int y){
        //초기화
        this.DVM = dvm;
        setTitle(String.format("%s - Item List", DVM.getRegion()));
        setSize(500,500);
        setVisible(true);
        setLocation(x,y);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ct.setLayout(new GridLayout(11,2,5,5));
        initButtons();
    }

    void initButtons() {
        // 현 DVM의 itemList를 기반으로 버튼들을 만들어주는 함수
        ArrayList<Item> itemList = this.DVM.getItemList();
        for (int i=0; i<itemList.size(); i++) {
            // itemList를 돌며 하나씩 버튼과 설명을 추가
            JButton button = new JButton(itemList.get(i).getItemName());
            JLabel label = new JLabel(String.format("      가격:%d    남은재고량:%d", itemList.get(i).getItemPrice(), itemList.get(i).getItemAmount()));
            button.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    String item_name = button.getText();
                    Item findItem = DVM.getItemFromName(item_name);
                    // 버튼에 적힌 이름을 기반으로 아이템객체 불러옴
                    int stock = findItem.getItemAmount();
                    // 해당 객체로부터 stock(재고,amount) 획득

                    if(stock>0){
                        SelectPaymentGUI selectPaymentGUI = new SelectPaymentGUI(DVM,findItem, getLocation().x, getLocation().y);
                    } else {
                        JOptionPane.showMessageDialog(ct, "재고가 없는 상품을 선택하여 쿠폰 구입만 가능합니다.");
                        NotEnoughAmountGUI notEnoughAmountGUI = new NotEnoughAmountGUI(DVM,findItem, getLocation().x, getLocation().y);
                    }
                    dispose();
                }
            });
            ct.add(button);
            ct.add(label);
        }
        ct.add(emptyLabel);
        ct.add(cancelButton);
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainGUI mainGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
            }
        });
    }
}
