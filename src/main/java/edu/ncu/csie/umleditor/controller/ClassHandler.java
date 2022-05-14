package edu.ncu.csie.umleditor.controller;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.view.*;

public class ClassHandler extends ObjectHandler{
    public ClassHandler(Canvas canvas){
        super(canvas);
    }
    protected BasicObject newObject(){
        return new ClassObject();
    };
}
