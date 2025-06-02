import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleCalculator extends JFrame implements ActionListener {
    JTextField textField1, textField2, resultField;
    JButton addButton, subtractButton, multiplyButton, divideButton;

    public SimpleCalculator() {
        setTitle("Simple Calculator");
        setSize(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        add(new JLabel("First Number:"));
        textField1 = new JTextField();
        add(textField1);
        add(new JLabel("Second Number:"));
        textField2 = new JTextField();
        add(textField2);
        addButton = new JButton("+");
        subtractButton = new JButton("-");
        multiplyButton = new JButton("X");
        divideButton = new JButton("/");

        addButton.addActionListener(this);
        subtractButton.addActionListener(this);
        multiplyButton.addActionListener(this);
        divideButton.addActionListener(this);
        add(addButton);
        add(subtractButton);
        add(multiplyButton);
        add(divideButton);
        add(new JLabel("Result:"));
        resultField = new JTextField();
        resultField.setEditable(false);
        add(resultField);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e) {
        try {
            double num1 = Double.parseDouble(textField1.getText());
            double num2 = Double.parseDouble(textField2.getText());
            double result = 0;
            if (e.getSource() == addButton) {
                result = num1 + num2;
            } else if (e.getSource() == subtractButton) {
                result = num1 - num2;
            } else if (e.getSource() == multiplyButton) {
                result = num1 * num2;
            } else if (e.getSource() == divideButton) {
                if (num2 == 0) {
                    resultField.setText("Error: Divide by zero");
                    return;
                }
                result = num1 / num2;
            }
            resultField.setText(String.valueOf(result));
        } catch (NumberFormatException ex) {
            resultField.setText("Invalid input");
        }
    }
    public static void main(String[] args) {
        new SimpleCalculator();
    }
}
