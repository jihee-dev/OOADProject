import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ManageAmountGUI extends JFrame {

    DVM DVM;

    JLabel Introduction = new JLabel("제품 이름 / 수량");
    JTextField ItemName = new JTextField(6);
    JTextField Amount = new JTextField(3);
    JButton button1 = new JButton("적용");
    JButton cancelButton = new JButton("취소");
    Container ct = getContentPane();

    ManageAmountGUI(DVM dvm, int x, int y){
        this.DVM = dvm;
        setTitle(String.format("%s - Manage Amount", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);
        Amount.addKeyListener(new java.awt.event.KeyAdapter(){
            /*public void keyReleased(java.awt.event.KeyEvent evt){
                try{
                    long number = Long.parseLong(Amount.getText());
                }catch(Exception e){
                    JOptionPane.showMessageDialog(rootPane,"Only Numbers Allowed");
                    Amount.setText("");
                }
            } */
            public void keyTyped(KeyEvent evt){
                if(!Character.isDigit(evt.getKeyChar())){
                    evt.consume();
                }
            }
        });

        ct.setLayout(new FlowLayout());
        ct.add(Introduction);
        ct.add(ItemName);
        ct.add(Amount);
        ct.add(button1);
        ct.add(cancelButton);

        setSize(500,200);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    if(DVM.manageAmount(ItemName.getText(), Integer.parseInt(Amount.getText()))){
                        //Amount가 양수고 성공적으로 재고를 변경했을경우
                        JOptionPane.showMessageDialog(null, "재고수량 변경이 성공적으로 처리되었습니다.");
                        AdminMenuGUI AM = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
                        //MainFrame mf = new MainFrame(DVM);
                        dispose();
                    }
                    else
                        JOptionPane.showMessageDialog(null, "입력한 상품 이름 혹은 입력한 재고 값이 올바르지 않습니다.");
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