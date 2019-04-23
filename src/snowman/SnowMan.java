package snowman;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public class SnowMan extends AbstractShape
{
   public SnowMan(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 0, 0);
   }

   public void draw(Graphics window)
   {
       //add code here to make a snowman 
       
       window.fillOval(getXPos()-getWidth()/2, getYPos(), getWidth(), getHeight());
       window.fillOval(getXPos()-getWidth(), getYPos()+getHeight()-2, getWidth()*(2), getHeight()*(2));
       window.fillOval(getXPos()-getWidth()*2, getYPos()+getHeight()*(3)-4, getWidth()*4, getHeight()*4);
   }

   public void moveAndDraw(Graphics window)
   {
      draw(window);   
   }
}