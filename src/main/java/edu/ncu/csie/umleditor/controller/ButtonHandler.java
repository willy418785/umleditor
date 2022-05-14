package edu.ncu.csie.umleditor.controller;
import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.util.ButtonState;
import edu.ncu.csie.umleditor.view.Canvas;

import java.awt.event.*;

public class ButtonHandler implements ActionListener{
    private ButtonState state;
    private Canvas canvas;
    public ButtonHandler(Canvas canvas, ButtonState state){
        this.state = state;
        this.canvas = canvas;
    }

    @Override
    public void actionPerformed(java.awt.event.ActionEvent e) {
        // change state of App if button is clicked
        for (MouseListener listener : canvas.getMouseListeners()) {
            canvas.removeMouseListener(listener);
        }
        canvas.addMouseListener(canvas.handlerMap.get(state));
    }
}
