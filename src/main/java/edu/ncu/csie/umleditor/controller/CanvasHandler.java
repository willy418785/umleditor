package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import edu.ncu.csie.umleditor.view.*;

public class CanvasHandler extends MouseAdapter{  
    protected Canvas canvas;
    protected int x=0, y=0, endX=0, endY=0;
    public CanvasHandler(Canvas canvas){
        this.canvas = canvas;
    }
}
