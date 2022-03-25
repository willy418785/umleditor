package edu.ncu.csie.umleditor.controller;
import java.awt.event.*;
import java.util.List;

import javax.swing.*;

import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.model.BasicObject;
import edu.ncu.csie.umleditor.model.Composition;
import edu.ncu.csie.umleditor.util.EditType;
import edu.ncu.csie.umleditor.util.Utils;

public class EditMenuHandler implements ActionListener{
    private EditType type;
    private JFrame workingFrame;
    private JPanel canvas;
    public EditMenuHandler(JFrame workingFrame, EditType type, JPanel canvas){
        this.type = type;
        this.workingFrame = workingFrame;
        this.canvas = canvas;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        List<Composition> coms;
        // TODO Auto-generated method stub
        switch(type){
            case RENAME:
            // show up a pop-up window for user to change selected objs' names
            JOptionPane popUpDialog = new JOptionPane();
            String input = popUpDialog.showInputDialog(workingFrame, "Rename");
            if(input!=null){
                List<BasicObject> selectedObjs = Utils.getSelectedGivenObjList(App.objs);
                for (BasicObject obj: selectedObjs){
                    obj.setText(input);
                }
                canvas.repaint();
            }
            break;

            case GROUP:
            // group all composition which are selected by user
            System.out.println("group");
            coms = Utils.getSelectedGivenComList(App.compositions);
            
            if (coms.size() > 1){
                // only perform group op. when mutiple compositions are selected
                Composition newCom = new Composition();
                for(Composition com: coms){
                    newCom.addChild(com);
                }
                newCom.setSelected(true);
                // remove grouped compostions, cuz only keep the root in list
                App.compositions.removeAll(coms);
                App.compositions.add(newCom);
            }
            break;

            case UNGROUP:
            // upgroup composition into mutiple separate compostions
            System.out.println("ungroup");
            coms = Utils.getSelectedGivenComList(App.compositions);
            for(Composition com: coms){
                if (com.isRoot() && !com.isLeaf()){
                    // only perform ungroup op. when target is a root and not a leaf(composition with only one obj)
                    for(Composition child: com.getChilds()){
                        // all childs have become root so set their parent to null
                        // keep them in list
                        child.setParent(null);
                        App.compositions.add(child);
                    }
                    // discard ungroup composition
                    com.removeChilds();
                    App.compositions.remove(com);
                }
            }
            break;
        }
    }
    
}
