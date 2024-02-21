/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package my.game;

import javax.swing.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class Game
{
    public static void main(String[] args)
    {
        /* Frame Creation */
        
        JFrame window = new JFrame();
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setResizable(false);
        window.setTitle("Medio. The Mediocre Adventure");
        
        GamePanel gamePanel = new GamePanel();
        window.add(gamePanel);
        window.pack();
        
        window.setLocationRelativeTo(null);
        window.setVisible(true);
        
        /* Other Stuff */
        gamePanel.startGameThread();
    }
}
