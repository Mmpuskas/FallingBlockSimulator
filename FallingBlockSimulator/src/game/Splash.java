package game;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

public class Splash extends JPanel
{
	BufferedImage splashPic = null;
	
	Splash()
	{
		KeyListener listener = new KeyListener() 
		{
			@Override
			public void keyTyped(KeyEvent e) 
			{
			}

			@Override
			public void keyPressed(KeyEvent e) 
			{
				int key = e.getKeyCode();
				
				if (key == KeyEvent.VK_W) 
			    {
					setVisible(false);
					setFocusable(false);
			    }
				
				if (key == KeyEvent.VK_A) 
				{
					setVisible(false);
					setFocusable(false);
			    }

			    if (key == KeyEvent.VK_S) 
			    {
			    	setVisible(false);
			    	setFocusable(false);
			    }
			    
			    if (key == KeyEvent.VK_D) 
			    {
			    	setVisible(false);
			    	setFocusable(false);
			    }
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				
			}
		};
		addKeyListener(listener);
		setFocusable(true);
		requestFocus();
	}
	
	public void setSplash(Graphics2D g2d)
	{
		try 
		{
			splashPic = ImageIO.read(getClass().getResource("/resources/Splash.jpg"));
		} catch (Exception e){
			System.out.println("Couldn't load block image" + e);
		}
		
		g2d.drawImage(splashPic, 0, 0, null);
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		setSplash(g2d);
	}

}
