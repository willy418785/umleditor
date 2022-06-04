package edu.ncu.csie.umleditor.controller;

import javax.swing.*;

import edu.ncu.csie.umleditor.util.*;
import edu.ncu.csie.umleditor.view.*;

public class MenuFactory {
    JFrame parentFrame;
    Canvas canvas;
    public MenuFactory(JFrame frame, Canvas canvas){
        parentFrame = frame;
        this.canvas = canvas;
    }
    public JMenu createMenu(MenuType type){
        JMenu menu = new JMenu(type.getName());
        switch (type){
            case EDIT:
            for (EditType editType : EditType.values()) {
                JMenuItem menuItem = new JMenuItem(editType.getName());
                menu.add(menuItem);
                menuItem.addActionListener(new EditHandlerFactory(parentFrame, canvas).createEditHandler(editType));
            }
            break;
            default:
            break;
        }
        return menu;
    }
}
