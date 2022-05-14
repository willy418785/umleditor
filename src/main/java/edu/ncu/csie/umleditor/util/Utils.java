package edu.ncu.csie.umleditor.util;

import java.util.*;
import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.model.*;
import java.lang.Math;
public class Utils {
    public static void setSelcectedGivenSelectables(List<? extends ISelectable> selectables, boolean bool){
        for (ISelectable selectable: selectables){
            selectable.setSelected(bool);
        }
    }

    public static List<? extends ISelectable> getSelectedGivenSelectables(List<? extends ISelectable> selectables){
        List<ISelectable> selecteds = new ArrayList<ISelectable>();
        for(ISelectable selectable: selectables){
            if(selectable.getSelected()){
                selecteds.add(selectable);
            }
        }
        return selecteds;
    }

    public static void SelectCompositionGivenObj(BasicObject obj, boolean bool, List<Composition> coms){
        // if the given obj belongs to an only composition, set the isSelected value of this composition.
        for (Composition com: coms){
            List<BasicObject> contents = com.getLeafsContents();
            if(contents.contains(obj)){
                Utils.setSelcectedGivenSelectables(contents, bool);
                com.setSelected(bool);
            }
        }
    }

    public static BasicObject getObjWithHighestDepthGivenObjs(List<BasicObject> objs){
        // return the obj with the highest depth in given objs. list
        BasicObject objWithHighestDepth = objs.get(0);
        for (BasicObject obj: objs){
            if(obj.getDepth() > objWithHighestDepth.getDepth()){
                objWithHighestDepth = obj;
            }
        }
        return objWithHighestDepth;
    }

    public static List<BasicObject> getObjsInsideGivenRegion(int x, int y, int endX, int endY, List<BasicObject> objs){
        // return a list of objs insides the region specified by user
        List<BasicObject> selecteds = new ArrayList<BasicObject>();
        if (endX >= 0 && endY >= 0){
            // indicate the region is a rectangular area
            int leftBoundary = Math.min(x, endX);
            int rightBoundary = Math.max(x, endX);
            int topBoundary = Math.min(y, endY);
            int bottomBoundary = Math.max(y, endY);
            for (BasicObject obj: objs){
                int objX = obj.getPositionX(), objY = obj.getPositionY();
                int objWidth = obj.getWidth(), objHeight = obj.getHeight();
                if (objX >= leftBoundary && objX + objWidth <= rightBoundary){
                    if (objY >= topBoundary && objY + objHeight<= bottomBoundary){
                        // add obj. if it's in this rectangular area
                        selecteds.add(obj);
                    }
                }
            }
        }
        else{
            // indicate the region is simply a point
            for (BasicObject obj: objs){
                int leftBoundary = obj.getPositionX();
                int rightBoundary = leftBoundary + obj.getWidth();
                int topBoundary = obj.getPositionY();
                int bottomBoundary = topBoundary + obj.getHeight();
                if (x >= leftBoundary && x <= rightBoundary){
                    if (y >= topBoundary && y <= bottomBoundary){
                        // add obj. if this point is in this obj. 
                        selecteds.add(obj);
                    }
                }
            }
        } 
        return selecteds;
    }
}
