import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private RoomManager roomManager;
    public GameWorld()
    {    
        super(1000, 600, 1); 
        roomManager = new RoomManager();
        RoomMenuIcon icon = new RoomMenuIcon();
        addObject(icon, 970, 30);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                Button button = new Button();
                
                int x = 50*j + 100;
                int y = 300 - 25*i;
                addObject(button, x, y);
            }
        }
        
    }
    public RoomManager getRoomManager()
    {
        return roomManager;
    }
    public void loadRoom(RoomData room)
    {
        System.out.println("Entering Room #" + room.getRoomNumber());
    }
    public void openRoomMenu()
    {
        System.out.println("Opening room menu");
    }
    public void closeRoomMenu()
    {
        System.out.println("Closing room menu");
    }
}
