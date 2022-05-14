
package edu.ncu.csie.umleditor.controller;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.view.*;

public class ComposeHandler extends LineHandler{
    public ComposeHandler(Canvas canvas){
        super(canvas);
    }
    @Override
    protected Line newLine(BasicObject start, BasicObject end){
        return new ComposeLine(start, end);
    }
}