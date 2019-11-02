

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
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
class FontStyle implements ButtonsCommand {

    JButton bold, italics, underline;
    JPanel tools, p2;
    JTextPane pane;
    JLabel l2;

    FontStyle(JPanel panel, JTextPane pane) {
        p2 = new JPanel();
        p2.setOpaque(false);
        this.tools = panel;
        this.pane = pane;
        bold = new JButton("Bold");
        bold.setAlignmentX(Component.CENTER_ALIGNMENT);
        italics = new JButton("Italics");
        italics.setAlignmentX(Component.CENTER_ALIGNMENT);
        underline = new JButton("Underline");
        underline.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Style ");
        l2.setForeground(Color.WHITE);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void click() {
        p2.setLayout(new BoxLayout(p2, BoxLayout.Y_AXIS));
        l2.setFont(f);
        p2.add(l2);
        p2.add(bold);
        p2.add(italics);
        p2.add(underline);
        tools.add(p2);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        temp.setBackground(Color.ORANGE);
        tools.add(temp);
        p2.setBackground(Color.ORANGE);

        bold.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setBold(style, true);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

        italics.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setItalic(style, true);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        }
        );

        underline.addActionListener(
                new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae
            ) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setUnderline(style, true);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        }
        );
    }

}