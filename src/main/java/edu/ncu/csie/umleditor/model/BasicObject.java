package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
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
}
