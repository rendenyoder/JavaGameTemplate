package Tutorial;
import java.awt.*;
import javax.swing.*;

public class Window  extends Canvas{
    //Unique ID
    private static final long serialVersionUID = -2342345324532452342L;

    //Create window
    public Window(int width, int height, String title, Game game){
        //Window Title
        JFrame frame = new JFrame(title);
        //Set window preferences
        frame.setPreferredSize(new Dimension(width, height));
        frame.setMaximumSize(new Dimension(width, height));
        frame.setMinimumSize(new Dimension(width, height));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.add(game);
        frame.setVisible(true);
        //Start game
        game.start();
    }
}
