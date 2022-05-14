package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.List;
import javax.swing.*;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.*;
import edu.ncu.csie.umleditor.view.*;

public class RenameHandler extends EditHandler{
    private JFrame workingFrame;
    public RenameHandler(JFrame workingFrame, Canvas canvas){
        super(canvas);
        this.workingFrame = workingFrame;
    }
    public void actionPerformed(ActionEvent e) {
        List<Composition> coms;
        // show up a pop-up window for user to change selected objs' names
        String input = JOptionPane.showInputDialog(workingFrame, "Rename");
        if(input!=null){
            List<BasicObject> selectedObjs = (List<BasicObject>)Utils.getSelectedGivenSelectables(canvas.objs);
            for (BasicObject obj: selectedObjs){
                obj.setText(input);
            }
            canvas.repaint();
        }
    }
}   
