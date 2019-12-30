package com.huanhe.p1test02;

import javafx.scene.effect.DropShadow;

import javax.swing.*;

public class SetTitleBar {
    private SetTitleBar() {
    }

    static void setJFrameTitleBar(JFrame jFrame) {
        jFrame.setUndecorated(true);
        jFrame.getRootPane().setWindowDecorationStyle(JRootPane.NONE);
    }
}
