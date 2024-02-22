/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package my.tile;

import java.util.*;

/**
 *
 * @author Kay Jay O'Nail
 */
public enum TileType
{
    LAND("/tiles/land.png", "LAN"),
    WATER("/tiles/water.png", "WAT"),
    WALL("/tiles/wall.png", "WAL");
    
    private final String path;
    private final String abbreviation;
    
    private TileType(String path, String abbreviation)
    {
        this.path = path;
        this.abbreviation = abbreviation;
    }
    
    public String getPath()
    {
        return path;
    }
    
    private static Map<String, TileType> decoder = null;
    
    public static TileType decodeAbbreviation(String abbreviation)
    {
        if (decoder == null)
        {
            decoder = new HashMap<>();
            for (var type : values())
            {
                decoder.put(type.abbreviation, type);
            }
        }
        return decoder.get(abbreviation);
    }
}
