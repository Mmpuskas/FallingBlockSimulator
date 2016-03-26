package game;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class Block
{
	private int x = 5; //References coords for rotation
	private int y = 1;
	private char color = ' ';
	private String shape = "";
	private char[] colors = {'b', 'g', 'r', 'y'};
	private String[] shapes = {"i1", "j1", "l1", "o1", "z1", "t1", "s1","i2", "j2", "l2", "o2", "z2", "t2", "s2","i3", 
			"j3", "l3", "o3", "z3", "t3", "s3","i4", "j4", "l4", "o4", "z4", "t4", "s4"};
	private BufferedImage chosenColor = null;
	BufferedImage[][] blockPos = new BufferedImage[10][20];
	private BufferedImage[][] blockAux = new BufferedImage[10][20];
	
	Block()
	{
		getRandomAttributes();
	}
	
	public void getRandomAttributes()
	{
		color = colors[(int) (Math.random() * 4)];
		shape = shapes[(int) (Math.random() * 7)];
		
		try
		{
		if (color == 'r')
		{
			chosenColor = ImageIO.read(getClass().getResource("/resources/redblock.bmp"));
		}
		else if (color == 'b')
		{
			chosenColor = ImageIO.read(getClass().getResource("/resources/blueblock.bmp"));
		}
		else if (color == 'g')
		{
			chosenColor = ImageIO.read(getClass().getResource("/resources/greenblock.bmp"));
		}
		else if (color == 'y')
		{
			chosenColor = ImageIO.read(getClass().getResource("/resources/yellowblock.bmp"));
		}
		} catch (Exception e){
			System.out.println("Couldn't load block image" + e);
		}
		
		setShape(shape);
	}
	
	public void setShape(String curShape)
	{
		shape = curShape;
		if (curShape == "i1")//top to bottom
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x][y+2] = chosenColor;
		}
		else if (curShape == "j1")//following from top
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x-1][y+1] = chosenColor;
		}
		else if (curShape == "l1")//from top
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "o1")
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "z1")//from left
		{
			blockPos[x+1][y-1] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "t1")//top, then from left
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "s1")//top to bottom
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "i2")//left to right
		{
			blockPos[x-2][y] = chosenColor;
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "j2")//top left following
		{
			blockPos[x-1][y-1] = chosenColor;
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "l2")//from bottom left
		{
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "o2")//same as 01
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "z2")//from top right
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "t2")//top down, then right
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "s2")//left to right
		{
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else if (curShape == "i3")//top to bottom
		{
			blockPos[x][y-2] = chosenColor;
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "j3")//top right following
		{
			blockPos[x+1][y-1] = chosenColor;
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "l3")//from top left
		{
			blockPos[x-1][y-1] = chosenColor;
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "o3")//same as o1
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "z3")//same as z1
		{
			blockPos[x+1][y-1] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "t3")//from left, then bottom
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "s3")//same as s1
		{
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "i4")//left to right
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x+2][y] = chosenColor;
		}
		else if (curShape == "j4")//left following
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "l4")//from left
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
			blockPos[x+1][y-1] = chosenColor;
		}
		else if (curShape == "o4")//same as o1
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "z4")//same as z2
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x+1][y+1] = chosenColor;
		}
		else if (curShape == "t4")//left, then top to bottom
		{
			blockPos[x-1][y] = chosenColor;
			blockPos[x][y-1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x][y+1] = chosenColor;
		}
		else if (curShape == "s4")//same as s2
		{
			blockPos[x-1][y+1] = chosenColor;
			blockPos[x][y+1] = chosenColor;
			blockPos[x][y] = chosenColor;
			blockPos[x+1][y] = chosenColor;
		}
		else
			System.out.println("Couldn't find it");
	}
	
	public void nextBlock(BufferedImage[][] imgArray)
	{
		for (int i = 0; i < 10; i++)
			for (int j = 0; j < 20; j++)
			{
				if (blockPos[i][j] != null)
					imgArray[i][j] = blockPos[i][j];
			}
	}
	
	public boolean down(BufferedImage[][] imgArray)
	{
		BufferedImage[][] oldState = imgArray;
		
		for (int i = 0; i < 10; i++) //Clear blockAux
			for (int j = 0; j < 20; j++)
				blockAux[i][j] = null;
		
		for (int i = 19; i > 0; i--) //Set blockAux to the new position of the piece
			for (int j = 0; j < 10; j++)
				blockAux[j][i] = blockPos[j][i-1];
		
		for (int i = 0; i < 10; i++)//Clear imgArray of the old piece's position
			for (int j = 0; j < 20; j++)
				if (blockPos[i][j] != null)
					imgArray[i][j] = null;
		
		for (int i = 19; i > 0; i--) //Check if any new position conflicts with old positions on imgarray
			for (int j = 0; j < 10; j++)
			{
				if (blockAux[j][i] != null && imgArray[j][i] != null)
				{//If so, put old piece back in and return false
					imgArray = oldState;
					nextBlock(imgArray);
					return false;
				}
			}
		for (int i = 0; i < 10; i++) //Check the floor
			if (blockPos[i][18] != null)
			{
				nextBlock(imgArray);
				return false;
			}
		
		for (int i = 0; i < 10; i++) //Set blockPos to the new position of the piece
			for (int j = 0; j < 20; j++)
					blockPos[i][j] = blockAux[i][j];
		
		for (int i = 19; i > 0; i--) //Set new piece
			for (int j = 0; j < 10; j++)
			{
				if (blockAux[j][i] != null)
					imgArray[j][i] = blockAux[j][i];
			}
		
		y++;
		return true;
	}

	public boolean right(BufferedImage[][] imgArray)
	{
		boolean flag = false;
		
		for (int i = 0; i < 20; i++) //Check the wall
			if (blockPos[9][i] != null)
				return false;
		
		for (int j = 19; j >= 0; j--) //starting from the right, find a spot where blockPos is filled
			for (int i = 9; i >= 0; i--)
			{
				if (blockPos[i][j] != null && imgArray[i+1][j] == null) //Check if the space to move to is null
				{
					flag = true;
					break;
				}
				else if (blockPos[i][j] != null && imgArray[i+1][j] != null)
					return false;
				if (flag)
					break;
			}
		
		flag = false;
		
		for (int i = 0; i < 10; i++) //Clear blockAux
			for (int j = 0; j < 20; j++)
				blockAux[i][j] = null;
		
		for (int i = 8; i >= 0; i--) //Set blockAux to the new position of the piece
			for (int j = 0; j < 20; j++)
				blockAux[i+1][j] = blockPos[i][j];
		
		for (int i = 0; i < 10; i++)//Clear imgArray of the old piece's position
			for (int j = 0; j < 20; j++)
				if (blockPos[i][j] != null)
					imgArray[i][j] = null;
		
		for (int i = 0; i < 10; i++) //Set blockPos to the new position of the piece
			for (int j = 0; j < 20; j++)
				blockPos[i][j] = blockAux[i][j];
		
		for (int i = 9; i >= 0; i--) //Set new piece
			for (int j = 0; j < 20; j++)
			{
				if (blockPos[i][j] != null)
					imgArray[i][j] = blockPos[i][j];
			}
		
		x++;
		return true;			
	}
	
	public boolean left(BufferedImage[][] imgArray)
	{
		boolean flag = false;

		for (int i = 0; i < 20; i++) //Check the wall
			if (blockPos[0][i] != null)
				return false;
		
		for (int j = 19; j >= 0; j--) //starting from the right, find a spot where blockPos is filled
			for (int i = 0; i < 10; i++)
			{
				if (blockPos[i][j] != null && imgArray[i-1][j] == null) //Check if the space to move to is null
				{
					flag = true;
					break;
				}
				else if (blockPos[i][j] != null && imgArray[i-1][j] != null)
					return false;
				if (flag)
					break;
			}
		
		flag = false;
		
		for (int i = 0; i < 10; i++) //Clear blockAux
			for (int j = 0; j < 20; j++)
				blockAux[i][j] = null;
		
		for (int i = 9; i > 0; i--) //Set blockAux to the new position of the piece
			for (int j = 0; j < 20; j++)
				blockAux[i-1][j] = blockPos[i][j];
		
		for (int i = 0; i < 10; i++)//Clear imgArray of the old piece's position
			for (int j = 0; j < 20; j++)
				if (blockPos[i][j] != null)
					imgArray[i][j] = null;
		
		for (int i = 0; i < 10; i++) //Set blockPos to the new position of the piece
			for (int j = 0; j < 20; j++)
				blockPos[i][j] = blockAux[i][j];
		
		for (int i = 9; i >= 0; i--) //Set new piece
			for (int j = 0; j < 20; j++)
			{
				if (blockPos[i][j] != null)
					imgArray[i][j] = blockPos[i][j];
				blockAux[i][j] = null;
			}
		
		x--;
		return true;	
	}
	
	public boolean rotate(BufferedImage[][] imgArray)
	{
		if (x == 8 || x == 0)
			return false;
		
		for (int i = 0; i < 10; i++)//Clear imgArray of the old piece's position
			for (int j = 0; j < 20; j++)
				if (blockPos[i][j] != null)
					imgArray[i][j] = null;
		for (int i = 0; i < 10; i++) //Clear blockPos
			for (int j = 0; j < 20; j++)
				blockPos[i][j] = null;
		
		int index = 0; 
		
		for (int i = 0; i < 28; i++) //Set rotated position
			if (shapes[i].equals(shape))
				index = i;
		
		if (index >= 21)
			index -= 21;
		else
			index += 7;
		
		setShape(shapes[(index)]);
		
		for (int i = 9; i >= 0; i--) //Set new piece
			for (int j = 0; j < 20; j++)
			{
				if (blockPos[i][j] != null)
					imgArray[i][j] = blockPos[i][j];
			}
		
		return true;
	}
	
}
