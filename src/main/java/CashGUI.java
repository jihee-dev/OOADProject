import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CashGUI extends JFrame {
    DVM DVM;
    Item selectedItem;
    JTextField text = new JTextField(4);
    JButton button1 = new JButton("ok");
    JButton button2 = new JButton("Cancel");
    Container ct = getContentPane();

    CashGUI(DVM dvm,Item Selected_Item, int x, int y){
        this.selectedItem = Selected_Item;
        this.DVM = dvm;
        setTitle(String.format("%s - Pay by cash", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);

        ct.setLayout(new FlowLayout());

        ct.add(text);
        ct.add(button1);
        ct.add(button2);
        setSize(500,100);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int result = DVM.inputCash(Integer.parseInt(text.getText()), selectedItem);

                if (result >= 0) {
                    // > 0 : 거스름돈 반출
                    JOptionPane.showMessageDialog(ct, String.format("success : %s", selectedItem.getItemName()));
                    JOptionPane.showMessageDialog(ct, String.format("거스름돈 : %s", result));
                    if (selectedItem.getItemAmount()>0) {
                        // 재고 하나줄임
                        DVM.giveItem(selectedItem);
                    } else {
                        // code 부여
                        String code = DVM.giveCode(selectedItem);
                        JOptionPane.showMessageDialog(ct, String.format("생성된 코드 : %s", code));
                    }
                    MainGUI mainGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
                    dispose();
                } else if (result == -2) {
                    // 0 : 모두 계산되었지만 거스름돈 부족
                    JOptionPane.showMessageDialog(ct, String.format("error : %s", "현재 기기에 거스름돈이 부족해 구입이 불가능합니다."));
                    MainGUI mainGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
                    dispose();
                } else if (result == -1) {
                    // -1 : 투입금액 부족
                    JOptionPane.showMessageDialog(ct, String.format("error : %s", "투입한 금액이 부족합니다."));
                }
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                MainGUI MAINGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
            }
        });

    }
}
