package edu.ncu.csie.umleditor.model;


public abstract class Shape implements IPaintable, ISelectable{
    protected boolean isSelected = false;
    protected int x = 0;
    protected int y = 0;
    protected int depth = 0;
    protected int portWidth = 6;

    Shape(){
    }
    
    public void setPosition(int x, int y){
        this.x = x;
        this.y = y;
    }
    public int getPositionX(){
        return x;
    }
    public int getPositionY(){
        return y;
    }
    public void setDepth(int d){
        depth = d;
    }
    public int getDepth(){
        return depth;
    }
    public void setSelected(boolean bool){
        isSelected = bool;
    }    
    public boolean getSelected(){
        return isSelected;
    }

}
