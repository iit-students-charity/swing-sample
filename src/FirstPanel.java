package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends PanelBase {
    private JTextField textField;
    private JButton button;
    private JComboBox comboBox;

    public FirstPanel() {
        textField = new JTextField(20);
        button = new JButton("Send");
        comboBox = new JComboBox();

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx = 1;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        comboBox.setPreferredSize(new Dimension(245, 20));
        panel.add(comboBox, constraints);
    }

    private ActionListener addListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String newItem = textField.getText();
                for (int i = 0; i < comboBox.getItemCount(); i++) {
                    String item = comboBox.getItemAt(i).toString();
                    if (item.equals(newItem)) {
                        alert("This item already exists!");
                        return;
                    }
                }
                comboBox.addItem(newItem);
                textField.setText("");
            }
        };
    }
}
