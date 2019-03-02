package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import src.CircleLayout;
import src.Separator;
import src.FirstPanel;
import src.SecondPanel;
import src.ThirdPanel;
import src.FourthPanel;
import src.FifthPanel;

public class MainFrame {
    public void showGUI() {
        JFrame frame = new JFrame("Swing sample");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel contentPane = new JPanel();
        contentPane.setLayout(new CircleLayout(0.75));
        frame.setContentPane(contentPane);

        contentPane.add(new FirstPanel().getPanel());
        contentPane.add(new SecondPanel().getPanel());
        contentPane.add(new ThirdPanel().getPanel());
        contentPane.add(new FourthPanel().getPanel());
        contentPane.add(new FifthPanel().getPanel());

        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
