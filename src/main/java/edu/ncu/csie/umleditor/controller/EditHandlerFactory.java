package edu.ncu.csie.umleditor.controller;

import javax.swing.JFrame;


import edu.ncu.csie.umleditor.util.EditType;
import edu.ncu.csie.umleditor.view.Canvas;

public class EditHandlerFactory {
    JFrame parentFrame;
    Canvas canvas;
    EditHandlerFactory(JFrame frame, Canvas canvas){
        parentFrame = frame;
        this.canvas = canvas;
    }
    public EditHandler createEditHandler(EditType type){
        switch(type){
            case RENAME:
            return new RenameHandler(parentFrame, canvas);
            case GROUP:
            return new GroupHandler(canvas);
            case UNGROUP:
            return new UngroupHandler(canvas);
            default:
            System.out.println("W: undefined menu behavior");
            return new EditHandler(canvas);
        }
    }
}
