import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoomEntry here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomEntry extends Actor
{
    private RoomData room;
    private boolean mouseOver;
    public RoomEntry(RoomData room)
    {
        this.room = room;
        mouseOver = false;
        updateImage();
    }
    private void updateImage()
    {
        GreenfootImage image = new GreenfootImage(250, 60);
        
        image.setColor(Color.DARK_GRAY);
        image.fill();
        image.setColor(Color.WHITE);
        image.drawString("Room #" + room.getRoomNumber(), 10, 22);
        image.drawString(room.getButtonsClicked() + " / " + room.getTotalButtons(),10, 45);
        if(!room.isUnlocked())
        {
            image.drawString("LOCKED", 175, 32);
        }
        setImage(image);
    }
    public void act()
    {
        checkClick();
        checkHover();
    }
    public void checkClick()
    {
        if(Greenfoot.mouseClicked(this))
        {
            if(room.isUnlocked())
            {
                enterRoom();
            }
            else
            {
                displayLockedMessage();
            }
        }
    }
    public void enterRoom()
    {
        //Game game = (Game) getWorld();
        //game.loadRoom(room);
        System.out.println("Entering Room #" + room.getRoomNumber());
    }
    public void displayLockedMessage()
    {
        getWorld().showText("Complete pevious rooms first", getWorld().getWidth()/2, 160);
    }
    public void checkHover()
    {
        if(Greenfoot.mouseMoved(null))
        {
            boolean currentlyOn = Greenfoot.mouseMoved(this);
            
            if(currentlyOn && !mouseOver)
            {
                showRoomInfo();
            }
            else if(!currentlyOn && mouseOver)
            {
                clearRoomInfo();
            }
            mouseOver = currentlyOn;
        }
    }
    private void showRoomInfo()
    {
        getWorld().showText("Room #" + room.getRoomNumber(), getWorld().getWidth()/2, 100);
        getWorld().showText(room.getButtonsClicked() + " / " + room.getTotalButtons(), getWorld().getWidth()/2, 130);
        if(!room.isUnlocked())
        {
            getWorld().showText("Complete previoius rooms first", getWorld().getWidth()/2, 160);
        }
        else
        {
            getWorld().showText("Click to enter", getWorld().getWidth()/2, 160);
        }
    }
    private void clearRoomInfo()
    {
        getWorld().showText("", getWorld().getWidth()/2, 100);
        getWorld().showText("", getWorld().getWidth()/2, 130);
        getWorld().showText("", getWorld().getWidth()/2, 160);
    }
}
