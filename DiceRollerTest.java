import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.security.SecureRandom;

/**
 * @author: Amir Kobaisse
 * Course: CST8284
 * Term: Spring2024
 * Assignment: Assignment 3
 * Date: Date of the final version of this source code
 * Purpose: Represents a location identified by its postal code prefix and includes a method to calculate distance between 2 locations.
 */

public class DiceRollerTest extends JFrame {
    // GUI components
    private JTextField sidesInput;
    private JTextField resultField;
    private JButton rollButton;

    public DiceRollerTest() {
        // Set up the JFrame
        setTitle("Dice");
        setLayout(new GridBagLayout());
        GridBagConstraints x = new GridBagConstraints();

        // Label and input field for number of sides
        addComponent(new JLabel("# of sides:"), x, 0, 0, GridBagConstraints.EAST, new Insets(10, 10, 10, 10));
        sidesInput = new JTextField(10);
        sidesInput.setFont(new Font("Tahoma", Font.PLAIN, 24));
        addComponent(sidesInput, x, 1, 0, GridBagConstraints.WEST, new Insets(10, 10, 10, 10));

        // Label and output field for the rolled result
        addComponent(new JLabel("Rolled:"), x, 0, 1, GridBagConstraints.EAST, new Insets(10, 10, 10, 10));
        resultField = new JTextField(10);
        resultField.setFont(new Font("Tahoma", Font.PLAIN, 24));
        resultField.setEditable(false);
        addComponent(resultField, x, 1, 1, GridBagConstraints.WEST, new Insets(10, 10, 10, 10));

        // Roll button
        rollButton = new JButton("Roll the die");
        rollButton.setFont(new Font("Tahoma", Font.PLAIN, 24));
        x.gridwidth = 2;
        x.anchor = GridBagConstraints.CENTER;
        x.insets = new Insets(10, 10, 10, 10);
        addComponent(rollButton, x, 0, 2, GridBagConstraints.CENTER, new Insets(10, 10, 10, 10));

        // Add action listener to the roll button
        rollButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                rollDie();
            }
        });

        // Final JFrame settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pack();
        setLocationRelativeTo(null); // Center the window
        setVisible(true);
    }

    // Method to add components to the frame
    private void addComponent(Component component, GridBagConstraints x, int xPos, int yPos, int anchor, Insets insets) {
        x.gridx = xPos;
        x.gridy = yPos;
        x.anchor = anchor;
        x.insets = insets;
        add(component, x);
    }

    // Method to handle the die rolling logic
    private void rollDie() {
        try {
            int sides = Integer.parseInt(sidesInput.getText());
            if (sides <= 0) {
                showError("Number of sides must be greater than zero.");
                return;
            }
            SecureRandom random = new SecureRandom();
            int result = random.nextInt(sides) + 1; // Generate random number between 1 and sides
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException e) {
            showError("Please enter a valid number."); // Show error if input is not a valid number
        }
    }

    // Method to show error messages
    private void showError(String message) {
        JOptionPane.showMessageDialog(this, message, "Error", JOptionPane.ERROR_MESSAGE);
    }

    // Main method to run the application
    public static void main(String[] args) {
        new DiceRollerTest();
    }
}
