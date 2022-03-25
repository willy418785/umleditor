package edu.ncu.csie.umleditor.view;
import edu.ncu.csie.umleditor.controller.*;
import edu.ncu.csie.umleditor.util.*;

import javax.swing.*;

import java.util.*;

public class Menu extends JMenuBar{
    // kept all JMenu instance in an EnumMap
    private Map<MenuType, JMenu> MenuMap = new EnumMap<MenuType, JMenu>(MenuType.class);

    public Menu(JFrame parentFrame, JPanel canvas){
        super();
        for(MenuType type : MenuType.values()) {
            // for all types of sub-menu, instantiate an JMenu obj. and put it in EnumMap.
            JMenu menu = new JMenu(type.getName());
            MenuMap.put(type, menu);
            switch (type){
                case EDIT:
                for(EditType editType : EditType.values()) {
                    // for all options in a given sub-menu, instantiate an JMenuItem obj. and add corresponding event listener
                    JMenuItem menuItem = new JMenuItem(editType.getName());
                    menu.add(menuItem);
                    menuItem.addActionListener(new EditMenuHandler(parentFrame, editType, canvas));
                }
                break;
            }
            add(menu);
        }
    }
}

