package Tutorial;

import java.awt.*;
import java.util.LinkedList;

public class Handler {
    LinkedList<GameObject> gameObjects = new LinkedList<GameObject>();

    //Tick function to change object variables
    public void tick(){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = gameObjects.get(i);
            tempObject.tick();
        }
    }

    //Render grpahic
    public void render(Graphics graphics){
        for(int i = 0; i < gameObjects.size(); i++){
            GameObject tempObject = gameObjects.get(i);
            tempObject.render(graphics);
        }
    }

    //Add game object to list
    public void addObject(GameObject object){
        this.gameObjects.add(object);
    }

    //Remove game object from list
    public void removeObject(GameObject object){
        this.gameObjects.remove(object);
    }
}
