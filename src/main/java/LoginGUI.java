import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginGUI extends JFrame {

    DVM DVM;

    JButton button1 = new JButton("Login");
    JTextField id = new JTextField(6);
    JTextField pw = new JTextField(6);
    JButton button2 = new JButton("Cancel");

    LoginGUI(DVM dvm, int x, int y){
        //최상단 UI
        //초기화
        this.DVM = dvm;
        setTitle(String.format("%s - Login", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());


        ct.add(id);
        ct.add(pw);
        ct.add(button1);
        ct.add(button2);

        //제품 활성화 , 쿠폰사용 , 관리자로그인

        setSize(500,200);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DVM.login(id.getText(), pw.getText())) {
                    AdminMenuGUI adMenu = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Incorrect ID or Password");
            }
        });
        button2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MainGUI mf = new MainGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });
    }


}