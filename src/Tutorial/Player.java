package Tutorial;

import java.awt.*;

public class Player extends GameObject{

    //Player constructor
    public Player(int x, int y, String imagePath, int width, int height, ID id){
        super(x,y,imagePath,width,height,id);
    }

    //Changes to player overtime
    public void tick(){
        x += velX;
        y += velY;
        clamp();
    }

    //Render player graphics
    public void render(Graphics graphics) {
        graphics.setColor(Color.CYAN);
        graphics.fillRect(x, y, width, height);
        //graphics.drawImage(characterImage, x, y, width, height, null);
    }

    //Keeps player within given bounds
    public void clamp(){
        if(Game.window.getWindowWidth()-width <= getX())
            setX(Game.window.getWindowWidth()-width);
        else if(getX() <= 0)
            setX(0);

        if(Game.window.getWindowHeight()-(height+20) <= getY())
            setY(Game.window.getWindowHeight()-(height+20));
        else if(getY() <= 0)
            setY(0);
    }
}
