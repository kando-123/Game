/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package my.game;

import my.entity.Entity;
import my.tile.TileType;

/**
 *
 * @author Kay Jay O'Nail
 */
public class CollisionChecker
{
    private GamePanel panel;
    
    public CollisionChecker(GamePanel panel)
    {
        this.panel = panel;
    }
    
    public void checkTile(Entity entity)
    {
        int entityLeftWorldX = entity.getWorldX() + entity.getSolidArea().x;
        int entityRightWorldX = entityLeftWorldX + entity.getSolidArea().width;
        int entityTopWorldY = entity.getWorldY() + entity.getSolidArea().y;
        int entityBottomWorldY = entityTopWorldY + entity.getSolidArea().height;
        
        int entityLeftCol = entityLeftWorldX / panel.tileSize;
        int entityRightCol = entityRightWorldX / panel.tileSize;
        int entityTopRow = entityTopWorldY / panel.tileSize;
        int entityBottomRow = entityBottomWorldY / panel.tileSize;
        
        TileType oneTile, anotherTile;
        
        switch (entity.getDirection())
        {
            case NORTH ->
            {
                entityTopRow = (entityTopWorldY - entity.getSpeed()) / panel.tileSize;
                oneTile = panel.tileManager.getTileType(entityLeftCol, entityTopRow);
                anotherTile = panel.tileManager.getTileType(entityRightCol, entityTopRow);
                if (oneTile.isSolid() || anotherTile.isSolid())
                {
                    entity.setCollision(true);
                }
            }
            case SOUTH ->
            {
                entityBottomRow = (entityBottomWorldY + entity.getSpeed()) / panel.tileSize;
                oneTile = panel.tileManager.getTileType(entityLeftCol, entityBottomRow);
                anotherTile = panel.tileManager.getTileType(entityRightCol, entityBottomRow);
                if (oneTile.isSolid() || anotherTile.isSolid())
                {
                    entity.setCollision(true);
                }
            }
            case WEST ->
            {
                entityLeftCol = (entityLeftWorldX - entity.getSpeed()) / panel.tileSize;
                oneTile = panel.tileManager.getTileType(entityLeftCol, entityTopRow);
                anotherTile = panel.tileManager.getTileType(entityLeftCol, entityTopRow);
                if (oneTile.isSolid() || anotherTile.isSolid())
                {
                    entity.setCollision(true);
                }
            }
            case EAST ->
            {
                entityRightCol = (entityRightWorldX + entity.getSpeed()) / panel.tileSize;
                oneTile = panel.tileManager.getTileType(entityRightCol, entityTopRow);
                anotherTile = panel.tileManager.getTileType(entityRightCol, entityTopRow);
                if (oneTile.isSolid() || anotherTile.isSolid())
                {
                    entity.setCollision(true);
                }
            }
        }
    }
}
