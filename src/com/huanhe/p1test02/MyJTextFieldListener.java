package com.huanhe.p1test02;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;

public class MyJTextFieldListener implements DocumentListener {

    private JTextField jTextField = new JTextField();

    public MyJTextFieldListener(JTextField jTextField) {
        this.jTextField = jTextField;
    }

    @Override
    public void insertUpdate(DocumentEvent documentEvent) {

        if (documentEvent.getDocument().toString().equals("")) {

            jTextField.setBackground(Color.red);
        }

    }

    @Override
    public void removeUpdate(DocumentEvent documentEvent) {

    }

    @Override
    public void changedUpdate(DocumentEvent documentEvent) {

    }
}
