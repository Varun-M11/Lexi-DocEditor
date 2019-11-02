

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
class FontSize implements ButtonsCommand {

    JButton incr, decr;
    JPanel tools, p1;
    JTextPane pane;
    JLabel l1, label;
    static int a;

    FontSize(JPanel panel, JTextPane pane) {
        p1 = new JPanel();
        p1.setPreferredSize(dimen);
        p1.setOpaque(false);
        this.tools = panel;
        this.pane = pane;

        incr = new JButton("Up");
        incr.setAlignmentX(Component.CENTER_ALIGNMENT);
        decr = new JButton("Down");
        decr.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1 = new JLabel("Size ");
        l1.setAlignmentX(Component.CENTER_ALIGNMENT);
        l1.setForeground(Color.WHITE);
        label = new JLabel("\t\t\t\t");

        StyledDocument doc = (StyledDocument) pane.getDocument();
        Style style = doc.addStyle("StyleName", null);
        a = StyleConstants.getFontSize(style);
    }

    public void click() {

        p1.setLayout(new BoxLayout(p1, BoxLayout.Y_AXIS));
        l1.setFont(f);
        p1.add(l1);
        p1.add(incr, Component.CENTER_ALIGNMENT);
        p1.add(decr, Component.CENTER_ALIGNMENT);
        p1.add(label);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp, BorderLayout.WEST);
        temp.setBackground(Color.ORANGE);
        tools.add(p1);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp);
        p1.setBackground(Color.ORANGE);

        incr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Font font = pane.getFont();
                float size = font.getSize() + 2.0f;
                pane.setFont(font.deriveFont(size));
            }
        });

        decr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Font font = pane.getFont();
                float size = font.getSize() - 2.0f;
                pane.setFont(font.deriveFont(size));
            }
        });
    }
}
