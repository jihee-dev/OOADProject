import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenuGUI extends JFrame {

    DVM DVM;

    JButton button1 = new JButton("Amount");
    JButton button2 = new JButton("Cash");
    JButton button3 = new JButton("Cancel");

    AdminMenuGUI(DVM dvm, int x, int y){
        //최상단 UI
        //초기화
        this.DVM = dvm;
        setTitle(String.format("%s - AdminMenu", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x, y);

        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());
        ct.add(button1);
        ct.add(button2);
        ct.add(button3);

        //제품 활성화 , 쿠폰사용 , 관리자로그인

        setSize(500,200);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageAmountGUI MAGUI = new ManageAmountGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ManageCashGUI MCGUI = new ManageCashGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });button3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI MCGUI = new MainGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });
    }


}