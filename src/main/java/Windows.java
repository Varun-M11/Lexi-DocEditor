
import javax.swing.JLabel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
class Windows implements drawOS {

    @Override
    public void displayOS(String os, String platform, JLabel status) {
        status.setText("Document made compatible with Windows OS");
    }

}