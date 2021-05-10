import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCouponGUI extends JFrame {
    DVM DVM;
    String Selected_Item;
    JTextField text = new JTextField(6);
    JButton button1 = new JButton("입력한 번호로 쿠폰번호 입력");
    JButton button2 = new JButton("취소");
    Container ct = getContentPane();

    UseCouponGUI(DVM dvm, int x, int y){
        //초기화
        this.Selected_Item = Selected_Item;
        this.DVM = dvm;
        setTitle(String.format("%s - Use coupon", DVM.getRegion()));
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
                int result = DVM.inputCode(text.getText());
                if(result == 1) {
                    // 코드 맞으면
                    Item findItem = DVM.getItemFromCode(text.getText());
                    DVM.giveItem(findItem);
                    DVM.removeCode(text.getText());
                    JOptionPane.showMessageDialog(ct, String.format("쿠폰으로 구매 성공! : %s", findItem.getItemName()));
                } else if (result == 0) {
                    // 재고없음
                    JOptionPane.showMessageDialog(ct, "쿠폰으로 구매 실패 : 현재 자판기에 재고가 없습니다.");
                } else if (result == -1) {
                    // 안맞으면
                    JOptionPane.showMessageDialog(ct, "쿠폰으로 구매 실패 : 잘못된 쿠폰번호입니다.");
                }
            }
        });

        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI fr = new MainGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });

    }
}