package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.*;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.Utils;
import edu.ncu.csie.umleditor.view.*;

public abstract class LineHandler extends CanvasHandler{
    protected boolean isDraging = false;
    protected BasicObject objConstructingLine;
    public LineHandler(Canvas canvas){
        super(canvas);
    }
    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        List<BasicObject> selectedObjs; 
        selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1, canvas.objs);
        if(selectedObjs.size() > 0){
            isDraging = true;
            BasicObject newLineStartingObj = Utils.getObjWithHighestDepthGivenObjs(selectedObjs);
            objConstructingLine = newLineStartingObj;
        }
        canvas.repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        endX = e.getX();
        endY = e.getY();
        if(isDraging){
            List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(endX, endY, -1, -1, canvas.objs);
            if(selectedObjs.size() > 0){
                // create a associate line of end obj. selected by user
                BasicObject newLineEndingObj = Utils.getObjWithHighestDepthGivenObjs(selectedObjs);
                if (objConstructingLine != newLineEndingObj) {
                    Line newLine = newLine(objConstructingLine, newLineEndingObj);
                    canvas.lines.add(newLine);
                }
            }
        }
        objConstructingLine = null;
        isDraging = false;
        canvas.repaint();
    }
    protected abstract Line newLine(BasicObject start, BasicObject end);
}
