package src;

import javax.swing.JFrame;
import java.awt.Container;
import src.PanelBase;
import src.FirstPanel;
import src.SecondPanel;
// import src.ThirdPanel;
// import src.FourthPanel;
// import src.FifthPanel;

public class MainFrame {
    public void showGUI() {
        JFrame frame = new JFrame("Swing sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.add(new FirstPanel().configurePanel().getPanel());
        // contentPane.add(new SecondPanel().configurePanel().getPanel());
        // contentPane.add(new ThirdPanel().configurePanel().getPanel());
        // contentPane.add(new FourthPanel().configurePanel().getPanel());
        // contentPane.add(new FifthPanel().configurePanel().getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame().showGUI();
    }
}
