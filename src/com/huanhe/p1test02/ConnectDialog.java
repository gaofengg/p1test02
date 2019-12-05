package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.event.*;

public class ConnectDialog extends JDialog {
    private JPanel dialogMainPanel;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextField hostContent;
    private JTextField portContent;
    private JTextField clientIdContent;
    private JLabel hostLabel;
    private JLabel portLabel;
    private JLabel clientIdLabel;
    private JButton connectButtonInDialog;
    private JTextArea messageTextArea;
    private JPanel buttonGroupPanel;
    private JPanel textFieldGroupPanel;
    private JPanel messagesPanel;
    private JScrollPane messagesScrollPane;

    public ConnectDialog() {
        this.getRootPane().putClientProperty("jetbrains.awt.windowDarkAppearance", true);
        setContentPane(dialogMainPanel);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);
        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        dialogMainPanel.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        // add your code here
        dispose();
    }

    private void onCancel() {
        // add your code here if necessary
        dispose();
    }

    public void setMessageContents(String str) {
        this.messageTextArea.setText(str);
    }
//    public static void main(String[] args) {
//        ConnectDialog dialog = new ConnectDialog();
//        dialog.pack();
//        dialog.setVisible(true);
//        System.exit(0);
//    }
}
