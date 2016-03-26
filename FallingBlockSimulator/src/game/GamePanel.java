package game;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Timer;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class GamePanel extends JPanel
{
	private BufferedImage[][] imgArray = new BufferedImage[10][20];
	private BufferedImage[][] nextPiece = new BufferedImage[4][4];
	private Block focusBlock = null;
	private Block bufferBlock = null;
	private int score = 0;
	private boolean loss = false;
	
	private java.util.Timer timer;
	private boolean isRunning;
	
	public GamePanel()
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
				
				if (key == KeyEvent.VK_A) 
				{
			        focusBlock.left(imgArray);
			    }

			    if (key == KeyEvent.VK_D) 
			    {
			    	focusBlock.right(imgArray);
			    }
			    
			    if (key == KeyEvent.VK_W) 
			    {
			    	focusBlock.rotate(imgArray);
			    }
			}

			@Override
			public void keyReleased(KeyEvent e) 
			{
				
			}
		};
		
		addKeyListener(listener);
		setFocusable(true);
		isRunning = false;
		focusBlock = new Block();
		nextBlock();
		gameLoop();
	}
	
	public void gameLoop()
	{
	    timer = new Timer();
	    timer.schedule(new Loop(), 0, 1000 / 5);
	}
	
	public void drawBoard(Graphics2D g2d)
	{
		g2d.setColor(Color.white);
		g2d.fillRect(0, 0, this.getWidth(), this.getHeight());
		g2d.setColor(Color.gray);
		for (int i = 0; i < 21; i++)
		{
			g2d.drawRect(0, 25*i, this.getWidth(), 1);
		}
		for (int i = 0; i < 11; i++)
		{
			g2d.drawRect(25*i, 0, 1, this.getHeight());
		}
	}
	
	public void toggleIsRunning()
	{
		if (!isRunning)
		{
			isRunning = true;
			gameLoop();
			requestFocus();
		}
		else
			isRunning = false;
	}
	
	public void nextBlock()
	{
		bufferBlock = new Block();
	}
	
	public int getScore()
	{
		return score;
	}
	
	public boolean getLoss()
	{
		return loss;
	}

	public BufferedImage[][] getNextPiece()
	{
		for (int i = 0; i < 4; i++) //Clear old piece
			for (int j = 0; j < 4; j++)
				nextPiece[i][j] = null;
		
		for (int i = 0; i < 4; i++) //Set new piece
			for (int j = 0; j < 4; j++)
			{
				if (bufferBlock.blockPos[i+4][j] != null)
					nextPiece[i][j] = bufferBlock.blockPos[i+4][j];
			}
		return nextPiece;
	}
	
	public void drawBlocks(Graphics2D g2d)
	{
		int xOffSet = 25;
		int yOffSet = 25;
		
		focusBlock.nextBlock(imgArray);

		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				g2d.drawImage(imgArray[j][i], xOffSet*j+1, yOffSet*i+1, null);
			}
		}
	}
	
	
	
	public void checkLineClear()
	{
		int counter = 0;
		for (int i = 0; i < 20; i++)
		{
			for (int j = 0; j < 10; j++)
				if (imgArray[j][i] != null)
					counter++;
			
			if (counter == 10)
			{
				for (int k = 0; k < 10; k++)
					imgArray[k][i] = null;
				
				for (int n = i-1; n >= 0; n--)
				{
					for (int m = 0; m < 10; m++)
					{
						imgArray[m][n+1] = imgArray[m][n];
					}
				}
				
				score += 1000;
			}
			
			counter = 0;
		}
	}
	
	public void checkLoss()
	{
		for (int i = 0; i < 10; i++)
			if (imgArray[i][0] != null)
			{
				loss = true;
				isRunning = false;
			}
	}
	
	public void restart()
	{
		loss = false;
		score = 0;
		
		for (int i = 0; i < 10; i++) //Clear the board
			for (int j = 0; j < 20; j++)
				imgArray[i][j] = null;
		
		toggleIsRunning();
	}
	
	@Override
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		Graphics2D g2d = (Graphics2D) g;
		drawBoard(g2d);
		drawBlocks(g2d);
	}
	
	public class Loop extends java.util.TimerTask
	{
	    public void run()
	    {
	    	if (!focusBlock.down(imgArray))
	    	{
		    	checkLineClear();
		    	checkLoss();
	    		focusBlock = bufferBlock;
	    		nextBlock();
	    	}
	    	repaint();
	    	
	    	if (!isRunning)
	        {
	            timer.cancel();
	        }
	    }
	}
}
