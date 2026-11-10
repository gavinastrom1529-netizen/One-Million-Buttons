import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoomMenuIcon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomMenuIcon extends Actor
{
    public RoomMenuIcon()
    {
        GreenfootImage image = new GreenfootImage(40, 40);
        image.setColor(Color.GRAY);
        image.fill();
        
        image.setColor(Color.WHITE);
        image.drawString("R", 15, 25);
        
        setImage(image);
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            GameWorld game = (GameWorld) getWorld();
            if(game.isRoomMenuOpen())
            {
                game.closeRoomMenu();
            }
            else
            {
                game.openRoomMenu();
            }
        }
    }
}
