
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Varun M
 */
class Invoke {

    private java.util.List<ButtonsCommand> orderList = new ArrayList<>();

    public void addButton(ButtonsCommand button) {
        orderList.add(button);
    }

    public void placeButton() {
        for (ButtonsCommand buttonsCommand : orderList) {
            buttonsCommand.click();
        }
    }
}
