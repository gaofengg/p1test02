package com.huanhe.p1test02;

import com.formdev.flatlaf.FlatDarculaLaf;

import javax.swing.*;
import java.util.ResourceBundle;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try {
                UIManager.setLookAndFeel(new FlatDarculaLaf());
                new SimpleFrame();
            } catch (UnsupportedLookAndFeelException e) {
                e.printStackTrace();
            }
        });
    }
}
