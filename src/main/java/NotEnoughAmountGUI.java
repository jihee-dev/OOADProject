import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class NotEnoughAmountGUI extends JFrame {
    DVM DVM;
    Item selectedItem;
    JPanel panel = new JPanel();
    JButton getLocationButton = new JButton("해당 제품이 존재하는 다른 DVM 확인");
    JButton getCouponButton = new JButton("쿠폰으로 구매");
    JButton cancelButton = new JButton("취소");
    Container ct = getContentPane();

    NotEnoughAmountGUI(DVM dvm,Item selectedItem, int x, int y){
        //최상단 UI
        //초기화
        this.DVM = dvm;
        this.selectedItem = selectedItem;
        setTitle("NotEnoughGUI");
        setTitle(String.format("%s - Sold out", DVM.getRegion()));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(x,y);

        ct.setLayout(new FlowLayout());
        setSize(500,100);
        InitComponent();
        InitListener();
        InitPanels();
        setVisible(true);
    }

    void InitPanels(){
        this.add(panel);
    }

    void InitComponent(){
        panel.add(getLocationButton);
        panel.add(getCouponButton);
        panel.add(cancelButton);
    }

    void InitListener(){
        getLocationButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               ArrayList<DVM> DVMList = DVM.getNoneItemLocation(selectedItem.getItemName());
               String distanceWithName = "";
               for (int i=0; i<DVMList.size(); i++) {
                   distanceWithName += DVMList.get(i).getRegion();
                   distanceWithName += " / " + DVMList.get(i).getItemFromName(selectedItem.getItemName()).getItemAmount();
                   distanceWithName += " / " + DVMList.get(i).getDist() + "\n";
               }
               if (distanceWithName.equals("")) {
                   JOptionPane.showMessageDialog(ct, "근처에 구입가능한 자판기가 없습니다.");
               } else {
                   JOptionPane.showMessageDialog(ct, String.format("[%s 구입가능한 자판기]\n(지점명 / 재고수량 / 거리)\n%s", selectedItem.getItemName(), distanceWithName));
               }
            }
        });
        getCouponButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SelectPaymentGUI selectPaymentGUI = new SelectPaymentGUI(DVM, selectedItem, getLocation().x, getLocation().y);
                dispose();
            }
        });
        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ItemListGUI itemFrame = new ItemListGUI(DVM, getLocation().x, getLocation().y);
                dispose();
            }
        });
    }

}
