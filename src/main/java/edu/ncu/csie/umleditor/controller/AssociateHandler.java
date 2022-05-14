package edu.ncu.csie.umleditor.controller;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.view.*;

public class AssociateHandler extends LineHandler{
    public AssociateHandler(Canvas canvas){
        super(canvas);
    }
    @Override
    protected Line newLine(BasicObject start, BasicObject end){
        return new AssociateLine(start, end);
    }
}
