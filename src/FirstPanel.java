package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel {
    private JPanel panel = new JPanel(new GridBagLayout());
    private JTextField textField = new JTextField(20);
    private JButton button = new JButton("Send");
    private JComboBox comboBox = new JComboBox();

    public JPanel getPanel() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;

        panel.add(textField, constraints);

        constraints.gridx++;

        panel.add(button, constraints);

        constraints.gridx--;
        constraints.gridy++;
        comboBox.setPreferredSize(new Dimension(245, 20));
        panel.add(comboBox, constraints);

        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String item = textField.getText();
                comboBox.addItem(item);
                textField.setText("");
            }
        });

        return panel;
    }
}
