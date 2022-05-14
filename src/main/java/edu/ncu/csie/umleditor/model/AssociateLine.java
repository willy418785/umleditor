package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;

public class AssociateLine extends Line{
    private double arrowAngle = 60;
    private double arrowLength = 20;
    public AssociateLine(BasicObject startObj, BasicObject endObj){
        super(startObj, endObj);
    }
    public void paintHead(Graphics g){
        double vecLen = Math.sqrt(Math.pow((endX - x), 2) + Math.pow((endY - y), 2));
        double radiant = Math.toRadians(90 + arrowAngle);
        double vecX = (double)(endX - x) / vecLen;
        double vecY = (double)(endY - y) / vecLen;
        int x1 = endX + (int)(arrowLength * (vecX*Math.cos(radiant) - vecY*Math.sin(radiant)));
        int y1 = endY + (int)(arrowLength * (vecX*Math.sin(radiant) + vecY*Math.cos(radiant)));
        int x2 = endX + (int)(arrowLength * (vecX*Math.cos(-radiant) - vecY*Math.sin(-radiant)));
        int y2 = endY + (int)(arrowLength * (vecX*Math.sin(-radiant) + vecY*Math.cos(-radiant)));
        g.drawLine(endX, endY, x1, y1);
        g.drawLine(endX, endY, x2, y2);
    }
    public void paint(Graphics g){
        g.drawLine(x, y, endX, endY);
        paintHead(g);
        paintPorts(g);
    }
}
