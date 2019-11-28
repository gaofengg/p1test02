package com.huanhe.p1test02;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.ResourceBundle;

public class SimpleFrame extends JFrame {
    private JPanel mainPanel;
    private JTextField inputTextField;
    private JButton addContentButton;
    private JTextArea showContentTextArea;
    private JLabel inputLabel;
    private JButton cleanButton;
    private JTextArea inputStatusTextArea;
    private JPanel statusBarPanel;
    private JPanel inputControlPanel;
    private JPanel controlPanel;
    private JScrollPane inputStatusPane;
    private JScrollPane showContentPane;
    private JLabel connectStatusLabel;
    private JLabel messageInStatusbar;
    private JProgressBar progressBarInStatusbar;

    SimpleFrame() throws HeadlessException {
        this.getRootPane().putClientProperty("jetbrains.awt.windowDarkAppearance", true);
        int init_width = 1024;
        int init_height = 768;

        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenSize = tk.getScreenSize();
        Dimension initSize = new Dimension(init_width, init_height);

        int locationX = (screenSize.width - init_width) / 2;
        int locationY = (screenSize.height - init_height) / 2;

        setLocation(locationX, locationY);
//        setSize(init_width, init_height);
        setMinimumSize(initSize);
        setMaximumSize(screenSize);
        setTitle(messagesBundle.getString("simple.client"));
        setVisible(true);
//        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        showContentTextArea.setEditable(false);
        showContentTextArea.setFocusable(false); //设置禁止该组件获取焦点
        inputStatusTextArea.setFocusable(false);

//        panel1.setBorder(new EmptyBorder(5, 5, 5, 5)); //设置Jpanel与window的边框间距

        add(mainPanel);

        addContentButton.setToolTipText(messagesBundle.getString("button.tooltip01"));

        inputStatusTextArea.setText(messagesBundle.getString("no.input"));

        //按钮功能
        addContentButton.addActionListener(actionEvent -> {
            String inputText = inputTextField.getText().trim();
            if (!(inputTextField.getText().equals("")) && !(inputText.isEmpty())) {
                showContentTextArea.append(inputText + "\n");
            }

            inputTextField.setText("");

            if (inputTextField.getText().replace(" ", "").isEmpty()) {
                inputStatusTextArea.setText(messagesBundle.getString("inputting"));
                inputTextField.setBackground(new Color(69, 73, 74));
                inputTextField.setText("");
            }
            inputStatusTextArea.setText(messagesBundle.getString("waiting.input"));

//                textField1.grabFocus(); 尽可能不要用这种方法，它会将在JFrame之间传递焦点
            inputTextField.requestFocusInWindow();
        });

        //回车键输入功能：输入框中填写完内容后，回车键可以将内容添加到textArea1中，功能同Add Content
        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String inputText = inputTextField.getText().trim();
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER && !(inputTextField.getText().equals(""))) {
                    if (!(inputText.isEmpty())) {
                        showContentTextArea.append(inputText + "\n");
                    }

                    inputTextField.setText("");
                }
                inputTextField.requestFocusInWindow();
            }
        });

        //清除按钮，一键清除textArea1中的内容，并将焦点重新定位到textField1输入框
        cleanButton.addActionListener(actionEvent -> {
            showContentTextArea.setText("");
            inputTextField.requestFocusInWindow();
            if (inputTextField.getText().replace(" ", "").isEmpty()) {
                inputTextField.setBackground(new Color(69, 73, 74));
            }
            inputTextField.setText("");
            inputStatusTextArea.setText(messagesBundle.getString("waiting.input"));
        });

        //如果输入框中的内容为全部是空格，则将输入框的背景颜色改为红色
//        if (new PassWordVerifier().verify(textField1) && !(textField1.getText().equals(""))) {
//            textField1.setBackground(Color.red);
//        }

//        new MyJTextFieldListener(textField1);


        inputTextField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                if (!inputTextField.getText().equals("") && inputTextField.getText().trim().isEmpty()) {
                    inputTextField.setBackground(new Color(119, 58, 58));
                    inputStatusTextArea.setText(messagesBundle.getString("error.all.space"));
                } else if (inputTextField.getText().replace(" ", "").isEmpty()) {
                    inputStatusTextArea.setText(messagesBundle.getString("waiting.input"));
                    inputTextField.setBackground(new Color(69, 73, 74));
                } else {
                    inputStatusTextArea.setText(messagesBundle.getString("inputting"));
                    inputTextField.setBackground(new Color(69, 73, 74));
                }

            }
        });

        //状态栏的statusBarPanel显示上边框边线
        Border redBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(70, 70,70));
        statusBarPanel.setBorder(redBorder);

        connectStatusLabel.setIcon(new ImageIcon("./Image/Icon/unconnect16.png")); //NON-NLS

        inputStatusPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        showContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));


    }

    private static ResourceBundle messagesBundle = ResourceBundle.getBundle("com.huanhe.p1test02.SimpleFrame");
}
