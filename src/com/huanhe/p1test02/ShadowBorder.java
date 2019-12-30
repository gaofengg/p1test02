package com.huanhe.p1test02;

import javax.swing.border.AbstractBorder;
import java.awt.*;
import java.awt.Graphics2D;

public class ShadowBorder extends AbstractBorder {
    int xOff, yOff;
    Insets insets;

    public ShadowBorder(int xOff, int yOff) {
        this.xOff = xOff;
        this.yOff = yOff;
        insets = new Insets(0, 0, xOff, yOff);
    }

    public Insets getBorderInsets(Component comp) {
        return insets;
    }

    public void paintBorder(Component comp, Graphics g, int x, int y, int width, int height) {
        g.setColor(Color.black);
        g.translate(x, y);
        g.fillRect(width - xOff, yOff - xOff, xOff, height - yOff);
        g.fillRect(xOff - yOff, height - yOff, width, yOff);
        g.translate(-x, -y);
    }
}
