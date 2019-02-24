package src;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FifthPanel extends PanelBase {
    private JTextField textField;
    private JButton button;
    private JButton toRightButton;
    private JButton toLeftButton;
    private JTable table;
    private DefaultTableModel model;
    private JScrollPane scrollPane;

    public FifthPanel() {
        textField = new JTextField(20);
        button = new JButton("Add");
        toRightButton = new JButton(">");
        toLeftButton = new JButton("<");
        table = new JTable();
        scrollPane = new JScrollPane(table);
        model = getModel();

        GridBagConstraints constraints = getDefaultConstraits();
        constraints.gridwidth = 3;
        panel.add(textField, constraints);

        constraints.gridwidth = 1;
        constraints.gridx = 4;
        button.addActionListener(addButtonListener());
        panel.add(button, constraints);

        constraints.gridx = 0;
        constraints.gridy++;
        constraints.gridwidth = 4;
        // constraints.fill = GridBagConstraints.HORIZONTAL;
        String[] columnNames = { "Left", "Right" };
        model.setColumnIdentifiers(columnNames);
        table.setModel(model);
        scrollPane.setPreferredSize(new Dimension(245, 200));
        panel.add(scrollPane, constraints);

        constraints.gridy++;
        constraints.gridx = 0;
        toRightButton.addActionListener(addToRightButtonListener());
        panel.add(toRightButton, constraints);

        constraints.gridx = 2;
        toLeftButton.addActionListener(addToLeftButtonListener());
        panel.add(toLeftButton, constraints);
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
}
