
import java.awt.Color;
import java.awt.Insets;
import javax.swing.BorderFactory;
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
class AddBorder extends Decorating {

    public AddBorder(JTextPane pane) {
        super(pane);
        this.pane = pane;
    }    

    @Override
    void addDecor(int flag) {
        if (flag % 2 == 0) {
            pane.setMargin(new Insets(100, 100, 100, 100));
            pane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.
                    createLineBorder(Color.BLUE, 25), BorderFactory.createEmptyBorder(20, 20, 20, 20)));
        } else {
            pane.setBorder(BorderFactory.createCompoundBorder(BorderFactory.
                    createLineBorder(Color.white), BorderFactory.createEmptyBorder(10, 10, 10, 10)));
        }
    }
}
