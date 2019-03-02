package src;

import src.CircleLayout;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FourthPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JCheckBox fooCheckBox;
    private JCheckBox barCheckBox;
    private JCheckBox bazCheckBox;

    public FourthPanel() {
        panel = new JPanel(new CircleLayout());
        textField = new JTextField(20);
        button = new JButton("Activate");
        fooCheckBox = new JCheckBox("foo");
        barCheckBox = new JCheckBox("bar");
        bazCheckBox = new JCheckBox("baz");

        panel.add(textField);
        button.addActionListener(addListener());
        panel.add(button);
        panel.add(fooCheckBox);
        panel.add(barCheckBox);
        panel.add(bazCheckBox);
    }

    public JPanel getPanel() {
        return panel;
    }

    private ActionListener addListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String names = textField.getText();
                String[] namesArray = names.split("\\s+");
                JCheckBox[] checkBoxes = {fooCheckBox, barCheckBox, bazCheckBox};
                for (String name : namesArray) {
                    boolean found = false;
                    for (JCheckBox checkBox : checkBoxes) {
                        if (checkBox.getText().equals(name)) {
                            checkBox.setSelected(!checkBox.isSelected());
                            found = true;
                            break;
                        }
                    }
                    if(!found) {
                        alert("There is no button with name '" + name + "'!");
                        return;
                    }
                }
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
