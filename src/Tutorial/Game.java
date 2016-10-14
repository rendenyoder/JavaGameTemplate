package Tutorial;

import java.awt.*;
import java.awt.image.BufferStrategy;


public class Game extends Canvas implements Runnable{
    private static final long serialVersionUID = 2342345324532452342L;
    //Create thread for game to run
    private Thread thread = new Thread();
    //Booling value to check whether game is running
    private boolean running = false;
    //Final values for screen size
    public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9;
    //Create handler for game
    private Handler handler;

    //Main function to run the game
    public static void main(String[] args){
        new Game();
    }

    //Main game function
    public Game(){
        handler = new Handler();
        this.addKeyListener(new KeyInput(handler));
        new Window(WIDTH, HEIGHT, "Build Game", this);

        //
        //Add player here
        //
    }

    //Start threads at same time
    public synchronized void start(){
        running = true;
        thread = new Thread(this);
        thread.start();
    }

    //Stop threads at the same time
    public synchronized void stop(){
        try {
            thread.join();
            running = false;
        } catch(Exception e){
            System.out.println("here");
            e.printStackTrace();
        }
    }

    //Game loop
    public void run() {
        long lastTime = System.nanoTime();
        double amountOfTicks = 60.0;
        double ns = 1000000000 / amountOfTicks;
        double delta = 0;
        long timer = System.currentTimeMillis();
        int frames = 0;

        while(running) {
            long now = System.nanoTime();
            delta += (now - lastTime) / ns;
            lastTime = now;
            while(delta >= 1) {
                tick();
                delta--;
            }
            if(running)
                render();
            frames++;

            if(System.currentTimeMillis() - timer > 1000) {
                timer += 1000;
                //System.out.println("FPS: " + frames);
                frames = 0;
            }
        }
        stop();
    }

    //Tick function
    private void tick(){
        handler.tick();
    }

    //Render function to redraw frame every second
    private void render(){
        BufferStrategy bufferStrategy = this.getBufferStrategy();
        if(bufferStrategy == null){
            this.createBufferStrategy(3);
            return;
        }

        //New graphics object
        Graphics graphics = bufferStrategy.getDrawGraphics();

        //Set background
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,WIDTH,HEIGHT);

        //Redraw frame
        handler.render(graphics);

        //Dispose of frame
        graphics.dispose();
        bufferStrategy.show();
    }
}
