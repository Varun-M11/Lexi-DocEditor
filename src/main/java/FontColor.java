
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
class FontColor implements ButtonsCommand {

    JPanel tools, p3;
    JTextPane pane;
    JButton red, green, blue;
    JLabel l3;

    FontColor(JPanel tools, JTextPane pane) {
        this.pane = pane;
        this.tools = tools;
        p3 = new JPanel();
        p3.setOpaque(false);
        red = new JButton("Red");
        red.setAlignmentX(Component.CENTER_ALIGNMENT);
        green = new JButton("Green");
        green.setAlignmentX(Component.CENTER_ALIGNMENT);
        blue = new JButton("Blue");
        blue.setAlignmentX(Component.CENTER_ALIGNMENT);
        l3 = new JLabel("Color");
        l3.setForeground(Color.WHITE);
        l3.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    public void click() {
        p3.setLayout(new BoxLayout(p3, BoxLayout.Y_AXIS));
        l3.setFont(f);
        p3.add(l3);
        p3.add(red);
        p3.add(green);
        p3.add(blue);
        tools.add(p3);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp);
        temp.setBackground(Color.ORANGE);
        p3.setBackground(Color.ORANGE);

        red.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setForeground(style, Color.RED);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

        green.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setForeground(style, Color.GREEN);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

        blue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setForeground(style, Color.BLUE);
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

    }
}
