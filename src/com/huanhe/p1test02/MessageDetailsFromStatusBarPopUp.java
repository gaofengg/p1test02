package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

public class MessageDetailsFromStatusBarPopUp {
    private JTextArea textDetails;
    private JPanel messageDetailsPopUpPanel;
    private JLabel title;
    private JLabel icon;


    public JPanel getMessageDetailsPopUpPanel() {
        return messageDetailsPopUpPanel;
    }

    public int getMainPanelWidth() {
        return messageDetailsPopUpPanel.getWidth();
    }
}
