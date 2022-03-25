package edu.ncu.csie.umleditor;
import edu.ncu.csie.umleditor.model.*;
import edu.ncu.csie.umleditor.util.ButtonState;
import edu.ncu.csie.umleditor.view.*;
import javax.swing.SwingUtilities;
import java.util.*;
public final class App {

    // all living data are kept in App as global variables
    public static List<BasicObject> objs = new ArrayList<BasicObject>();
    public static List<Composition> compositions = new ArrayList<Composition>();
    public static List<Line> lines = new ArrayList<Line>();
    public static ButtonState appState = ButtonState.SELECT;

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
