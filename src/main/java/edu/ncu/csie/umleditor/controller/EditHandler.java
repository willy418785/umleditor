package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import edu.ncu.csie.umleditor.view.*;

public abstract class EditHandler implements ActionListener{
    protected Canvas canvas;
    public EditHandler(Canvas canvas){
        this.canvas = canvas;
    }
}
