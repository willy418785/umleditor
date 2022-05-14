package edu.ncu.csie.umleditor.view;
import java.awt.Color;
import java.awt.Graphics;
import java.util.*;
import java.awt.event.*;

import javax.swing.*;
import edu.ncu.csie.umleditor.*;
import edu.ncu.csie.umleditor.controller.*;
import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.ButtonState;

public class Canvas extends JPanel{
    public List<BasicObject> objs;
    public List<Composition> coms; 
    public List<Line> lines;
    public Map<ButtonState, MouseAdapter> handlerMap;
    public Canvas(){
        // initialize Canvas style and add event listeners
        super();
        objs = new ArrayList<BasicObject>();
        coms = new ArrayList<Composition>();
        lines = new ArrayList<Line>();
        handlerMap = new EnumMap<ButtonState, MouseAdapter>(ButtonState.class);
        
        for(ButtonState state : ButtonState.values()) {
            // create corresponding handler for each button state
            CanvasHandler handler;
            switch(state){
                case SELECT:
                handler = new SelectHandler(this);
                break;
                case ASSOCIATE:
                handler = new AssociateHandler(this);
                break;
                case GENARALIZE:
                handler = new GeneralizeHandler(this);
                break;
                case COMPOSE:
                handler = new ComposeHandler(this);
                break;
                case CLASS:
                handler = new ClassHandler(this);
                break;
                case USECASE:
                handler = new UseCaseHandler(this);
                break;
                default:
                handler = new CanvasHandler(this);
                System.out.println("W: undefined button");
                break;
            }

            // add this button to Map and button group
            handlerMap.put(state, handler);
        }

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
