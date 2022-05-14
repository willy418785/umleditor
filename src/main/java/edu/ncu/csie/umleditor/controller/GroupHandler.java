package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.List;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.*;
import edu.ncu.csie.umleditor.view.*;

public class GroupHandler extends EditHandler{
    public GroupHandler(Canvas canvas){
        super(canvas);
    }
    public void actionPerformed(ActionEvent e) {
        System.out.println("group");
        List<Composition> selectedComs = (List<Composition>)Utils.getSelectedGivenSelectables(canvas.coms);
        
        if (selectedComs.size() > 1){
            // group all composition which are selected by user
            // only perform group op. when mutiple compositions are selected
            Composition newCom = new Composition();
            for(Composition com: selectedComs){
                newCom.addChild(com);
            }
            newCom.setSelected(true);
            // remove grouped compostions, cuz only keep the root in list
            canvas.coms.removeAll(selectedComs);
            canvas.coms.add(newCom);
        }
    }
}   
