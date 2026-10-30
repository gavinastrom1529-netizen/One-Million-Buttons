import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScrollButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScrollButton extends Actor
{
    private int direction;
    private RoomMenu menu;
    public ScrollButton(RoomMenu menu, int direction)
    {
        this.menu = menu;
        this.direction = direction;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this))
        {
            menu.scroll(direction);
        }
    }
}
