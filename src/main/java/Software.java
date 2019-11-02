/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
abstract class Software {

    private drawOS dos;

    Software(drawOS dos) {
        this.dos = dos;
    }

    public abstract void display();
}
