package edu.ncu.csie.umleditor.model;

import java.util.ArrayList;
import java.util.List;

public class Composition extends Selectable{
    private List<BasicObject> contents = null;
    private Composition parent = null;
    private List<Composition> childs = null;
    public Composition(){
        super();
    }
    public Composition(List<BasicObject> objs){
        super();
        contents = objs;
    }
    public Composition(BasicObject obj){
        super();
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

    public static void selectCompositionGivenObj(BasicObject obj, boolean bool, List<Composition> coms){
        // if the given obj belongs to an only composition, set the isSelected value of this composition.
        for (Composition com: coms){
            List<BasicObject> contents = com.getLeafsContents();
            if(contents.contains(obj)){
                Selectable.setSelectables(contents, bool);
                com.setSelected(bool);
            }
        }
    }
}

