import java.util.ArrayList;

/**
 * Write a description of class RoomManager here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomManager  
{
    private ArrayList<RoomData> rooms;

    /**
     * Constructor for objects of class RoomManager
     */
    public RoomManager()
    {
        rooms = new ArrayList<RoomData>();
        
        rooms.add(new RoomData(1, 1000, true));
        rooms.add(new RoomData(2, 1500, false));
        rooms.add(new RoomData(3, 1200, false));
        rooms.add(new RoomData(4, 2000, false));
    }
    public RoomData getRoom(int index)
    {
        return rooms.get(index);
    }
    public int getNumberOfRooms()
    {
        return rooms.size();
    }
    public void completeRoom(int index)
    {
    RoomData room = rooms.get(index);

    if(room.getButtonsClicked() == room.getTotalButtons())
    {
        room.complete();

        if(index + 1 < rooms.size())
        {
            rooms.get(index + 1).unlock();
        }
    }
    }
    /**
     * An example of a method - replace this comment with your own
     * 
     * @param  y   a sample parameter for a method
     * @return     the sum of x and y 
     */
    public int sampleMethod()
    {
        return -1;
    }
}
