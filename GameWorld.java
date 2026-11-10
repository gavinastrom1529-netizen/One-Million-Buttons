import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameWorld extends World
{
    private int currentRoomIndex = 0;
    private RoomManager roomManager;
    private RoomMenu roomMenu;
    public GameWorld()
    {    
        super(1000, 600, 1); 
        roomManager = new RoomManager();
        RoomData startingRoom = roomManager.getRoom(0);
        RoomMenuIcon icon = new RoomMenuIcon();
        addObject(icon, 970, 30);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        for(int i = 0; i < 10; i++)
        {
            for(int j = 0; j < 10; j++)
            {
                Button button = new Button(startingRoom);
                
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
        if(!room.isUnlocked())
        {
            System.out.println("Not available");
        }
        closeRoomMenu();
        
    }
    public void openRoomMenu()
    {
        if(roomMenu == null)
        {
            roomMenu = new RoomMenu(roomManager);
            addObject(roomMenu, 200, 300);
            roomMenu.refreshList();
        }
    }
    public void closeRoomMenu()
    {
        if(roomMenu != null)
        {
            removeObjects(getObjects(RoomEntry.class));
            removeObject(roomMenu);
            roomMenu = null;
        }
    }
    public void enterRoom()
    {
        GameWorld game = (GameWorld) getWorld();
        game.loadRoom(room);
    }
    public void act()
    {
        roomManager.completeRoom(currentRoomIndex);
    }
}
