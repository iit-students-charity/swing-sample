package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FirstPanel extends PanelBase {
    private JPanel panel = new JPanel(new GridBagLayout());
    private JTextField textField = new JTextField(20);
    private JButton button = new JButton("Send");
    private JComboBox comboBox = new JComboBox();

    public JPanel getPanel() {
        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx++;
        button.addActionListener(getListener());
        panel.add(button, constraints);

        constraints.gridx--;
        constraints.gridy++;
        comboBox.setPreferredSize(new Dimension(245, 20));
        panel.add(comboBox, constraints);

        return panel;
    }

    private ActionListener getListener() {
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
