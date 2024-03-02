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
    LAND("/tiles/land.png", "LAN", false),
    WATER("/tiles/water.png", "WAT", true),
    WALL("/tiles/wall.png", "WAL", true),
    
    EARTH("/tiles/earth.png", "EAR", false),
    SAND("/tiles/sand.png", "SAN", false),
    TREE("/tiles/tree.png", "TRE", true);
    
    private final String path;
    private final String abbreviation;
    private final boolean solid;
    
    private TileType(String path, String abbreviation, boolean solid)
    {
        this.path = path;
        this.abbreviation = abbreviation;
        this.solid = solid;
    }
    
    public String getPath()
    {
        return path;
    }
    
    public boolean isSolid()
    {
        return solid;
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
