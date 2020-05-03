import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;


//creates PoolTable claa
public class PoolTable extends JPanel implements Runnable, KeyListener, MouseListener, MouseMotionListener
{
    //creates size of the play screen.

    public JFrame myFrame = new JFrame("Pool!");
    private JPanel panel = new JPanel();
	private int gameWidth;
    private int gameHeight;


        public PoolTable()
        {  
            //creating the background and JFrame and size of JFrame
            int width = 800;
            int height = 500;    
            myFrame.setTitle("Pool");
            this.setBackground(Color.BLACK);
            myFrame.setSize(width, height);
            myFrame.setResizable(false);
            myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            myFrame.setContentPane(this);
            myFrame.setVisible(true);
   
            
        }	
        private void background(Graphics g) 
        {
    
            Graphics2D g2d = (Graphics2D) g;
            
            Rectangle backBoard = new Rectangle(400, 250, 600, 200);
            backBoard.setBackground(new Color(12,13,43));
        }
        


}