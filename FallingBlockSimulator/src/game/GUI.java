package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.util.Timer;

import javax.swing.JPanel;

public class GUI extends JPanel
{
	private BufferedImage[][] nextPiece;
	private java.util.Timer timer;
	private boolean isRunning;
	
	GUI()
	{
		isRunning = true;
		gameLoop();
	}
	
	public void setNextPiece(BufferedImage[][] imgArray)
	{
		nextPiece = imgArray;
	}
	
	public void showNextPiece(Graphics g)
	{
		int xOffSet = 25;
		int yOffSet = 25;
		
		for (int i = 0; i < 4; i++)
		{
			for (int j = 0; j < 4; j++)
			{
				g.drawImage(nextPiece[i][j], xOffSet*i+10, yOffSet*j+8, null);
			}
		}
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		showNextPiece(g2d);
		g2d.drawRect(0, 0, 99, 115);
		g2d.drawRect(1, 1, 97, 113);
		g2d.drawRect(2, 2, 95, 111);
	}
	
	public void gameLoop()
	{
	    timer = new Timer();
	    timer.schedule(new Loop(), 0, 1000 / 4);
	}
	
	public class Loop extends java.util.TimerTask
	{
	    public void run()
	    {
	    	repaint();
	    	if (!isRunning)
	        {
	            timer.cancel();
	        }
	    }
	}
}
