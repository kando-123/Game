/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.entity;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.*;
import my.game.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Player extends Entity
{
    private GamePanel gamePanel;
    private KeyHandler keyHandler;
    
    private int northernBoundary;
    private int southernBoundary;
    private int westernBoundary;
    private int easternBoundary;
    
    private int stepCounter;
    private int imageIndex;
    
    public Player(GamePanel panel, KeyHandler handler)
    {
        gamePanel = panel;
        keyHandler = handler;
        
        setDefaultValues();
        loadPlayerImages();
    }
    
    public void setDefaultValues()
    {
        xCoord = 256;
        yCoord = 128;
        speed = 4;
        
        northernBoundary = Integer.MIN_VALUE;
        southernBoundary = Integer.MAX_VALUE;
        westernBoundary = Integer.MIN_VALUE;
        easternBoundary = Integer.MAX_VALUE;
        
        direction = Direction.SOUTH;
    }
    
    public void loadPlayerImages()
    {
        try
        {   
            northward1 = ImageIO.read(getClass().getResourceAsStream("/player/north 1.png"));
            northward2 = ImageIO.read(getClass().getResourceAsStream("/player/north 2.png"));
            southward1 = ImageIO.read(getClass().getResourceAsStream("/player/south 1.png"));
            southward2 = ImageIO.read(getClass().getResourceAsStream("/player/south 2.png"));
            westward1 = ImageIO.read(getClass().getResourceAsStream("/player/west 1.png"));
            westward2 = ImageIO.read(getClass().getResourceAsStream("/player/west 2.png"));
            eastward1 = ImageIO.read(getClass().getResourceAsStream("/player/east 1.png"));
            eastward2 = ImageIO.read(getClass().getResourceAsStream("/player/east 2.png"));
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }
    
    public void setBoundaries(int northern, int southern, int western, int eastern)
    {
        if (northern < southern)
        {    
            northernBoundary = northern;
            southernBoundary = southern;
        }
        else
        {
            northernBoundary = southern;
            southernBoundary = northern;
        }
        if (western < eastern)
        {
            westernBoundary = western;
            easternBoundary = eastern;
        }
        else
        {
            westernBoundary = eastern;
            easternBoundary = western;
        }
    }
    
    public void update()
    {
        if (keyHandler.northIsPressed() || keyHandler.southIsPressed() ||
                keyHandler.westIsPressed() || keyHandler.eastIsPressed())
        {
            ++stepCounter;
            if (stepCounter % 12 == 0)
            {
                imageIndex = imageIndex == 0 ? 1 : 0;
            }
        }
        
        if (keyHandler.northIsPressed())
        {
            direction = Direction.NORTH;
            yCoord = Math.max(yCoord - speed, northernBoundary);
        }
        if (keyHandler.southIsPressed())
        {
            direction = Direction.SOUTH;
            yCoord = Math.min(yCoord + speed, southernBoundary);
        }
        if (keyHandler.westIsPressed())
        {
            direction = Direction.WEST;
            xCoord = Math.max(xCoord - speed, westernBoundary);
        }
        if (keyHandler.eastIsPressed())
        {
            direction = Direction.EAST;
            xCoord = Math.min(xCoord + speed, easternBoundary);
        }
    }
    
    public void draw(Graphics2D graphics2D)
    {        
        BufferedImage image = null;
        switch (direction)
        {
            case NORTH ->
            {
                image = imageIndex == 0 ? northward1 : northward2;
            }
            case SOUTH ->
            {
                image = imageIndex == 0 ? southward1 : southward2;
            }
            case WEST ->
            {
                image = imageIndex == 0 ? westward1 : westward2;
            }
            case EAST ->
            {
                image = imageIndex == 0 ? eastward1 : eastward2;
            }
        }
        graphics2D.drawImage(image, xCoord, yCoord, gamePanel.tileSize, gamePanel.tileSize, null);
    }
}
