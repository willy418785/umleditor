package edu.ncu.csie.umleditor.view;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.*;
import edu.ncu.csie.umleditor.*;
import edu.ncu.csie.umleditor.controller.CanvasHandler;
import edu.ncu.csie.umleditor.model.*;

public class Canvas extends JPanel{
    public Canvas(){
        // initialize Canvas style and add event listener
        super();
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setBackground(Color.white);
        addMouseListener(new CanvasHandler(this));
    }
    public void paintComponent(Graphics g) {
        // painting routine (always paint lines before anything)
        super.paintComponent(g);       
        for (Shape shape: App.lines){
            shape.paint(g);
        }
        for (Shape shape: App.objs){
            shape.paint(g);
        }
    }
}
