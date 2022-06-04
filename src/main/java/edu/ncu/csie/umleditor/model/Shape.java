package edu.ncu.csie.umleditor.model;

public abstract class Shape extends Selectable implements IPaintable{
    protected int x = 0;
    protected int y = 0;
    protected int depth = 0;
    protected int portWidth = 6;

    Shape(){
        super();
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
}
