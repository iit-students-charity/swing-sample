package src;

import javax.swing.JOptionPane;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelBase {
    public void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }

    public GridBagConstraints getDefaultConstraits() {
        GridBagConstraints constraints = new GridBagConstraints();
        constraints.anchor = GridBagConstraints.WEST;
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.gridx = 0;
        constraints.gridy = 0;
        return constraints;
    }
}
