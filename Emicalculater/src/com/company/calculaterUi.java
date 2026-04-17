package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 class EmiCalculatorUI {

    public static void main(String[] args) {

        // Create Frame
        final JFrame frame = new JFrame("EMI Calculator");
        frame.setSize(550, 300);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(5, 2, 8, 8));

        // Fields
        JLabel loanLabel = new JLabel("Loan Amount:");
        final JTextField loanField = new JTextField();

        JLabel rateLabel = new JLabel("Interest Rate (%):");
        final JTextField rateField = new JTextField();

        JLabel tenureLabel = new JLabel("Tenure (months):");
        final JTextField tenureField = new JTextField();

        JLabel resultLabel = new JLabel("EMI:");
        final JTextField resultField = new JTextField();
        resultField.setEditable(false);

        JButton calculateBtn = new JButton("Evaluate Emi");

        // Button Logic
        calculateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    double P = Double.parseDouble(loanField.getText());
                    double rate = Double.parseDouble(rateField.getText());
                    int N = Integer.parseInt(tenureField.getText());

                    double R = rate / 12 / 100;

                    double emi = (P * R * Math.pow(1 + R, N)) /
                            (Math.pow(1 + R, N) - 1);

                    resultField.setText("₹ " + String.format("%.2f", emi));

                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Enter valid values!");
                }
            }
        });

        // Add to Frame
        frame.add(loanLabel);
        frame.add(loanField);

        frame.add(rateLabel);
        frame.add(rateField);

        frame.add(tenureLabel);
        frame.add(tenureField);

        frame.add(resultLabel);
        frame.add(resultField);

        frame.add(new JLabel());
        frame.add(calculateBtn);

        frame.setVisible(true);
    }
}