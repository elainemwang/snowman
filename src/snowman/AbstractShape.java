package snowman;

//(c) A+ Computer Science
//www.apluscompsci.com
//Name -

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Polygon;

public abstract class AbstractShape
{
   //instance variables
	private int xPos;
	private int yPos;

	private int width;
	private int height;

	private Color color;

	private int xSpeed;
	private int ySpeed;

   public AbstractShape(int x, int y, int wid, int ht)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = Color.WHITE;
		xSpeed = 0;
		ySpeed= 0;
   }
   
   public AbstractShape(int x, int y, int wid, int ht, Color col)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		xSpeed = 0;
		ySpeed= 0;
   }   
   
   public AbstractShape(int x, int y, int wid, int ht, Color col, int xSpd, int ySpd)
   {
		xPos = x;
		yPos = y;
		width = wid;
		height = ht;
		color = col;
		xSpeed = xSpd;
		ySpeed= ySpd;
   }  
  
   //add in set and get methods for pos and speed
   public void setXPos( int xp)
   {
   	xPos = xp;
   }
   
   public void setYPos( int yp)
   {
   	yPos = yp;
   }
   
   public void setXSpeed( int xs)
   {
   	xSpeed = xs;
   }
   
   public void setYSpeed(int ys)
   {
   	ySpeed = ys;
   }
   
   public int getYSpeed()
   {
   	return ySpeed;
   }
   
   public int getXSpeed()
   {
   	return xSpeed;
   }
   
   public int getXPos()
   {
   	return xPos;
   }
   
   public int getYPos()
   {
   	return yPos;
   }
   
   public Color getColor()
   {
   	return color;
   }
   
   public int getWidth()
   {
   	return width;
   }
   
   public int getHeight()
   {
   	return height;
   }

   public abstract void draw(Graphics window);

   public abstract void moveAndDraw(Graphics window);

   public String toString()
   {
   	return xPos+" "+yPos+" "+width+" "+height+" "+color+" "+xSpeed+" "+ySpeed;
   }

    //extend the AbstractShape class to make a FancySnowFlake class
    public static class FancySnowFlake extends AbstractShape {

        public FancySnowFlake(int x, int y, int w, int h) {
            super(x, y, w, h, Color.WHITE, 0, 2);
        }

        public void draw(Graphics window) {
            window.setColor(getColor());
            int x = getXPos();
            int y = getYPos();
            int w = getWidth();
            int h = getHeight();
            int hw = w / 2;
            int hh = h / 2;
            int hhe = (int) Math.ceil(hh * 0.125);
            int hhq = (int) Math.ceil(hh * 0.35);
            int hhh = (int) Math.ceil(hh * 0.7);
            int hwe = (int) Math.ceil(hw * 0.125);
            int hwq = (int) Math.ceil(hw * 0.35);
            int hwh = (int) Math.ceil(hw * 0.7);
            int[] xPoints = {x + hwh, x + hwq, x + hwe, x, x + hwe, x + hwq, x + hwh, x + hw / 2, x + hw, x + w - hw / 2, x + w - hwh, x + w - hwq, x + w - hwe, x + w, x + w - hwe, x + w - hwq, x + w - hwh, x + hw + hwq, x + hw, x + hw - hwq};
            int[] yPoints = {y + hh - hhe, y + hh - hhq, y + hh - hhe / 2, y + hh, y + hh + hhe / 2, y + hh + hhq, y + hh + hhe, y + h - hwq, y + h, y + h - hwq, y + hh + hhe, y + hh + hhq, y + hh + hhe / 2, y + hh, y + hh - hhe / 2, y + hh - hhq, y + hh - hhe / 2, y + hwq, y, y + hwq};
            int nPoints = 20;
            Polygon triangle = new Polygon(xPoints, yPoints, nPoints);
            window.drawPolygon(triangle);
        }

        public void moveAndDraw(Graphics window) {
            //draw(window,Color.BLUE);
            int offset = (int) (Math.random() * 4);
            int rnd = (int) (Math.random() * 2);
            if (rnd == 1) {
                offset = offset * -1;
            }
            setXPos(getXPos() + offset);
            setYPos(getYPos() + getYSpeed());
            draw(window);
        }
    }
}