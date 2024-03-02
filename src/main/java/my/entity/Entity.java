/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.entity;

import java.awt.Rectangle;
import java.awt.image.BufferedImage;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Entity
{
    protected int worldX;
    protected int worldY;
    protected int speed;
    
    protected Direction direction;
    protected BufferedImage northward1, northward2;
    protected BufferedImage southward1, southward2;
    protected BufferedImage westward1, westward2;
    protected BufferedImage eastward1, eastward2;
    
    protected Rectangle solidArea;
    protected boolean collisionOn;
    
    public int getWorldX()
    {
        return worldX;
    }
    
    public int getWorldY()
    {
        return worldY;
    }
    
    public int getSpeed()
    {
        return speed;
    }
    
    public Direction getDirection()
    {
        return direction;
    }
    
    public Rectangle getSolidArea()
    {
        return solidArea;
    }
    
    public void setCollision(boolean isColliding)
    {
        collisionOn = isColliding;
    }
}
