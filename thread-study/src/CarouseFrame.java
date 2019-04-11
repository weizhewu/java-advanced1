import javax.swing.*;

public class CarouseFrame extends JFrame {
    private JLabel bgLabel;
    public CarouseFrame(){
        init();
        setTitle("轮播窗体");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    private void init(){
        bgLabel = new JLabel();
        add(bgLabel);
        CarouseThread ct = new CarouseThread();
        ct.setBgLabel(bgLabel);
        new Thread(ct).start();
    }

    public static void main(String[] args) {
        new CarouseFrame();
    }
}
