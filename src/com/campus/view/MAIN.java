package com.campus.view;

import javax.swing.*;

public class MAIN{
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (Exception ignored) {}

        SwingUtilities.invokeLater(() -> {
            new LoginUI().setVisible(true);
        });
    }
}
