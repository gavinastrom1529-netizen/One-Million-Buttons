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
    private Button[][] roomButtons;
    public GameWorld()
    {    
        super(1000, 600, 1); 
        roomManager = new RoomManager();
        roomButtons = new Button[roomManager.getNumberOfRooms()][];
        RoomMenuIcon icon = new RoomMenuIcon();
        addObject(icon, 970, 30);
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        setPaintOrder(RoomMenuIcon.class, RoomEntry.class, RoomMenu.class, Button.class);
        loadRoom(roomManager.getRoom(0));
    }
    public RoomManager getRoomManager()
    {
        return roomManager;
    }
    public void loadRoom(RoomData room)
    {
        if(room == null || !room.isUnlocked())
        {
            System.out.println("Not available");
            return;
        }

        // Find this room's index in the manager's list.
        int nextRoomIndex = -1;
        for(int i = 0; i < roomManager.getNumberOfRooms(); i++)
        {
            if(roomManager.getRoom(i) == room)
            {
                nextRoomIndex = i;
                break;
            }
        }
        if(nextRoomIndex == -1)
        {
            return;
        }

        closeRoomMenu();
        removeObjects(getObjects(Button.class));
        currentRoomIndex = nextRoomIndex;

        // Create each room's buttons once, then reuse them on later visits.
        if(roomButtons[currentRoomIndex] == null)
        {
            roomButtons[currentRoomIndex] = new Button[room.getTotalButtons()];
            for(int i = 0; i < room.getTotalButtons(); i++)
            {
                roomButtons[currentRoomIndex][i] = new Button(room);
            }
        }

        Button[] buttons = roomButtons[currentRoomIndex];
        for(int i = 0; i < buttons.length; i++)
        {
            // 50 columns; the largest current room has 40 rows.
            int x = 10 + (i % 50) * 20;
            int y = 80 + (i / 50) * 12;
            addObject(buttons[i], x, y);
        }
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
            showText("", getWidth()/2, 100);
            showText("", getWidth()/2, 130);
            showText("", getWidth()/2, 160);
        }
    }
    public boolean isRoomMenuOpen()
    {
        return roomMenu != null;
    }
    public void act()
    {
        roomManager.completeRoom(currentRoomIndex);
    }
}
