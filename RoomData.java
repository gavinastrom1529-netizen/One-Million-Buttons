/**
 * Write a description of class RoomData here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RoomData  
{
    // instance variables - replace the example below with your own
    private int roomNumber;
    private int buttonsClicked;
    private int totalButtons;
    private boolean unlocked;
    private boolean completed;

    /**
     * Constructor for objects of class RoomData
     */
    public RoomData(int number, int total, boolean isUnlocked)
    {
        roomNumber = number;
        buttonsClicked = 0;
        totalButtons = total;
        unlocked = isUnlocked;
        completed = false;
    }
    public int getRoomNumber()
    {
        return roomNumber;
    }
    public int getButtonsClicked()
    {
        return buttonsClicked;
    }
    public int getTotalButtons()
    {
        return totalButtons;
    }
    public boolean isUnlocked()
    {
        return unlocked;
    }
    public boolean isCompleted()
    {
        return completed;
    }
    public void addButtonClick()
    {
        buttonsClicked++;
    }
    public void unlock()
    {
        unlocked = true;
    }
    public void complete()
    {
        completed = true;
    }
}
