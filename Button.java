import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Button extends Actor
{
    private RoomData room;
    private boolean clicked;
    public Button(RoomData room)
    {
        this.room = room;
        clicked = false;
        
        GreenfootImage image = new GreenfootImage(10,10);
        image.setColor(Color.GRAY);
        image.fill();
        setImage(image);
    }
    public void act()
    {
        GameWorld game = (GameWorld) getWorld();
        if(game == null || game.isRoomMenuOpen())
        {
            return;
        }

        if(Greenfoot.mouseClicked(this) && !clicked)
        {
            clicked = true;
            room.addButtonClick();
            turnPurple();
        }
    }
    public void turnPurple()
    {
        GreenfootImage image = getImage();
        image.setColor(Color.MAGENTA);
        image.fill();
    }
}
