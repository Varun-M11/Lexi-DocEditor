
import java.awt.Font;
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
interface BaseComposite {

    JPanel addComposite();

    JTextPane addLeaf();
    
    Font f = new Font("Courier", Font.BOLD, 20);
    Font f1 = new Font("Lucida Handwriting", Font.BOLD, 36);
}