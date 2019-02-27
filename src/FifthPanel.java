package src;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.GridBagLayout;
import java.awt.Insets;

public class FifthPanel {
    private JPanel panel;
    private JTextField textField;
    private JButton button;
    private JButton toRightButton;
    private JButton toLeftButton;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;

    public FifthPanel() {
        panel = new JPanel(new GridBagLayout());
        textField = new JTextField(20);
        button = new JButton("Add");
        toRightButton = new JButton(">");
        toLeftButton = new JButton("<");
        table = new JTable();
        scrollPane = new JScrollPane(table);
        model = getModel();

        GridBagConstraints constraints = getDefaultConstraits();
        constraints.gridwidth = 3;
        constraints.fill = GridBagConstraints.HORIZONTAL;
        panel.add(textField, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 4;
        button.addActionListener(addButtonListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        constraints.gridwidth = 5;
        constraints.anchor = GridBagConstraints.CENTER;
        String[] columnNames = { "Left", "Right" };
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        scrollPane.setPreferredSize(new Dimension(245, 200));
        panel.add(scrollPane, constraints);

        constraints.gridy = 2;
        constraints.gridx = 0;
        constraints.gridwidth = 2;
        constraints.fill = GridBagConstraints.VERTICAL;
        toRightButton.addActionListener(addToRightButtonListener());
        panel.add(toRightButton, constraints);

        constraints.gridx = 4;
        constraints.gridwidth = 2;
        toLeftButton.addActionListener(addToLeftButtonListener());
        panel.add(toLeftButton, constraints);
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

    private DefaultTableModel getModel() {
        return new DefaultTableModel() {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
    }

    private ActionListener addButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String text = textField.getText();
                if (text.trim().length() == 0) {
                    alert("Empty cells are not allowed!");
                    return;
                }
                String[] row = {text, ""};
                model.addRow(row);
                textField.setText("");
            }
        };
    }

    private ActionListener addToLeftButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                Object text = table.getValueAt(row, 1);
                if (!text.equals("")) {
                    model.setValueAt(text, row, 0);
                    model.setValueAt("", row, 1);
                }
            }
        };
    }

    private ActionListener addToRightButtonListener() {
        return new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int row = table.getSelectedRow();
                Object text = table.getValueAt(row, 0);
                if (!text.equals("")) {
                    model.setValueAt(text, row, 1);
                    model.setValueAt("", row, 0);
                }
            }
        };
    }

    private void alert(String message) {
        JOptionPane.showMessageDialog(null, message);
    }
}
