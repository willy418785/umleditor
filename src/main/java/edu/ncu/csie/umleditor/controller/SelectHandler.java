package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.*;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.Utils;
import edu.ncu.csie.umleditor.view.*;

public class SelectHandler extends CanvasHandler{
    protected boolean isDraging = false;

    public SelectHandler(Canvas canvas){
        super(canvas);
    }
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        // select obj. been clicked
        Utils.setSelcectedGivenSelectables(canvas.objs, false);
        Utils.setSelcectedGivenSelectables(canvas.coms, false);
        List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1, canvas.objs);
        if(selectedObjs.size()>0){
            // ignore if no obj. is clicked
            // if mutiple objs. clicked, only select the obj on top
            // also select the composition that possesses this selected obj.
            BasicObject objWithHighestDepth = Utils.getObjWithHighestDepthGivenObjs(selectedObjs);
            objWithHighestDepth.setSelected(true);
            Utils.SelectCompositionGivenObj(objWithHighestDepth, true, canvas.coms);
        }
        // repaint the canvas when user click the mouse
        canvas.repaint();
    }
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        List<BasicObject> selectedObjs;
        // moving obj. been clicked
        Utils.setSelcectedGivenSelectables(canvas.objs, false);
        Utils.setSelcectedGivenSelectables(canvas.coms, false);
        selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1, canvas.objs);
        if(selectedObjs.size() > 0){
            // ignore if no obj. is clicked
            // if mutiple objs. clicked, only select the obj on top
            // also select the composition that possesses this selected obj
            // move this obj.
            isDraging = true;
            BasicObject objWithHighestDepth = Utils.getObjWithHighestDepthGivenObjs(selectedObjs);
            objWithHighestDepth.setSelected(true);
            Utils.SelectCompositionGivenObj(objWithHighestDepth, true, canvas.coms);
        }
        canvas.repaint();
    }
    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        endX = e.getX();
        endY = e.getY();
        if(isDraging){
            // moving every obj. selected by user
            int translateX = endX - x;
            int translateY = endY - y;
            List<? extends ISelectable> selecteds = Utils.getSelectedGivenSelectables(canvas.objs);
            for (BasicObject selectedObj: (List<BasicObject>)selecteds){
                selectedObj.setPosition(selectedObj.getPositionX() + translateX, selectedObj.getPositionY() + translateY);
                for(Line line: canvas.lines){
                    if(line.isGivenObjEndPoint(selectedObj)){
                        line.updateEndPoint();
                    }
                }
            }
        }
        else{
            // select objs. within an rectangular area
            Utils.setSelcectedGivenSelectables(canvas.objs, false);
            Utils.setSelcectedGivenSelectables(canvas.coms, false);
            List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(x, y, endX, endY, canvas.objs);
            Utils.setSelcectedGivenSelectables(selectedObjs, true);
            for (BasicObject selectedObj: selectedObjs){
                Utils.SelectCompositionGivenObj(selectedObj, true, canvas.coms);
            }
        }
        isDraging = false;
        canvas.repaint();
    }
}
