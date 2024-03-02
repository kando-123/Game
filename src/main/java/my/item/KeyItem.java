/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.item;

import java.io.*;
import javax.imageio.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class KeyItem extends Item
{
    public KeyItem()
    {
        name = "Key";
        try
        {
            image = ImageIO.read(getClass().getResourceAsStream("/items/key.png"));
        }
        catch(IOException e)
        {
            
        }
    }
}
