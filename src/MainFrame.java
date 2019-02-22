package src;

import javax.swing.JFrame;
import java.awt.Container;
import java.awt.BorderLayout;

import src.PanelBase;
import src.FirstPanel;
import src.SecondPanel;
import src.ThirdPanel;
// import src.FourthPanel;
// import src.FifthPanel;

public class MainFrame {
    public void showGUI() {
        JFrame frame = new JFrame("Swing sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        // contentPane.add(new FirstPanel().configurePanel().getPanel(), BorderLayout.NORTH);
        // contentPane.add(new SecondPanel().configurePanel().getPanel(), BorderLayout.PAGE_END);
        contentPane.add(new ThirdPanel().configurePanel().getPanel(), BorderLayout.PAGE_END);
        // contentPane.add(new FourthPanel().configurePanel().getPanel(), BorderLayout.PAGE_END);
        // contentPane.add(new FifthPanel().configurePanel().getPanel(), BorderLayout.PAGE_END);

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame().showGUI();
    }
}
