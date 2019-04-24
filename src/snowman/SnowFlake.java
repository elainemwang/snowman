package snowman;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

//extend the AbstractShape class to make a FancySnowFlake class
public class SnowFlake extends AbstractShape{
    public SnowFlake(int x, int y, int w, int h )
   {
		super(x, y, w, h, Color.WHITE, 2, 2);
   }
    public SnowFlake(int x, int y, int w, int h,int xs, int ys )
   {
		super(x, y, w, h, Color.WHITE, xs, ys);
   }
   public void draw(Graphics window)
   {
       //add code here to make a snowflake 
       window.fillRect(getXPos(),getYPos(),getWidth(),getHeight());
       
   }

   public void moveAndDraw(Graphics window)
   {
      if(getYPos()<600){
        setYPos(getYPos()+getYSpeed());
      }
      else{
          setXPos((int)(Math.random()*800));
          setYPos(0);
      }
      draw(window);   
   }
}


