import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartButton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartButton extends Actor
{
    // GitHub connection test// GitHub connection test
    private GreenfootImage buttonImage;
    private int framesRemaining = -1;
    private int fade = 255;
    public StartButton()
    {
        fade = 255;
        framesRemaining = -1;
        drawButton(Color.GRAY, fade);

    }
    public void drawButton(Color color, int alpha)
    {
        GreenfootImage image = new GreenfootImage(160, 60);
        
        image.setColor(new Color(color.getRed(), color.getGreen(),color.getBlue(), alpha));

        image.fill();
        GreenfootImage text = new GreenfootImage("START", 28, new Color(255, 255, 255, alpha), new Color(0, 0, 0, 0));
        
        int textX = image.getWidth()/2 - text.getWidth() /2;
        int textY = image.getHeight()/2 - text.getHeight()/2;

        image.drawImage(text, textX, textY);

        setImage(image);
    }
    public GreenfootImage getButtonImage()
    {
        return buttonImage;
    }
    public void act()
    {
        if(Greenfoot.mouseClicked(this)&&framesRemaining == -1)
        {
            framesRemaining = 50;
        }
        if(framesRemaining > 0)
        {
            framesRemaining --;
            fade -= 5;
            if(fade < 0)
            {
                fade = 0;
            }
            drawButton(Color.MAGENTA, fade);
            
            TitleWorld world = (TitleWorld) getWorld();
            
            if (world != null)
            {
                world.redrawMenu(fade);
            }
        }

        if (framesRemaining == 0)
        {
            Greenfoot.setWorld(new GameWorld());
        }
    }
}
