package com.huanhe.p1test02;

import javax.swing.*;

public class PassWordVerifier extends InputVerifier {

    @Override
    public boolean verify(JComponent jComponent) {
        JTextField jTextField = (JTextField) jComponent;

        return jTextField.getText().trim().isEmpty();
    }
}
