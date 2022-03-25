package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;
import java.awt.Color;

public class ClassObject extends BasicObject{
    
    public ClassObject(){
        super();
        text = "class";
    }
    
    
    public void paint(Graphics g){
        g.setColor(Color.WHITE);
        g.fillRect(x, y, width, height);
        g.setColor(Color.BLACK);
        g.drawRect(x,y,width,height);

        int portion = height / 3;
		g.drawLine(x, y + portion, x+width, y + portion);
		g.drawLine(x, y + portion * 2, x+width, y + portion * 2);
        
		// find the width for the specified string.
		int stringWidth = g.getFontMetrics(font).stringWidth(text);
		double empty = (width - stringWidth)/2;
		g.setFont(font);	
		g.drawString(text, x + (int)empty, y + 25);
        paintPorts(g);
    }
}
