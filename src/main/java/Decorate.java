
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
class Decorate implements ButtonsCommand {

    JPanel tools, p5;
    JTextPane pane;
    JButton addscbar, addBorder;
    JLabel l5, label;

    Decorate(JPanel tools, JTextPane pane) {
        this.pane = pane;
        this.tools = tools;
        p5 = new JPanel();
        label = new JLabel("\t\t\t\t");
        p5.setOpaque(false);
        addscbar = new JButton("Add Scroll Bar");
        addscbar.setAlignmentX(Component.CENTER_ALIGNMENT);
        addBorder = new JButton("Add Border");
        addBorder.setAlignmentX(Component.CENTER_ALIGNMENT);
        l5 = new JLabel("Decorate");
        l5.setForeground(Color.WHITE);
        l5.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void click() {
        p5.setLayout(new BoxLayout(p5, BoxLayout.Y_AXIS));
        l5.setFont(f);
        p5.add(l5);
        p5.add(addscbar);
        p5.add(addBorder);
        p5.add(label);
        tools.add(p5);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp);
        temp.setBackground(Color.ORANGE);
        p5.setBackground(Color.ORANGE);

        addBorder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Decorating d = new AddBorder(pane);
                d.addDecor(0);
            }
        });

        addscbar.addActionListener((ActionEvent ae) -> {
            //Put code for adding scroll bar
        });
    }
}


