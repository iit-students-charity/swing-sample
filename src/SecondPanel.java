package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class SecondPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JButton swapButton;

    public SecondPanel() {
        panel = new JPanel(new GridBagLayout());
        textField = new JTextField(20);
        button = new JButton("Take text");
        swapButton = new JButton("Swap");

        GridBagConstraints constraints = getDefaultConstraits();
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, constraints);

        constraints.gridwidth = 1;
        constraints.gridy = 1;
        button.addActionListener(addButtonListener());
        panel.add(button, constraints);

        constraints.gridx = 1;
        swapButton.addActionListener(addSwapButtonListener());
        panel.add(swapButton, constraints);
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

    private ActionListener addButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.equals(swapButton.getText())) {
                    alert("This text is already on button!");
                    return;
                }
                swapButton.setText(text);
                textField.setText("");
            }
        };
    }

    private ActionListener addSwapButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String buttonText = button.getText();
                String swapButtonText = swapButton.getText();
                button.setText(swapButtonText);
                swapButton.setText(buttonText);
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
