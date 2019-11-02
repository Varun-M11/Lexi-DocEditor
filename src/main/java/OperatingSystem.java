
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
class OperatingSystem extends Software {

    String os, platform;
    drawOS dos;
    JLabel message;

    public OperatingSystem(String os, String playform, drawOS dos, JLabel message) {
        super(dos);
        this.dos = dos;
        this.os = os;
        this.platform = platform;
        this.message = message;
    }

    @Override
    public void display() {
        dos.displayOS(os, platform, message);
    }
}
