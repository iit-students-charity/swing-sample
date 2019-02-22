package src;

import javax.swing.JPanel;
import javax.swing.JOptionPane;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class PanelBase {
    protected JPanel panel;

    public PanelBase() {
        panel = new JPanel(new GridBagLayout());
    }

    public JPanel getPanel() {
        return panel;
    }

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
