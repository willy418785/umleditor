package edu.ncu.csie.umleditor.model;

import java.util.ArrayList;
import java.util.List;

public class Composition implements ISelectable{
    private List<BasicObject> contents = null;
    private Composition parent = null;
    private List<Composition> childs = null;
    private boolean isSelected = false;
    public Composition(){}
    public Composition(List<BasicObject> objs){
        contents = objs;
    }
    public Composition(BasicObject obj){
        contents = new ArrayList<BasicObject>();
        contents.add(obj);
    }
    

    public boolean isRoot(){
        return (parent == null);
    }
    public boolean isLeaf(){
        return (contents != null);
    }
    public List<BasicObject> getContents(){
        if (isLeaf()){
            return contents;
        }
        else{
            return null;
        }
    }
    public void setSelected(boolean bool){
        isSelected = bool;
    }    
    public boolean getSelected(){
        return isSelected;
    }
    public Composition getParent(){
        return parent;
    }
    public List<Composition> getChilds(){
        return childs;
    }
    public void setParent(Composition parent){
        this.parent = parent;
    }
    public void addChild(Composition child){
        if (childs == null){childs = new ArrayList<Composition>();}
        childs.add(child);
        child.parent = this;
    }
    public void removeChilds(){
        childs.removeAll(childs);
        childs = null;
    }
    
    public List<BasicObject> getLeafsContents(){
        // get contents of all leaf nodes as a list
        List<BasicObject> allChildsContents = new ArrayList<BasicObject>();
        if (isLeaf()){
            return contents;
        }
        else{
            for (Composition child: childs){
                List<BasicObject> childContents = child.getLeafsContents();
                allChildsContents.addAll(childContents);
            }
            return allChildsContents;
        }
    }
}

