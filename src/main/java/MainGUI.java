import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    DVM DVM;
    Container ct = getContentPane();
    JButton button1 = new JButton("상품 구매");
    JButton button2 = new JButton("쿠폰 사용");
    JButton button3 = new JButton("관리자 로그인");

   MainGUI(DVM dvm, int x, int y){
       //최상단 UI
       //초기화
       this.DVM = dvm;
       setTitle(String.format("%s - Main menu", DVM.getRegion()));
       setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       setSize(500,200);
       ct.setLayout(new GridLayout(1,3,5,5));
       setLocation(x,y);
       InitComponent();
       InitListener();
       setVisible(true);
   }

   void InitComponent(){
       ct.add(button1);
       ct.add(button2);
       ct.add(button3);
   }

   void InitListener(){
       button1.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               ItemListGUI itemFrame = new ItemListGUI(DVM, getLocation().x, getLocation().y);
               dispose();
           }
       });
       button2.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               UseCouponGUI UCF = new UseCouponGUI(DVM, getLocation().x, getLocation().y);
               dispose();
           }
       });
       button3.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               LoginGUI loginGUI = new LoginGUI(DVM, getLocation().x, getLocation().y);
               dispose();
           }
       });
   }


}