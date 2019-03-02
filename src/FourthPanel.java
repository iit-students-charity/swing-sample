package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class FourthPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JCheckBox fooCheckBox;
    private JCheckBox barCheckBox;
    private JCheckBox bazCheckBox;

    public FourthPanel() {
        panel = new JPanel(new GridBagLayout());
        textField = new JTextField(20);
        button = new JButton("Activate");
        fooCheckBox = new JCheckBox("foo");
        barCheckBox = new JCheckBox("bar");
        bazCheckBox = new JCheckBox("baz");

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx = 1;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(fooCheckBox, constraints);
        constraints.gridy = 2;
        panel.add(barCheckBox, constraints);
        constraints.gridy = 3;
        panel.add(bazCheckBox, constraints);
    }

    public JPanel getPanel() {
        return panel;
    }

    private GridBagConstraints getDefaultConstraits() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.NORTH;
        constraints.insets = new Insets(5, 5, 5, 5);
        constraints.gridx = 0;
        constraints.gridy = 0;
        return constraints;
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
