package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.List;

import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.*;
import edu.ncu.csie.umleditor.view.*;

public class UngroupHandler extends EditHandler{
    public UngroupHandler(Canvas canvas){
        super(canvas);
    }
    public void actionPerformed(ActionEvent e) {
        // upgroup composition into mutiple separate compostions
        System.out.println("ungroup");
        List<Composition> selectedComs = (List<Composition>)Selectable.getSelectables(canvas.coms);
        for(Composition com: selectedComs){
            if (com.isRoot() && !com.isLeaf()){
                // only perform ungroup op. when target is a root and not a leaf(composition with only one obj)
                for(Composition child: com.getChilds()){
                    // all childs have become root so set their parent to null
                    // keep them in list
                    child.setParent(null);
                    canvas.coms.add(child);
                }
                // discard ungroup composition
                com.removeChilds();
                canvas.coms.remove(com);
            }
        }
    }
}   
