package edu.ncu.csie.umleditor.view;
import edu.ncu.csie.umleditor.controller.*;
import edu.ncu.csie.umleditor.util.*;

import javax.swing.*;

public class Menu extends JMenuBar{
    public Menu(JFrame parentFrame, Canvas canvas){
        super();
        for(MenuType type : MenuType.values()) {
            // for all types of sub-menu, instantiate an JMenu obj. and put it in EnumMap.
            JMenu menu = new JMenu(type.getName());
            switch (type){
                case EDIT:
                for(EditType editType : EditType.values()) {
                    // for all options in a given sub-menu, instantiate an JMenuItem obj. and add corresponding event listener
                    JMenuItem menuItem = new JMenuItem(editType.getName());
                    menu.add(menuItem);
                    switch(editType){
                        case RENAME:
                        menuItem.addActionListener(new RenameHandler(parentFrame, canvas));
                        break;
                        case GROUP:
                        menuItem.addActionListener(new GroupHandler(canvas));
                        break;
                        case UNGROUP:
                        menuItem.addActionListener(new UngroupHandler(canvas));
                        break;
                        default:
                        System.out.println("W: undefined menu behavior");
                        break;
                    }
                    
                }
                break;
            }
            add(menu);
        }
    }
}

