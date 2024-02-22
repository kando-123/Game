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
    private final GamePanel gamePanel;
    private final Map<TileType, Tile> tiles;
    TileType layout[][];

    public TileManager(GamePanel panel)
    {
        gamePanel = panel;
        tiles = new HashMap<>();
        layout = new TileType[panel.maxScreenCol][panel.maxScreenRow];

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

            for (int row = 0; row < gamePanel.maxScreenRow; ++row)
            {
                String line = reader.readLine();
                String words[] = line.split(" ");
                assert (words.length == gamePanel.maxScreenCol);
                for (int col = 0; col < gamePanel.maxScreenCol; ++col)
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
        int tileSize = gamePanel.tileSize;
        for (int col = 0, x = 0; col < gamePanel.maxScreenCol; ++col, x += tileSize)
        {
            for (int row = 0, y = 0; row < gamePanel.maxScreenRow; ++row, y += tileSize)
            {
                graphics2D.drawImage(tiles.get(layout[col][row]).image,
                        x, y, tileSize, tileSize, null);
            }
        }
    }
}
