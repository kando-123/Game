/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.tile;

import java.awt.*;
import java.io.*;
import java.util.*;
import javax.imageio.ImageIO;
import my.game.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public class TileManager
{
    private final GamePanel panel;
    private final Map<TileType, Tile> tiles;
    TileType layout[][];

    public TileManager(GamePanel gamePanel)
    {
        panel = gamePanel;
        tiles = new HashMap<>();
        layout = new TileType[panel.maxWorldCol][panel.maxWorldRow];

        loadTileImages();
        loadMap("/maps/map001.txt");
    }

    private void loadTileImages()
    {
        try
        {
            for (var type : TileType.values())
            {
                Tile tile = new Tile();
                InputStream stream = getClass().getResourceAsStream(type.getPath());
                tile.image = ImageIO.read(stream);
                tiles.put(type, tile);
            }
        }
        catch (IOException e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void loadMap(String mapPath)
    {
        try
        {
            InputStream stream = getClass().getResourceAsStream(mapPath);
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream));

            for (int row = 0; row < panel.maxWorldRow; ++row)
            {
                String line = reader.readLine();
                String words[] = line.split(" ");
                assert (words.length == panel.maxScreenCol);
                for (int col = 0; col < panel.maxWorldCol; ++col)
                {
                    layout[col][row] = TileType.decodeAbbreviation(words[col]);
                }
            }
        }
        catch (Exception e)
        {
            System.err.println(e.getMessage());
        }
    }

    public void draw(Graphics2D graphics2D)
    {
        int playerX = panel.getPlayerGlobalX();
        int playerY = panel.getPlayerGlobalY();
        int minCol = Math.max((playerX - panel.screenWidth / 2) / panel.tileSize, 0);
        int minRow = Math.max((playerY - panel.screenHeight / 2) / panel.tileSize, 0);
        int maxCol = Math.min((playerX + panel.screenWidth / 2) / panel.tileSize + 2, panel.maxWorldCol);
        int maxRow = Math.min((playerY + panel.screenHeight / 2) / panel.tileSize + 2, panel.maxWorldRow);
        
        int worldCol = minCol;
        int penX = panel.getScreenCenterX() - panel.getPlayerGlobalX() + minCol * panel.tileSize;
        int minPenY = panel.getScreenCenterY() - panel.getPlayerGlobalY() + minRow * panel.tileSize;
        while (worldCol < maxCol)
        {
            int worldRow = minRow;
            int penY = minPenY;
            while (worldRow < maxRow)
            {
                graphics2D.drawImage(tiles.get(layout[worldCol][worldRow]).image,
                        penX, penY, panel.tileSize, panel.tileSize, null);
                
                ++worldRow;
                penY += panel.tileSize;
            }
            
            ++worldCol;
            penX += panel.tileSize;
        } 
    }
}
