import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class UseCouponGUI extends JFrame {
    DVM DVM;
    String Selected_Item;
    JTextField text = new JTextField(4);
    JButton button1 = new JButton("ok");
    JButton button2 = new JButton("Cancel");
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
                    JOptionPane.showMessageDialog(ct, String.format("success : %s", findItem.getItemName()));
                } else if (result == 0) {
                    // 재고없음
                    JOptionPane.showMessageDialog(ct, "fail : amount is zero");
                } else if (result == -1) {
                    // 안맞으면
                    JOptionPane.showMessageDialog(ct, "fail : invalid code");
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