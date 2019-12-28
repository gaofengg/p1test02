package com.huanhe.p1test02;

import javax.swing.*;

public class SetTitleBar {
    private SetTitleBar() {
    }

    static void setJFrameTitleBar(JFrame jFrame) {
        jFrame.setUndecorated(true);
        jFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }
}
