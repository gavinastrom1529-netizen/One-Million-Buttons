import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RoomMenu here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomMenu extends Actor
{
    private RoomManager manager;
    private int firstVisibleRoom;
    private int roomsPerPage;
    public RoomMenu(RoomManager manager)
    {
        this.manager = manager;
        firstVisibleRoom = 0;
        roomsPerPage = 5;
    }
    
    public void scroll(int direction)
    {
        if(direction == 1 && firstVisibleRoom + roomsPerPage < manager.getNumberOfRooms())
        {
            firstVisibleRoom++;
        }
        else if (direction == -1 && firstVisibleRoom > 0)
        {
            firstVisibleRoom--;
        }
        refreshList();
    }
    public void refreshList()
    {
        getWorld().removeObjects(getWorld().getObjects(RoomEntry.class));
        for(int i = firstVisibleRoom; i < firstVisibleRoom + roomsPerPage && i < manager.getNumberOfRooms(); i++)
        {
            RoomData room = manager.getRoom(i);
            RoomEntry entry = new RoomEntry(room);
            int displayPosition = i - firstVisibleRoom;
            int y = 150 + 60 * displayPosition;
            
            getWorld().addObject (entry, 200, y);
        }
    }
    public int getFirstVisibleRoom()
    {
        return firstVisibleRoom;
    }
    public int getRoomsPerPage()
    {
        return roomsPerPage;
    }
}
