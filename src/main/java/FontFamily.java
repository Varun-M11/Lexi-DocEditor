
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
class FontFamily implements ButtonsCommand {

    JPanel tools, p4;
    JTextPane pane;
    JButton tnr, calibre, sansSerif;
    JLabel l4;

    FontFamily(JPanel tools, JTextPane pane) {
        this.pane = pane;
        this.tools = tools;
        p4 = new JPanel();
        p4.setOpaque(false);
        tnr = new JButton("Times New Roman");
        tnr.setAlignmentX(Component.CENTER_ALIGNMENT);
        calibre = new JButton("Calibre");
        calibre.setAlignmentX(Component.CENTER_ALIGNMENT);
        sansSerif = new JButton("Surprise");
        sansSerif.setAlignmentX(Component.CENTER_ALIGNMENT);
        l4 = new JLabel("Font Family");
        l4.setForeground(Color.WHITE);
        l4.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void click() {
        p4.setLayout(new BoxLayout(p4, BoxLayout.Y_AXIS));
        l4.setFont(f);
        p4.add(l4);
        p4.add(tnr);
        p4.add(calibre);
        p4.add(sansSerif);
        tools.add(p4);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp);
        temp.setBackground(Color.ORANGE);
        p4.setBackground(Color.ORANGE);

        tnr.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setFontFamily(style, "Times New Roman");
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

        calibre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setFontFamily(style, "Calibri");
                try {
                    String text = pane.getDocument().getText(0, pane.getDocument().getLength());
                    pane.setText("");
                    doc.insertString(0, text, style);
                } catch (BadLocationException ex) {
                }
            }
        });

        sansSerif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                StyledDocument doc = (StyledDocument) pane.getDocument();
                Style style = doc.addStyle("StyleName", null);
                StyleConstants.setFontSize(style, 32);
                StyleConstants.setFontFamily(style, "OCR A Extended");
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
