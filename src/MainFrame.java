package src;

import javax.swing.JFrame;
import java.awt.Container;
import src.FirstPanel;
// import src.SecondPanel;
// import src.ThirdPanel;
// import src.FourthPanel;
// import src.FifthPanel;

public class MainFrame {
    public void showGUI() {
        JFrame frame = new JFrame("Swing components example");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container contentPane = frame.getContentPane();
        contentPane.add(new FirstPanel().getPanel());
        // contentPane.add(new SecondPanel().getPanel());
        // contentPane.add(new ThirdPanel().getPanel());
        // contentPane.add(new FourthPanel().getPanel());
        // contentPane.add(new FifthPanel().getPanel());

        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        MainFrame mainFrame = new MainFrame();
        mainFrame.showGUI();
    }
}
