package src;

import javax.swing.*;
import java.awt.Container;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainFrame extends JFrame {
    JButton inputButton = new JButton("Send");
    JTextArea editTextArea = new JTextArea("Type Here!");

    public MainFrame(String title) {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // setLayout(new BorderLayout());

        Container contentPane = getContentPane();

        contentPane.add(editTextArea, BorderLayout.NORTH);
        contentPane.add(inputButton, BorderLayout.SOUTH);

        inputButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String myString = editTextArea.getText();

                // MA - Don't use a space when you actually want an empty string.
                // As it stands, your code will test for a single space character.
                // You really want it to test whether the text area is empty.

                //editTextArea.setText(" ");

                // MA - Do this instead.  An empty string means the text area has
                // no input at all.

                editTextArea.setText("");

                System.out.println(myString);
            }
        });
    }

    public void showGUI() {
        setBounds(700, 200, 500, 500);
        setVisible(true);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainFrame = new MainFrame("lab 1");
                mainFrame.showGUI();
            }
        });
    }
}
