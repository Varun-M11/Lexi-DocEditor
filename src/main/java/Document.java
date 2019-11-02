/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
import javax.swing.*;

public class Document {

    public static void main(String[] args) {
        ChandakSir mc = new ChandakSir();
        JPanel p = mc.addComposite();
        JTextPane t = mc.addLeaf();

        FontSize fs = new FontSize(p, t);
        FontStyle st = new FontStyle(p, t);
        FontColor clr = new FontColor(p, t);
        FontFamily fam = new FontFamily(p, t);
        Decorate dr = new Decorate(p, t);
        Os os = new Os(p, t, mc.message);

        Invoke iv = new Invoke();
        iv.addButton(fs);
        iv.addButton(st);
        iv.addButton(clr);
        iv.addButton(fam);
        iv.addButton(dr);
        iv.addButton(os);

        iv.placeButton();
    }

}
