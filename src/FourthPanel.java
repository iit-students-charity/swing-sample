package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JRadioButton;

import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Insets;

public class FourthPanel extends PanelBase {
    private JTextField textField;
    private JButton button;
    private JRadioButton fooRadioButton;
    private JRadioButton barRadioButton;
    private JRadioButton bazRadioButton;

    public FourthPanel() {
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
    }

    private ActionListener addListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String names = textField.getText();
                String[] namesArray = names.split("\\s+");
                JRadioButton[] radioButtons = {fooRadioButton, barRadioButton, bazRadioButton};
                for (String name : namesArray) {
                    boolean found = false;
                    for (JRadioButton radioButton : radioButtons) {
                        if (radioButton.getText().equals(name)) {
                            radioButton.setSelected(true);
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
}
