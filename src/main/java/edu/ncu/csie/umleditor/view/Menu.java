package edu.ncu.csie.umleditor.view;
import edu.ncu.csie.umleditor.controller.*;
import edu.ncu.csie.umleditor.util.*;

import javax.swing.*;

public class Menu extends JMenuBar{
    public Menu(JFrame parentFrame, Canvas canvas){
        super();
        for(MenuType type : MenuType.values()) {
            // for all types of sub-menu, instantiate an JMenu obj. and put it in EnumMap.
            JMenu menu = new MenuFactory(parentFrame, canvas).createMenu(type);
            add(menu);
        }
    }
}

