package com.penguinlord.library.lms;

import javax.swing.*;
import java.awt.*;

public class Loginform extends JFrame {

    // UI Componentsv `
    
    private JButton loginButton;
    private JButton registerButton;
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JLabel usernameLabel;
    private JLabel passwordLabel;
    // private ;

    // Customizable Styles
    private final Color primaryColor = new Color(51, 153, 255);
    private final Color buttonColor = new Color(0, 55, 0);
    private final Color buttonTextColor = new Color(101, 255, 255);
    private final Font labelFont = new Font("Segoe UI", Font.PLAIN, 14);
    private final Font buttonFont = new Font("Segoe UI", Font.BOLD, 14);
    
    public Loginform() {
        initComponents();
        applyStyles();
    }

    private void initComponents() {
        // Create Components
        loginButton = new JButton("Login");
        registerButton = new JButton("Register");
        usernameField = new JTextField();
        passwordField = new JPasswordField();
        usernameLabel = new JLabel("Username");
        passwordLabel = new JLabel("Password");

        // Action Listeners
        loginButton.addActionListener(evt -> handleLogin());
        registerButton.addActionListener(evt -> new RegisterForm().setVisible(true));

        // Layout Configuration
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Login Form");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center on screen

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);

        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(95)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING, false)
                        .addComponent(usernameLabel)
                        .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addComponent(passwordLabel)
                        .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, 200, GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(loginButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)
                            .addGap(18)
                            .addComponent(registerButton, GroupLayout.PREFERRED_SIZE, 90, GroupLayout.PREFERRED_SIZE)))
                    .addContainerGap(95, Short.MAX_VALUE))
        );

        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(40)
                    .addComponent(usernameLabel)
                    .addGap(5)
                    .addComponent(usernameField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(18)
                    .addComponent(passwordLabel)
                    .addGap(5)
                    .addComponent(passwordField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
                    .addGap(30)
                    .addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                        .addComponent(loginButton)
                        .addComponent(registerButton))
                    .addContainerGap(40, Short.MAX_VALUE))
        );
    }

    private void applyStyles() {
        getContentPane().setBackground(primaryColor);

        usernameLabel.setFont(labelFont);
        passwordLabel.setFont(labelFont);

        loginButton.setBackground(buttonColor);
        loginButton.setForeground(buttonTextColor);
        loginButton.setFont(buttonFont);

        registerButton.setBackground(new Color(0, 128, 213));
        registerButton.setForeground(buttonTextColor);
        registerButton.setFont(buttonFont);

        usernameField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
        passwordField.setFont(new Font("Segoe UI", Font.PLAIN, 13));
    }

    private void handleLogin() {
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());

        if (username.equals("admin") && password.equals("1234")) {
            JOptionPane.showMessageDialog(this, "Login Successful! Welcome " + username + "!");
            // Proceed to next window
            // new Dashboard().setVisible(true);
            dispose();
        } else {
            JOptionPane.showMessageDialog(this, "Invalid username or password!", "Login Failed", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        // Use Nimbus Look and Feel
        try {
            for (UIManager.LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (Exception ignored) {}

        EventQueue.invokeLater(() -> new Loginform().setVisible(true));
    }
}
