/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.game;

import java.awt.event.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class KeyHandler implements KeyListener
{
    private boolean north;
    private boolean south;
    private boolean west;
    private boolean east;
    
    @Override
    public void keyTyped(KeyEvent e)
    {
        /* Unused, but it needed to be implemented. */
    }

    @Override
    public void keyPressed(KeyEvent e)
    {
        int code = e.getKeyCode();
        
        switch (code)
        {
            case KeyEvent.VK_W -> 
            {
                north = true;
            }
            case KeyEvent.VK_S ->
            {
                south = true;
            }
            case KeyEvent.VK_A ->
            {
                west = true;
            }
            case KeyEvent.VK_D ->
            {
                east = true;
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e)
    {
        int code = e.getKeyCode();
        
        switch (code)
        {
            case KeyEvent.VK_W -> 
            {
                north = false;
            }
            case KeyEvent.VK_S ->
            {
                south = false;
            }
            case KeyEvent.VK_A ->
            {
                west = false;
            }
            case KeyEvent.VK_D ->
            {
                east = false;
            }
        }
    }
    
    public boolean northIsPressed()
    {
        return north;
    }
    
    public boolean southIsPressed()
    {
        return south;
    }
    
    public boolean westIsPressed()
    {
        return west;
    }
    
    public boolean eastIsPressed()
    {
        return east;
    }
}
