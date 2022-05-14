package edu.ncu.csie.umleditor.controller;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.view.*;

public class UseCaseHandler extends ObjectHandler{
    public UseCaseHandler(Canvas canvas){
        super(canvas);
    }
    protected BasicObject newObject(){
        return new UseCaseObject();
    };
}

