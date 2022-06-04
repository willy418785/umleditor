package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.view.*;


public abstract class ObjectHandler extends CanvasHandler{
    public ObjectHandler(Canvas canvas){
        super(canvas);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        // create a uml object
        // also deen as a composition of its own
        BasicObject obj = newObject();
        obj.setPosition(x, y);
        canvas.objs.add(obj);
        obj.setDepth(canvas.objs.indexOf(obj));
        Composition com = new Composition(obj);
        canvas.coms.add(com);
        // repaint the canvas when user click the mouse
        canvas.repaint();
    }

    protected abstract BasicObject newObject();
}
