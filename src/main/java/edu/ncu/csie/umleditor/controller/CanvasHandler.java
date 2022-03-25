package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.*;

import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.Utils;
import edu.ncu.csie.umleditor.view.*;

public class CanvasHandler extends MouseAdapter{  
    private Canvas canvasRef;
    private int x, y, endX, endY;
    private boolean isDraging = false;
    private BasicObject objConstructingLine;
    public CanvasHandler(Canvas canvas){
        canvasRef = canvas;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        switch(App.appState){
            case SELECT:
            // select obj. been clicked
            Utils.SelectGivenObjList(App.objs, false);
            Utils.SelectGivenComList(App.compositions, false);
            List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1);
            if(selectedObjs.size()>0){
                // ignore if no obj. is clicked
                // if mutiple objs. clicked, only select the obj on top
                // also select the composition that possesses this selected obj.
                BasicObject objWithHighestDepth = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                objWithHighestDepth.setSelected(true);
                Utils.SelectCompositionGivenObj(objWithHighestDepth, true);
            }
            break;
            case CLASS:
            // create a class uml object
            // also deen as a composition of its own
            BasicObject classObj = new ClassObject();
            classObj.setPosition(x, y);
            App.objs.add(classObj);
            classObj.setDepth(App.objs.indexOf(classObj));
            Composition classCom = new Composition(classObj);
            App.compositions.add(classCom);
            break;
            case USECASE:
            // create a use case uml object
            // also deen as a composition of its own
            BasicObject usecaseObj = new UseCaseObject();
            usecaseObj.setPosition(x, y);
            App.objs.add(usecaseObj);
            usecaseObj.setDepth(App.objs.indexOf(usecaseObj));
            Composition usecaseCom = new Composition(usecaseObj);
            App.compositions.add(usecaseCom);
            break;
        }
        // repaint the canvas when user click the mouse
        canvasRef.repaint();
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        x = e.getX();
        y = e.getY();
        List<BasicObject> selectedObjs;
        switch(App.appState){
            case SELECT:
            // moving obj. been clicked
            Utils.SelectGivenObjList(App.objs, false);
            Utils.SelectGivenComList(App.compositions, false);
            selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1);
            if(selectedObjs.size() > 0){
                // ignore if no obj. is clicked
                // if mutiple objs. clicked, only select the obj on top
                // also select the composition that possesses this selected obj
                // move this obj.
                isDraging = true;
                BasicObject objWithHighestDepth = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                objWithHighestDepth.setSelected(true);
                Utils.SelectCompositionGivenObj(objWithHighestDepth, true);
            }
            break;
            case ASSOCIATE:
            case GENARALIZE:
            case COMPOSE:
            // create line with start obj of obj clicked by user
            selectedObjs = Utils.getObjsInsideGivenRegion(x, y, -1, -1);
            if(selectedObjs.size() > 0){
                isDraging = true;
                BasicObject newLineStartingObj = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                objConstructingLine = newLineStartingObj;
            }
            break;
        }
        canvasRef.repaint();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        endX = e.getX();
        endY = e.getY();
        Line newLine;
        switch(App.appState){
            case SELECT:
            if(isDraging){
                // moving every obj. selected by user
                int translateX = endX - x;
                int translateY = endY - y;
                List<BasicObject> selectedObjs = Utils.getSelectedGivenObjList(App.objs);
                for (BasicObject selectedObj: selectedObjs){
                    selectedObj.setPosition(selectedObj.getPositionX() + translateX, selectedObj.getPositionY() + translateY);
                    for(Line line: App.lines){
                        if(line.isGivenObjEndPoint(selectedObj)){
                            line.updateEndPoint();
                        }
                    }
                }
            }
            else{
                // select objs. within an rectangular area
                Utils.SelectGivenObjList(App.objs, false);
                Utils.SelectGivenComList(App.compositions, false);
                List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(x, y, endX, endY);
                Utils.SelectGivenObjList(selectedObjs, true);
                for (BasicObject selectedObj: selectedObjs){
                    Utils.SelectCompositionGivenObj(selectedObj, true);
                }
            }
            break;
            case ASSOCIATE:
            if(isDraging){
                List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(endX, endY, -1, -1);
                if(selectedObjs.size() > 0){
                    // create a associate line of end obj. selected by user
                    BasicObject newLineEndingObj = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                    if (objConstructingLine != newLineEndingObj) {
                        newLine = new AssociateLine();
                        newLine.setStart(objConstructingLine);
                        newLine.setEnd(newLineEndingObj);
                        newLine.updateEndPoint();
                        App.lines.add(newLine);
                    }
                }
            }
            break;
            case GENARALIZE:
            if(isDraging){
                List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(endX, endY, -1, -1);
                if(selectedObjs.size() > 0){
                    // create a generalize line of end obj. selected by user
                    BasicObject newLineEndingObj = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                    if (objConstructingLine != newLineEndingObj) {
                        newLine = new GeneralizeLine();
                        newLine.setStart(objConstructingLine);
                        newLine.setEnd(newLineEndingObj);
                        newLine.updateEndPoint();
                        App.lines.add(newLine);
                    }
                }
            }
            break;
            case COMPOSE:
            if(isDraging){
                List<BasicObject> selectedObjs = Utils.getObjsInsideGivenRegion(endX, endY, -1, -1);
                if(selectedObjs.size() > 0){
                    BasicObject newLineEndingObj = Utils.getObjWithHighestDepthGivenObjList(selectedObjs);
                    if (objConstructingLine != newLineEndingObj) {
                        // create a compose line of end obj. selected by user
                        newLine = new ComposeLine();
                        newLine.setStart(objConstructingLine);
                        newLine.setEnd(newLineEndingObj);
                        newLine.updateEndPoint();
                        App.lines.add(newLine);
                    }
                }
            }
            break;
        }
        objConstructingLine = null;
        isDraging = false;
        canvasRef.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void mouseMoved(MouseEvent e){
        
    }
}
