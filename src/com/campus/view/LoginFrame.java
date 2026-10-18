
package com.campus.view;

import com.campus.dao.UserDAO;
import com.campus.model.User;

import javax.swing.*;
import java.awt.*;

public class LoginUI extends JFrame {
    private JTextField emailField;
    private JPasswordField passField;
    private UserDAO userDAO = new UserDAO();

    public LoginUI() {
        setTitle("Campus Lost & Found - Login");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(4, 2, 10, 10));

        add(new JLabel("  Email:"));
        emailField = new JTextField();
        add(emailField);

        add(new JLabel("  Password:"));
        passField = new JPasswordField();
        add(passField);

        JButton loginBtn = new JButton("Login");
        JButton registerBtn = new JButton("Register");
        add(loginBtn);
        add(registerBtn);

        loginBtn.addActionListener(e -> {
            String email = emailField.getText();
            String pass = new String(passField.getPassword());
            User user = userDAO.loginUser(email, pass);
            if (user != null) {
                JOptionPane.showMessageDialog(this, "Login Successful!");
                new DashboardFrame(user).setVisible(true);
                dispose();
            } else {
                JOptionPane.showMessageDialog(this, "Invalid Credentials", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        registerBtn.addActionListener(e -> {
            String name = JOptionPane.showInputDialog("Enter Full Name:");
            String email = JOptionPane.showInputDialog("Enter Email:");
            String pass = JOptionPane.showInputDialog("Enter Password:");
            String phone = JOptionPane.showInputDialog("Enter Phone:");
            if (name != null && email != null && pass != null) {
                if (userDAO.registerUser(name, email, pass, phone)) {
                    JOptionPane.showMessageDialog(this, "Registration Successful! Please login.");
                } else {
                    JOptionPane.showMessageDialog(this, "Registration Failed.", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
    }
}
