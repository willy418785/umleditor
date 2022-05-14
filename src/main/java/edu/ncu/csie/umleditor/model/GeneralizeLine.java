package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
import java.awt.Color;
public class GeneralizeLine extends Line{
    private double arrowAngle = 60;
    private double arrowLength = 20;
    public GeneralizeLine(BasicObject startObj, BasicObject endObj){
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
        int[] pointsX = {x1, x2, endX};
        int[] pointsY = {y1, y2, endY};
        g.setColor(Color.WHITE);
        g.fillPolygon(pointsX, pointsY, 3);
        g.setColor(Color.BLACK);
        g.drawPolygon(pointsX, pointsY, 3);
    }
    public void paint(Graphics g){
       g.drawLine(x, y, endX, endY);
        paintHead(g);
        paintPorts(g);
    }
}
