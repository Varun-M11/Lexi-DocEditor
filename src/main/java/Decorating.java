
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
//Decorator Design Pattern
abstract class Decorating {

    JTextPane pane;

    Decorating(JTextPane pane) {
        this.pane = pane;
    }

   // abstract void addDecor(int flag);

    void addDecor(int i) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
