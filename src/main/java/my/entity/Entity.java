/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.entity;

import java.awt.image.BufferedImage;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Entity
{
    protected int xCoord;
    protected int yCoord;
    protected int speed;
    
    protected Direction direction;
    protected BufferedImage northward1, northward2;
    protected BufferedImage southward1, southward2;
    protected BufferedImage westward1, westward2;
    protected BufferedImage eastward1, eastward2;
    
}
