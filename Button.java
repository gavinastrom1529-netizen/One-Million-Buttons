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
    public Button()
    {
        GreenfootImage image = new GreenfootImage(10,10);
        image.setColor(Color.GRAY);
        image.fill();
        setImage(image);
    }
    public Button(RoomData room)
    {
        this.room = room;
        clicked = false;
    }
    public void act()
    {
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
