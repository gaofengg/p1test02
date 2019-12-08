package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;


public class MessageInStatusBarToolTip extends JToolTip {
    JToolTip toolTip = null;
    @Override
    public JToolTip createToolTip() {
        JToolTip t = toolTip;
        toolTip = null;
        if (t != null) {
            t.addMouseMotionListener(new MouseMotionAdapter() { // #233642

                boolean initialized = false;

                @Override
                public void mouseMoved(MouseEvent e) {
                    if (!initialized) {
                        initialized = true; // ignore the first event
                    } else {
                        // hide the tooltip if mouse moves over it
                        ToolTipManager.sharedInstance().mousePressed(e);
                    }
                }
            });
            return t;
        } else {
            return super.createToolTip();
        }
    }
}

