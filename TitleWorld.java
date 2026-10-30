import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TitleWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TitleWorld extends World
{
    private int textFade = 255;
    public TitleWorld()
    {    
        super(1000, 600, 1); 
        
        GreenfootImage bg = getBackground();
        bg.setColor(Color.BLACK);
        bg.fill();
        
        bg.setColor(Color.WHITE);
        
        Font titleFont = new Font("Comic Sans MS", true, false, 50);
        Font subtitleFont = new Font("Comic Sans MS", true, false, 24);
        
        String titleText = "ONE MILLION BUTTONS";
        GreenfootImage titleImg = new GreenfootImage(titleText, 50, Color.WHITE, new Color(0, 0, 0, 0)); 
        
        int titleX = getWidth()/2 - titleImg.getWidth()/2;
        
        bg.setFont(titleFont);
        bg.drawString(titleText, titleX, 175);
        
        String subtitleText = "Press START to begin...";
        GreenfootImage subtitleImg = new GreenfootImage(subtitleText, 24, Color.WHITE, new Color(0, 0, 0, 0));
        int subtitleX = getWidth()/2 - subtitleImg.getWidth()/2;
        
        bg.setFont(subtitleFont);
        bg.drawString(subtitleText, subtitleX, 275);
        
        StartButton start = new StartButton();
        addObject(start, getWidth()/2, 300);
        
    }
    public void redrawMenu(int fadeAmount)
    {
        textFade = fadeAmount;
        
        GreenfootImage bg = getBackground();
        
        getBackground().setColor(Color.BLACK);
        getBackground().fill();
        
        Color fadedWhite = new Color(255, 255, 255, textFade);
        bg.setColor(fadedWhite);
        
        String titleText = "ONE MILLION BUTTONS";
        String subtitleText = "Press START to begin...";
        
        GreenfootImage titleImg = new GreenfootImage(titleText, 50, fadedWhite, new Color(0,0,0,0));
        GreenfootImage subtitleImg = new GreenfootImage(subtitleText, 24, fadedWhite, new Color(0,0,0,0));
        
        int titleX = getWidth() / 2 - titleImg.getWidth() / 2;

        int subtitleX = getWidth() / 2 - subtitleImg.getWidth() / 2;

        bg.setFont(new Font("Comic Sans MS", true, false, 50));
        
        bg.drawString(titleText, titleX, 175);
        bg.setFont(new Font("Comic Sans MS", true, false, 24));
        bg.drawString(subtitleText, subtitleX, 275);
    }
}
