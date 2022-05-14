package edu.ncu.csie.umleditor;
import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.ButtonState;
import edu.ncu.csie.umleditor.view.*;
import javax.swing.SwingUtilities;
import java.util.*;
public final class App {

    
    private App() {

    }
    public static void main(String[] args) {
        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                
                // create UI and execute program
                UI ui = new UI("UML Editor");
                ui.show();
            }
        });
        
    }
}
