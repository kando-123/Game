/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.game;

import java.awt.*;
import javax.swing.*;
import my.entity.*;
import my.item.Item;
import my.tile.TileManager;

/**
 *
 * @author Kay Jay O'Nail
 */
public class GamePanel extends JPanel implements Runnable
{
    /* Screen Settings */
    private final int originalTileSize = 16;
    private final int scale = 3;

    public final int tileSize = originalTileSize * scale;
    public final int maxScreenCol = 16;
    public final int maxScreenRow = 12;
    public final int screenWidth = tileSize * maxScreenCol;
    public final int screenHeight = tileSize * maxScreenRow;

    /* Gameplay */
    private Thread gameThread;
    private final int fps = 60;
    private CollisionChecker collisionChecker;

    /* Input */
    private final KeyHandler keyHandler;

    /* Player */
    Player player;
    
    /* World */
    TileManager tileManager;
    public final int maxWorldCol = 49;
    public final int maxWorldRow = 49;
    public final int worldWidth = tileSize * maxWorldCol;
    public final int worldHeight = tileSize * maxWorldRow;
    
    /* Items */
    public Item[] items;

    public GamePanel()
    {
        this.setPreferredSize(new Dimension(screenWidth, screenHeight));
        this.setBackground(Color.black);
        this.setDoubleBuffered(true);

        keyHandler = new KeyHandler();
        this.addKeyListener(keyHandler);
        this.setFocusable(true);
        
        player = new Player(this, keyHandler);
//        player.setBoundaries(-tileSize / 2, screenHeight - tileSize / 2,
//                             -tileSize / 2, screenWidth - tileSize / 2);
        
        tileManager = new TileManager(this);
        collisionChecker = new CollisionChecker(this);
        
        items = new Item[10];
    }

    public void startGameThread()
    {
        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run()
    {
        long interval = (long) ((double) 1e9 / (double) fps);
        long recentTime = System.nanoTime();
        while (gameThread != null)
        {
            long currentTime = System.nanoTime();
            if (currentTime - recentTime >= interval)
            {
                /* UPDATE */
                update();

                /* RENDER */
                repaint();

                /* Reset the counter */
                recentTime = currentTime;
            }
        }
    }

    public void update()
    {
        player.update();
    }

    @Override
    public void paintComponent(Graphics graphics)
    {
        super.paintComponent(graphics);

        Graphics2D graphics2D = (Graphics2D) graphics;
        tileManager.draw(graphics2D);
        player.draw(graphics2D);
        
        graphics2D.dispose();
    }
    
    public int getPlayerGlobalX()
    {
        return player.getGlobalX();
    }
    
    public int getPlayerGlobalY()
    {
        return player.getGlobalY();
    }
    
    public int getScreenCenterX()
    {
        return player.screenX;
    }
    
    public int getScreenCenterY()
    {
        return player.screenY;
    }
    
    public CollisionChecker getCollisionChecker()
    {
        return collisionChecker;
    }
}
