package edu.ncu.csie.umleditor.view;
import java.awt.Dimension;
import javax.swing.*;

public class UI{
    private JFrame window;
    private JPanel toolBar;
    private JPanel canvas;
    private JMenuBar menu;
    public UI(String windowName){
        window = new JFrame();

        canvas = new Canvas();

        toolBar = new ToolBar();

        menu = new Menu(window, canvas);
        
        window.getContentPane().setLayout(new BoxLayout(this.window.getContentPane(), BoxLayout.X_AXIS));
        window.getContentPane().setPreferredSize(new Dimension(800, 600));
        window.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
        window.getContentPane().add(toolBar);
        window.getContentPane().add(Box.createRigidArea(new Dimension(10,0)));
        window.getContentPane().add(canvas);
        window.setJMenuBar(menu);
        window.setTitle(windowName);
    }

    public void show(){
        window.pack();
        window.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        window.setVisible(true);
    }
}