package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
import java.awt.Color;

public class UseCaseObject extends BasicObject{
    
    public UseCaseObject(){
        super();
        text = "use case";
    }
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillOval(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawOval(x, y, width, height);
		// find the width for the specified string.
		int stringWidth = g.getFontMetrics(font).stringWidth(text);
		double empty = (width - stringWidth)/2;
		g.setFont(font);	
		g.drawString(text, x + (int)empty, y + 50);
        paintPorts(g);
    }
    
}