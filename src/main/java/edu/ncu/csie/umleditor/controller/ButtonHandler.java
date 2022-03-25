package edu.ncu.csie.umleditor.controller;
import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.util.ButtonState;

import java.awt.event.*;

public class ButtonHandler implements ActionListener{
    private ButtonState state;
    public ButtonHandler(ButtonState state){
        this.state = state;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // change state of App if button is clicked
        App.appState = this.state;
        System.out.println(App.appState.getName());
    }
}
