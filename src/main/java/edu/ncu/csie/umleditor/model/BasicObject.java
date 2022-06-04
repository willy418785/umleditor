package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
import java.awt.Font;

public abstract class BasicObject extends Shape{
    protected int width;
    protected int height;
    protected String text = "";
    protected Font font = new Font(Font.DIALOG, Font.BOLD, 14);
    
    BasicObject(){
        super();
        width = 100;
        height = 100;
    }
    public void setText(String txt){
        text = txt;
    }
    public String getText(){
        return text;
    }
    public void setSize(int width, int height){
        this.width = width;
        this.height = width;
    }
    public int getWidth(){
        return width;
    }
    public int getHeight(){
        return height;
    }
    public boolean isInside(int x, int y){
        if(x >= this.x && x <= this.x + width){
            if(y >= this.y && y <= this.y + height)
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }
    public boolean isInside(int x, int y, int endX, int endY){
        int leftBoundary = Math.min(x, endX);
        int rightBoundary = Math.max(x, endX);
        int topBoundary = Math.min(y, endY);
        int bottomBoundary = Math.max(y, endY);
        if(leftBoundary <= this.x && rightBoundary >= this.x + width){
            if(topBoundary <= this.y && bottomBoundary >= this.y + height)
                return true;
            else
                return false;
        }
        else{
            return false;
        }
    }

    public void paintHead(Graphics g){};
    public void paintPorts(Graphics g){
        if (isSelected){
            //paint ports
            int leftPortX = x-portWidth, leftPortY = y+height/2-portWidth/2;
            int bottomPortX = x+width/2-portWidth/2, bottomPortY = y+height;
            int rightPortX = x+width, rightPortY = y+height/2-portWidth/2;
            int topPortX = x+width/2-portWidth/2, topPortY = y-portWidth;
            g.fillRect(leftPortX, leftPortY, portWidth, portWidth);
            g.fillRect(bottomPortX, bottomPortY, portWidth, portWidth);
            g.fillRect(rightPortX, rightPortY, portWidth, portWidth);
            g.fillRect(topPortX, topPortY, portWidth, portWidth);
        }
    }

    public static BasicObject getObjWithHighestDepthGivenObjs(List<BasicObject> objs){
        // return the obj with the highest depth in given objs. list
        BasicObject objWithHighestDepth = objs.get(0);
        for (BasicObject obj: objs){
            if(obj.depth > objWithHighestDepth.depth){
                objWithHighestDepth = obj;
            }
        }
        return objWithHighestDepth;
    }
    public static List<BasicObject> getInsideObjs(int x, int y, List<BasicObject> objs){
        // return a list of objs insides the region specified by user
        List<BasicObject> selecteds = new ArrayList<BasicObject>();
        // indicate the region is simply a point
        for (BasicObject obj: objs){
            if(obj.isInside(x, y))
                selecteds.add(obj);
        }
        return selecteds;
    }
    public static List<BasicObject> getInsideObjs(int x, int y, int endX, int endY, List<BasicObject> objs){
        // return a list of objs insides the rectangular area specified by user
        List<BasicObject> selecteds = new ArrayList<BasicObject>();
        for (BasicObject obj: objs){
            if(obj.isInside(x, y, endX, endY))
                selecteds.add(obj);
        }
        return selecteds;
    }
}
