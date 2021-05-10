import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class ManageAmountGUI extends JFrame {

    DVM DVM;

    JTextField ItemName = new JTextField(6);
    JTextField Amount = new JTextField(3);
    JButton button1 = new JButton("Confirm");

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

        Container ct = getContentPane();
        ct.setLayout(new FlowLayout());

        ct.add(ItemName);
        ct.add(Amount);
        ct.add(button1);

        setSize(500,200);
        InitListener();
        setVisible(true);
    }

    void InitListener(){
        button1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(DVM.manageAmount(ItemName.getText(), Integer.parseInt(Amount.getText()))){
                    //Amount가 양수고 성공적으로 재고를 변경했을경우
                    JOptionPane.showMessageDialog(null, "Manage Successful");
                    AdminMenuGUI AM = new AdminMenuGUI(DVM, getLocation().x, getLocation().y);
                    //MainFrame mf = new MainFrame(DVM);
                    dispose();
                }
                else
                    JOptionPane.showMessageDialog(null, "Incorrect Item Name or\nInvalid Amount");
            }
        });
    }


}