package edu.ncu.csie.umleditor.model;
import java.awt.Graphics;

public interface IPaintable {
    public abstract void paint(Graphics g);
    public abstract void paintPorts(Graphics g);
    public abstract void paintHead(Graphics g);
}
