
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
class Os implements ButtonsCommand {

    JPanel tools, p6;
    JTextPane pane;
    JButton windows, linux, macOS;
    JLabel status, l2;

    Os(JPanel tools, JTextPane pane, JLabel status) {
        this.pane = pane;
        this.tools = tools;
        this.status = status;
        p6 = new JPanel();
        p6.setOpaque(false);
        windows = new JButton("Windows");
        windows.setAlignmentX(Component.CENTER_ALIGNMENT);
        linux = new JButton("Linux");
        linux.setAlignmentX(Component.CENTER_ALIGNMENT);
        macOS = new JButton("MacOS");
        macOS.setAlignmentX(Component.CENTER_ALIGNMENT);
        l2 = new JLabel("Operating System");
        l2.setForeground(Color.WHITE);
        l2.setAlignmentX(Component.CENTER_ALIGNMENT);
    }

    @Override
    public void click() {
        p6.setLayout(new BoxLayout(p6, BoxLayout.Y_AXIS));
        l2.setFont(f);
        p6.add(l2);
        p6.add(windows);
        p6.add(linux);
        p6.add(macOS);
        tools.add(p6);
        JPanel temp = new JPanel();
        temp.setOpaque(false);
        temp.setSize(new Dimension(50, 50));
        tools.add(temp);
        temp.setBackground(Color.ORANGE);
        p6.setBackground(Color.ORANGE);

        windows.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Software windows = new OperatingSystem("Windows", "Platform1", new Windows(), status);
                windows.display();
            }
        });

        linux.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Software linux = new OperatingSystem("Linux", "Platform2", new Linux(), status);
                linux.display();
            }
        });

        macOS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                Software macOS = new OperatingSystem("MacOS", "Platform3", new Mac(), status);
                macOS.display();
            }
        });
    }
}
