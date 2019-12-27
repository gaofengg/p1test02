package com.huanhe.p1test02;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ToolTipWithButtons {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {

            public void run() {
                new ToolTipWithButtons().makeUI();
            }
        });
    }

    public void makeUI() {
        JLabel label = new JLabel("Mouse here") {

            JToolTip toolTip;

            @Override
            public JToolTip createToolTip() {
                if (toolTip == null) {
                    JPanel panel = new JPanel(new GridLayout(0, 1));
                    for (int i = 0; i < 6; i++) {
                        final int j = i;
                        JButton button = new JButton("Click " + i);
                        button.addActionListener(new ActionListener() {

                            public void actionPerformed(ActionEvent e) {
                                System.out.println("You clicked button number " + j);
                            }
                        });
                        panel.add(button);
                    }

                    toolTip = super.createToolTip();
                    toolTip.setLayout(new BorderLayout());
                    Insets insets = toolTip.getInsets();
                    Dimension panelSize = panel.getPreferredSize();
                    panelSize.width += insets.left + insets.right;
                    panelSize.height += insets.top + insets.bottom;
                    toolTip.setPreferredSize(panelSize);
                    toolTip.add(panel);
                }
                return toolTip;
            }
        };
        label.setToolTipText("");

        JFrame frame = new JFrame();
        frame.add(label);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}

