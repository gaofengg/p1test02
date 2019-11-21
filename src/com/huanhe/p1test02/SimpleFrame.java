package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SimpleFrame extends JFrame {
    private JPanel panel1;
    private JTextField textField1;
    private JButton connectButton;
    private JTextArea textArea1;
    private JLabel inputLabel;
    private JButton cleanButton;
    private JTextArea textArea2;

    public SimpleFrame() throws HeadlessException {
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
        setTitle("Simple Client");
        setVisible(true);
//        pack();
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        textArea1.setEditable(false);
        textArea1.setFocusable(false); //设置禁止该组件获取焦点

        add(panel1);

        connectButton.setToolTipText("This is Button.");

        //按钮功能
        connectButton.addActionListener(actionEvent -> {

            String inputText = textField1.getText().trim();
            if (!(textField1.getText().equals("")) && !(inputText.isEmpty())) {
                textArea1.append(inputText + "\n");
            } else {
                textField1.setToolTipText("text error");
            }
            textField1.setText("");

//                textField1.grabFocus(); 尽可能不要用这种方法，它会将在JFrame之间传递焦点
            textField1.requestFocusInWindow();
        });

        //回车键输入功能：输入框中填写完内容后，回车键可以将内容添加到textArea1中，功能同Add Content
        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                String inputText = textField1.getText().trim();
                int keyCode = e.getKeyCode();
                if (keyCode == KeyEvent.VK_ENTER && !(textField1.getText().equals(""))) {
                    if (!(inputText.isEmpty())) {
                        textArea1.append(inputText + "\n");
                    }

                    textField1.setText("");
                }
                textField1.requestFocusInWindow();
            }
        });

        //清除按钮，一键清除textArea1中的内容，并将焦点重新定位到textField1输入框
        cleanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                textArea1.setText("");
                textField1.requestFocusInWindow();
            }
        });

        //如果输入框中的内容为全部是空格，则将输入框的背景颜色改为红色
//        if (new PassWordVerifier().verify(textField1) && !(textField1.getText().equals(""))) {
//            textField1.setBackground(Color.red);
//        }

//        new MyJTextFieldListener(textField1);


        textField1.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
               if (!textField1.getText().equals("") && textField1.getText().trim().isEmpty()) {
                   textField1.setBackground(new Color(119,58,58));
                   textArea2.setText("你输入的似乎都是空格。");
               } else {
                   textField1.setBackground(new Color(69,73,74));
                   textArea2.setText("完美的输入。");
               }
            }
        });
    }
}
