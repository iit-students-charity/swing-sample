package src;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.BoxLayout;

import src.PanelBase;
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
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.PAGE_AXIS));

        contentPane.add(new Separator("First").getSeparator());
        contentPane.add(new FirstPanel().getPanel());
        contentPane.add(new Separator("Second").getSeparator());
        contentPane.add(new SecondPanel().getPanel());
        contentPane.add(new Separator("Third").getSeparator());
        contentPane.add(new ThirdPanel().getPanel());
        contentPane.add(new Separator("Fourth").getSeparator());
        contentPane.add(new FourthPanel().getPanel());
        contentPane.add(new Separator("Fifth").getSeparator());
        contentPane.add(new FifthPanel().getPanel());

        frame.setContentPane(contentPane);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MainFrame().showGUI();
    }
}
