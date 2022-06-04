package edu.ncu.csie.umleditor.view;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;

import javax.swing.*;
import edu.ncu.csie.umleditor.model.*;

public class Canvas extends JPanel{
    public List<BasicObject> objs;
    public List<Composition> coms; 
    public List<Line> lines;
    public Canvas(){
        // initialize Canvas style and add event listeners
        super();
        objs = new ArrayList<BasicObject>();
        coms = new ArrayList<Composition>();
        lines = new ArrayList<Line>();
        setBorder(BorderFactory.createLineBorder(Color.black, 1));
        setBackground(Color.white);
    }
    public void paintComponent(Graphics g) {
        // painting routine (always paint lines before anything)
        super.paintComponent(g);       
        for (Shape shape: lines){
            shape.paint(g);
        }
        for (Shape shape: objs){
            shape.paint(g);
        }
    }
}
