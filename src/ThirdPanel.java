package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class ThirdPanel extends PanelBase {
    private static final String[] RADIO_BUTTON_NAMES = new String[]{"foo", "bar", "baz");
    private JTextField textField;
    private JButton button;
    private JRadioButton fooRadioButton;
    private JRadioButton barRadioButton;
    private JRadioButton bazRadioButton;

    public ThirdPanel configurePanel() {
        textField = new JTextField(20);
        button = new JButton("Activate");
        fooRadioButton = new JRadioButton("foo");
        barRadioButton = new JRadioButton("bar");
        bazRadioButton = new JRadioButton("baz");

        GridBagConstraints constraints = getDefaultConstraits();
        panel.add(textField, constraints);

        constraints.gridx++;
        button.addActionListener(addListener());
        panel.add(button, constraints);

        constraints.insets = new Insets(2, 20, 2, 2);
        constraints.gridx--;
        constraints.gridy++;
        panel.add(fooRadioButton, constraints);
        constraints.gridy++;
        panel.add(barRadioButton, constraints);
        constraints.gridy++;
        panel.add(bazRadioButton, constraints);
        ButtonGroup group = new ButtonGroup();
        group.add(fooRadioButton);
        group.add(barRadioButton);
        group.add(bazRadioButton);

        return this;
    }

    private ActionListener addListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = textField.getText();
                if (name.equals(swapButton.getText())) {
                    alert("This name is already on button!");
                    return;
                }
                swapButton.setText(name);
                textField.setText("");
            }
        };
    }
}
