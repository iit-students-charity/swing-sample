package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class ThirdPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JRadioButton fooRadioButton;
    private JRadioButton barRadioButton;
    private JRadioButton bazRadioButton;

    public ThirdPanel() {
        panel = new JPanel(new GridBagLayout());
        textField = new JTextField(20);
        button = new JButton("Activate");
        fooRadioButton = new JRadioButton("foo");
        barRadioButton = new JRadioButton("bar");
        bazRadioButton = new JRadioButton("baz");

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx = 1;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(fooRadioButton, constraints);
        constraints.gridy = 2;
        panel.add(barRadioButton, constraints);
        constraints.gridy = 3;
        panel.add(bazRadioButton, constraints);
        ButtonGroup group = new ButtonGroup();
        group.add(fooRadioButton);
        group.add(barRadioButton);
        group.add(bazRadioButton);
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
                String name = textField.getText();
                JRadioButton[] radioButtons = {fooRadioButton, barRadioButton, bazRadioButton};
                for (JRadioButton radioButton : radioButtons) {
                    if (radioButton.getText().equals(name)) {
                        radioButton.setSelected(true);
                        return;
                    }
                }
                alert("There is no such radio button!");
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
