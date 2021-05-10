import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ManageCashGUI extends JFrame {

    DVM DVM;

    JButton button1 = new JButton("Confirm");
    JTextField Cash = new JTextField(6);
    JLabel AmountCash;

    ManageCashGUI(DVM dvm, int x, int y){
        //최상단 UI
        //초기화
        this.DVM = dvm;
        setTitle(String.format("%s - Manage Cash", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        AmountCash=new JLabel(Integer.toString(DVM.totalCash));

        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());

        ct.add(AmountCash);
        ct.add(Cash);
        ct.add(button1);

        //Cash에 숫자만 입력되도록
        Cash.addKeyListener(new java.awt.event.KeyAdapter(){
            public void keyTyped(KeyEvent evt){
                if(!Character.isDigit(evt.getKeyChar())){
                    evt.consume();
                }
            }
        });

        //제품 활성화 , 쿠폰사용 , 관리자로그인

        setSize(500,200);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DVM.manageAmountCash(Integer.parseInt(Cash.getText()))){
                    JOptionPane.showMessageDialog(null, "Manage Successful");
                    AdminMenuGUI mf = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "invalid input value");
            }
        });
    }


}