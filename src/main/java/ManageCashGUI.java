import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ManageCashGUI extends JFrame {

    DVM DVM;

    JButton button1 = new JButton("적용");
    JButton cancelButton = new JButton("취소");
    JTextField Cash = new JTextField(6);
    JLabel AmountCash;
    Container ct = getContentPane();

    ManageCashGUI(DVM dvm, int x, int y){
        //최상단 UI
        //초기화
        this.DVM = dvm;
        setTitle(String.format("%s - Manage Cash", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        AmountCash=new JLabel(Integer.toString(DVM.totalCash));

        ct.setLayout(new FlowLayout());

        ct.add(AmountCash);
        ct.add(Cash);
        ct.add(button1);
        ct.add(cancelButton);

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
                try {
                    if(DVM.manageAmountCash(Integer.parseInt(Cash.getText()))){
                        JOptionPane.showMessageDialog(null, "보유현금 변경이 정상적으로 처리되었습니다.");
                        AdminMenuGUI mf = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "입력한 현금 값이 올바르지 않습니다.");
                } catch (NumberFormatException error) {
                    JOptionPane.showMessageDialog(ct, String.format("에러 : %s", "잘못된 입력값입니다."));
                }
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                AdminMenuGUI mf = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
            }
        });
    }


}