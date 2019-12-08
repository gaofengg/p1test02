package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.*;

public class MessageDetailsFromStatusBarPopUp {
    private JTextArea textDetails;
    private JPanel messageDetailsPopUpPanel;
    private JLabel title;

    public JPanel getMessageDetailsPopUpPanel() {
        return messageDetailsPopUpPanel;
    }

    public int getMainPanelWidth() {
        return messageDetailsPopUpPanel.getWidth();
    }

    private JLabel icon;
}
