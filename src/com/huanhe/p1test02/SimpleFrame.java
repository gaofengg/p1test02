package com.huanhe.p1test02;

import com.formdev.flatlaf.util.SystemInfo;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.util.EventListener;
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
    private JPanel controlPanel;
    private JScrollPane inputStatusPane;
    private JScrollPane showContentPane;
    private JLabel messageInStatusbar;
    private JProgressBar progressBarInStatusbar;
    private JButton connectStatusButton;
    private JToolBar toolBarInStatusBarRight;
    private JButton messagesMoreButton;
    private JToolBar toolBarInStatusBarLeft;
    private JLabel mainPanelIcon;
    private JPanel customMainTitleBar;

    private MessageDetailsFromStatusBarPopUp mdfsp;

    SimpleFrame() throws HeadlessException {
        if (!SystemInfo.IS_MAC) {
            SetTitleBar.setJFrameTitleBar(this);
            customMainTitleBar.setVisible(true);
        }
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


//        panel1.setBorder(new EmptyBorder(5, 5, 5, 5)); //设置Jpanel与window的边框间距 （已从form文件中设置）

        add(mainPanel);
//        add(new MessageDetailsFromStatusBarPopUp().getMessageDetailsPopUpPanel());

//        inputTextField.setDocument(new JTextFieldLimit(10)); //限制输入文字的数量

//        addContentButton.setToolTipText(messagesBundle.getString("button.tooltip01")); //已在.form文件中定义

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
                        messageInStatusbar.setText(inputText);
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
        Border topBorder = BorderFactory.createMatteBorder(1, 0, 0, 0, new Color(70, 70, 70));
        Border bottomBorder = BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(81, 81, 81));
        statusBarPanel.setBorder(topBorder);

//        connectStatusIconLabel.setIcon(new ImageIcon("./Image/Icon/connected.png")); //NON-NLS
//        已经在form文件中加入了icon

        inputStatusPane.setBorder(new EmptyBorder(0, 0, 0, 0));
        showContentPane.setBorder(new EmptyBorder(0, 0, 0, 0));

        connectStatusButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ConnectDialog connectDialog = new ConnectDialog();
                String str = showContentTextArea.getText();
                connectDialog.setMessageContents(str);
                connectDialog.pack();
                connectDialog.setLocationRelativeTo(mainPanel);
                connectDialog.setResizable(false);
                connectDialog.setModalityType(Dialog.ModalityType.APPLICATION_MODAL);
                connectDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
                connectDialog.setVisible(true);
            }
        });

        // 状态栏的消息label，
        // 鼠标移动上去后，鼠标显示点击的手型
        //点击后，在状态栏的上方显示消息详情的tooltip（后改为Pop Up）
        //指定tooltip（后改为Pop Up）的高度和宽度（1024/3*2），高度自适应或者固定高度，自动纵向滚动。
        //鼠标离开tooltip（后改为Pop Up），关闭tooltip（后改为Pop Up）。

        mdfsp = new MessageDetailsFromStatusBarPopUp();

        messageInStatusbar.addMouseListener(new MouseAdapter() {

            Popup p;

            @Override
            public void mouseClicked(MouseEvent e) {

                mdfsp.setTextDetails(messageInStatusbar.getText());

                Point messageInStatusbarLocationOnScreen = messageInStatusbar.getLocationOnScreen();
                if (p != null) p.hide();
                final PopupFactory popupFactory = PopupFactory.getSharedInstance();
                p = popupFactory.getPopup(messageInStatusbar, mdfsp.getMessageDetailsPopUpPanel(),
                        messageInStatusbarLocationOnScreen.x, messageInStatusbarLocationOnScreen.y - 205);
                p.show();

// 将焦点放到mdfs的TextDetails组件上。
                mdfsp.getTextDetails().requestFocusInWindow();

                mdfsp.getTextDetails().addFocusListener(new FocusAdapter() {
                    @Override
                    public void focusLost(FocusEvent e) {
                        p.hide();
                    }
                });

                mdfsp.getMessageDetailHideButton().addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        p.hide();
                    }
                });

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
            }

            @Override
            public void mouseExited(MouseEvent e) {
                setCursor(Cursor.getPredefinedCursor(Cursor.DEFAULT_CURSOR));
            }
        });

        // 关于popup 的message窗口的设计结束了。

    }

    private static ResourceBundle messagesBundle = ResourceBundle.getBundle("com.huanhe.p1test02.SimpleFrame");

}
