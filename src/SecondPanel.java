package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SecondPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JButton swapButton;

    public SecondPanel() {
        panel = new JPanel(new CircleLayout());
        textField = new JTextField(20);
        button = new JButton("Take text");
        swapButton = new JButton("Swap");

        panel.add(textField);
        button.addActionListener(addButtonListener());
        panel.add(button);
        swapButton.addActionListener(addSwapButtonListener());
        panel.add(swapButton);
    }

    public JPanel getPanel() {
        return panel;
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
