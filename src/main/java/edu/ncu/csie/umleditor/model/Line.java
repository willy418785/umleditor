package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
import java.lang.Math;

public abstract class Line extends Shape{
    protected enum Cardinal{
        LEFT, BOTTOM, RIGHT, TOP,;
    }
    protected int endX, endY;
    protected BasicObject start, end;
    protected Cardinal startPortPos, endPortPos;
    Line(){
        super();
    }
    Line(BasicObject startObj, BasicObject endObj){
        super();
        start = startObj;
        end = endObj;
        updateEndPoint();
    }
    public BasicObject getStart(){
        return start;
    }
    public void setStart(BasicObject startObj){
        start = startObj;
    }
    public BasicObject getEnd(){
        return end;
    }
    public void setEnd(BasicObject endObj){
        end = endObj;
    }
    public void updateEndPoint(){
        // determine endpoints based on the relative position of start and end obj.
        // only execute when start and end obj. are initialized
        if(start != null && end != null){
            int startLeftBoundary = start.getPositionX();
            int startRightBoundary = startLeftBoundary + start.getWidth();
            int startTopBoundary = start.getPositionY();
            int startBottomBoundary = startTopBoundary + start.getHeight();

            int endLeftBoundary = end.getPositionX();
            int endRightBoundary = endLeftBoundary + end.getWidth();
            int endTopBoundary = end.getPositionY();
            int endBottomBoundary = endTopBoundary + end.getHeight();

            if (startTopBoundary > endBottomBoundary){
                // end obj is over start obj.
                x = start.getPositionX() + start.getWidth() / 2;
                y = start.getPositionY();
                endX = end.getPositionX() + end.getWidth() / 2;
                endY = end.getPositionY() + end.getHeight();
                startPortPos = Cardinal.TOP;
                endPortPos = Cardinal.BOTTOM;
            }
            else if (startBottomBoundary < endTopBoundary){
                // end obj is below start obj.
                x = start.getPositionX() + start.getWidth() / 2;
                y = start.getPositionY() + start.getHeight();
                endX = end.getPositionX() + end.getWidth() / 2;
                endY = end.getPositionY();
                startPortPos = Cardinal.BOTTOM;
                endPortPos = Cardinal.TOP;
            }
            else if (startLeftBoundary > endRightBoundary){
                // end obj is on the left of start obj.
                x = start.getPositionX();
                y = start.getPositionY() + start.getHeight() / 2;
                endX = end.getPositionX() + end.getWidth();
                endY = end.getPositionY() + end.getHeight() / 2;
                startPortPos = Cardinal.LEFT;
                endPortPos = Cardinal.RIGHT;
            }
            else if (startRightBoundary < endLeftBoundary){
                // end obj is on the right of start obj.
                x = start.getPositionX() + start.getWidth();
                y = start.getPositionY() + start.getHeight() / 2;
                endX = end.getPositionX();
                endY = end.getPositionY() + end.getHeight() / 2;;
                startPortPos = Cardinal.RIGHT;
                endPortPos = Cardinal.LEFT;
            }
            else{
                // end and start are overlapping
                x = start.getPositionX() + start.getWidth()/2;
                y = start.getPositionY();
                endX = end.getPositionX() + end.getWidth()/2;
                endY = end.getPositionY();
                startPortPos = Cardinal.TOP;
                endPortPos = Cardinal.TOP;
            }
        }
        setDepth(Math.max(start.getDepth(), end.getDepth()));
    }
    public boolean isGivenObjEndPoint(BasicObject obj){
        if (start == obj)
            return true;
        else if(end == obj)
            return true;
        else
            return false;
    }

    
    public void paintPorts(Graphics g){ 
        //paint ports
        //paintPortAtGivenPosAndCardinal(g, x, y, startPortPos);
        //paintPortAtGivenPosAndCardinal(g, endX, endY, endPortPos);
    }
    private void paintPortAtGivenPosAndCardinal(Graphics g, int x, int y, Cardinal cardinal){
        int leftPortX = x-portWidth, leftPortY = y-portWidth/2;
        int bottomPortX = x-portWidth/2, bottomPortY = y;
        int rightPortX = x, rightPortY = y-portWidth/2;
        int topPortX = x-portWidth/2, topPortY = y-portWidth;
        switch(cardinal){
            case LEFT:
            g.fillRect(leftPortX, leftPortY, portWidth, portWidth);
            break;
            case BOTTOM:
            g.fillRect(bottomPortX, bottomPortY, portWidth, portWidth);
            break;
            case RIGHT:
            g.fillRect(rightPortX, rightPortY, portWidth, portWidth);
            break;
            case TOP:
            g.fillRect(topPortX, topPortY, portWidth, portWidth);
            break;
        }
    };
}
