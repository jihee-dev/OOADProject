import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardGUI extends JFrame {
    DVM DVM;
    Item selectedItem;
    JTextField cardNumberInput = new JTextField(4);
    JButton okButton = new JButton("입력한 번호로 카드 입력");
    JButton cancelButton = new JButton("취소");
    Container ct = getContentPane();

    CardGUI(DVM dvm,Item Selected_Item, int x, int y){
        this.selectedItem = Selected_Item;
        this.DVM = dvm;
        setTitle(String.format("%s - Pay by card", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);

        ct.setLayout(new FlowLayout());
        ct.add(cardNumberInput);
        ct.add(okButton);
        ct.add(cancelButton);
        setSize(500,100);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String cardNumber = cardNumberInput.getText();
                try {
                    int result = DVM.insertCard(cardNumber, selectedItem);

                    if (result == 1) {
                        // 1 : 결제성공
                        if (selectedItem.getItemAmount()>0) {
                            // 재고 하나줄임
                            DVM.giveItem(selectedItem); // 재고 하나줄임
                        } else {
                            // code 부여
                            String code = DVM.giveCode(selectedItem);
                            JOptionPane.showMessageDialog(ct, String.format("생성된 코드 : %s", code));
                        }
                        DVM.myPayment.consumeCard(cardNumber, selectedItem.getItemPrice());
                        JOptionPane.showMessageDialog(ct, String.format("구매 성공! : %s", selectedItem.getItemName()));
                        MainGUI mainGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
                        dispose();
                    } else if (result == 0) {
                        // 0 : 한도초과
                        JOptionPane.showMessageDialog(ct, String.format("구매 실패 : %s", "카드 한도 초과입니다."));
                        CardGUI cardGUI = new CardGUI(DVM, selectedItem, getLocation().x, getLocation().y);
                        dispose();
                    } else if (result == -1) {
                        // -1 : 존재하지 않는 카드
                        JOptionPane.showMessageDialog(ct, String.format("구매 실패 : %s", "정상적인 카드가 아닙니다."));
                        CardGUI cardGUI = new CardGUI(DVM, selectedItem, getLocation().x, getLocation().y);
                        dispose();
                    }
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(ct, String.format("에러 : %s", "잘못된 입력값입니다."));
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainGUI MAINGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
            }
        });

    }
}
