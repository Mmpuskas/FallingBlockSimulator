package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Timer;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

import net.miginfocom.swing.MigLayout;

public class Runner implements ActionListener
{
	JFrame frame = new JFrame();
	GamePanel gp = new GamePanel();
	GUI gui = new GUI();
	Splash splash = new Splash();
	JLabel score = new JLabel("", SwingConstants.RIGHT);
	JLabel loss = new JLabel("<html><body>You lost.<br>Try again?</body></html>");
	JButton retry = new JButton("Yes");
	Border scoreBorder = BorderFactory.createLoweredBevelBorder();
	private java.util.Timer timer;
	private boolean isRunning;
	
	Runner()
	{
		frame.setLayout(new MigLayout("insets 0,gap 0px, filly"));
		frame.add(gp, "width 252, growy, hidemode 3");
		frame.add(gui, "width 100, growy, flowy, hidemode 3");
		frame.add(splash, "grow, push, hidemode 3");
		
		gui.setLayout(new MigLayout("filly, insets 0"));
		gui.add(new JLabel("Next Piece"), "pos 21 115");
		score.setBorder(scoreBorder);
		gui.add(score, "width 99, pos 0 165");
		gui.add(new JLabel("Score"), "pos 35 185");
		gui.add(loss, "width 60, pos 28 250");
		gui.add(retry, "width 40, height 14, pos 25 285");
		retry.addActionListener(this);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(358,505);
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        
        gui.setVisible(false);
        gp.setVisible(false);
        splash.setVisible(true);
        frame.setVisible(true);
        loss.setVisible(false);
        retry.setVisible(false);
        
        isRunning = true;
		gameLoop();
	}
	
	public static void main(String[] args)
	{
		new Runner();
	}
	
	public void toggleRunning()
	{
		if (!isRunning)
			gp.toggleIsRunning();
		else
			gp.toggleIsRunning();
	}
	
	public void gameLoop()
	{
	    timer = new Timer();
	    timer.schedule(new Loop(), 0, 1000 / 5);
	}
	
	public class Loop extends java.util.TimerTask
	{
	    public void run()
	    {
	    	if (!splash.isFocusable() && !gp.getLoss())
	    	{
	    		gui.setVisible(true);
	            gp.setVisible(true);
	            toggleRunning();
	    	}
	    	if (gp.getLoss())
	    	{
	    		loss.setVisible(true);
	    		retry.setVisible(true);
	    	}
	    	score.setText("" + gp.getScore());
	    	gui.setNextPiece(gp.getNextPiece());
	    	
	    	if (!isRunning)
	        {
	            timer.cancel();
	        }
	    }
	}

	@Override
	public void actionPerformed(ActionEvent evt) 
	{
		Object src = evt.getSource();
		if(src == retry)
			{
				loss.setVisible(false);
				retry.setVisible(false);
				gp.restart();
			}
		
	}
}
