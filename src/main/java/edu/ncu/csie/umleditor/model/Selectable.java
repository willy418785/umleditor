package edu.ncu.csie.umleditor.model;

import java.util.ArrayList;
import java.util.List;

public class Selectable {
    protected boolean isSelected;
    public Selectable(){
        isSelected = false;
    }
    public void setSelected(boolean bool){
        isSelected = bool;
    }    
    public boolean getSelected(){
        return isSelected;
    }
    public static void setSelectables(List<? extends Selectable> selectables, boolean bool){
        for (Selectable selectable: selectables){
            selectable.setSelected(bool);
        }
    }

    public static List<? extends Selectable> getSelectables(List<? extends Selectable> selectables){
        List<Selectable> selecteds = new ArrayList<Selectable>();
        for(Selectable selectable: selectables){
            if(selectable.getSelected()){
                selecteds.add(selectable);
            }
        }
        return selecteds;
    }
}
