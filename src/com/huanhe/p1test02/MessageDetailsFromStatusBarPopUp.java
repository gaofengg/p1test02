package com.huanhe.p1test02;

import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class MessageDetailsFromStatusBarPopUp {
    private JTextArea textDetails;
    private JPanel messageDetailsPopUpPanel;
    private JLabel title;
    private JLabel icon;
    private JButton messageDetailHideButton;
    private JToolBar hideButtonToolBar;
    private JScrollPane messageDetailScrollPane;

    public JPanel getMessageDetailsPopUpPanel() {
        return messageDetailsPopUpPanel;
    }

    public int getMainPanelWidth() {
        return messageDetailsPopUpPanel.getWidth();
    }

    public void setTextDetails(String str) {
        textDetails.setText(str);
    }

    public JButton getMessageDetailHideButton() {
        return messageDetailHideButton;
    }

    public JTextArea getTextDetails() {
        return textDetails;
    }
}
