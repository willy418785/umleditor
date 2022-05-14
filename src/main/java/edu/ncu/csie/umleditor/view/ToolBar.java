package edu.ncu.csie.umleditor.view;
import edu.ncu.csie.umleditor.App;
import edu.ncu.csie.umleditor.controller.*;
import edu.ncu.csie.umleditor.util.ButtonState;

import java.awt.*;
import javax.swing.*;
import java.util.*;

public class ToolBar extends JPanel{
    private Map<ButtonState, AbstractButton> buttonsMap = new EnumMap<ButtonState, AbstractButton>(ButtonState.class);  // store all button instances in a Map
    private ButtonGroup buttonsGroup;   // all buttons belong to a button group
    public ToolBar(Canvas canvas){
        super();
        // initialize style and layout of tool bar
        setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        setAlignmentY(Component.TOP_ALIGNMENT);

        buttonsGroup = new ButtonGroup();
        for(ButtonState state : ButtonState.values()) {
            // create all buttons, set their style and add event listener
            AbstractButton btn = new JToggleButton(state.getName());
            add(btn);
            add(Box.createRigidArea(new Dimension(0,10)));
            btn.setAlignmentX(Component.CENTER_ALIGNMENT);
            btn.setPreferredSize(new Dimension(150,30));
            btn.setMaximumSize(new Dimension(150,30));
            btn.addActionListener(new ButtonHandler(canvas, state));

            // add this button to Map and button group
            buttonsMap.put(state, btn);
            buttonsGroup.add(btn);
        }
    }
}

