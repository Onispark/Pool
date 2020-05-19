import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;


public class Table extends MouseAdapter implements MouseListener
{    

    public static void main(String[]args)
    {


    
        GameArena a = new GameArena(800, 500);

        //add pool table
        Rectangle[] poolTable = new Rectangle[2];
        poolTable[0] = new Rectangle(150.0, 100.0, 550.0, 250.0, "BROWN",1);
        poolTable[1] = new Rectangle(162.5, 112.5, 525.0, 225.0, "DARK_GREEN",1);

        for (int i=0; i < poolTable.length; i++)
            {
                a.addRectangle(poolTable[i]);
            }

        


        //add dot to board

        Ball dot = new Ball(270.0, 227.0, 5, "BLACK", 3);
        a.addBall(dot);

        //add white ball
        
        Ball white_ball = new Ball(270.0, 227.0, 10, "WHITE", 4);
        a.addBall(white_ball);

        //add black ball

        Ball black_ball = new Ball(560.0, 227.0, 10, "BLACK", 4);
        a.addBall(black_ball);
          

        //add Red balls
        Ball[] red_balls = new Ball[7];
        red_balls[0] = new Ball(540.0, 227.0, 10, "Red", 4);
        red_balls[1] = new Ball(550.0, 221.0, 10, "Red", 4);
        red_balls[2] = new Ball(560.0, 238.0, 10, "Red", 4);
        red_balls[3] = new Ball(570.0, 232.0, 10, "Red", 4);
        red_balls[4] = new Ball(570.0, 209.0, 10, "Red", 4);
        red_balls[5] = new Ball(580.0, 238.0, 10, "Red", 4);
        red_balls[6] = new Ball(580.0, 215.0, 10, "Red", 4);

        //add yellow balls
        Ball[] yellow_balls = new Ball[7];
        yellow_balls[0] = new Ball(550.0, 232.0, 10, "YELLOW", 4);
        yellow_balls[1] = new Ball(560.0, 215.0, 10, "YELLOW", 4);
        yellow_balls[2] = new Ball(570.0, 221.0, 10, "YELLOW", 4);
        yellow_balls[3] = new Ball(570.0, 244.0, 10, "YELLOW", 4);
        yellow_balls[4] = new Ball(580.0, 250.0, 10, "YELLOW", 4);
        yellow_balls[5] = new Ball(580.0, 203.0, 10, "YELLOW", 4);
        yellow_balls[6] = new Ball(580.0, 227.0, 10, "YELLOW", 4);


        for (int i=0; i < red_balls.length; i++)
        {
            a.addBall(red_balls[i]);
            a.addBall(yellow_balls[i]);
        }
        
   
        //add holes (Testing different positions)
        Ball[] holes = new Ball[6];
        holes[0] = new Ball(165.0, 335.0, 20, "BLACK", 4);
        holes[1] = new Ball(165.0, 112.0, 20, "BLACK", 4);
        holes[2] = new Ball(684.0, 112.0, 20, "BLACK", 4);
        holes[3] = new Ball(684.0, 335.0, 20, "BLACK", 4);
        holes[4] = new Ball(424.5, 337.0, 20, "BLACK", 4);
        holes[5] = new Ball(424.5, 112.0, 20, "BLACK", 4);
        
        for (int i=0; i < holes.length; i++)
        {
            a.addBall(holes[i]);
        }

        //add yellow line to board
        Line white_line = new Line(270.0, 112.0, 270.0, 337.0, 0.5, "YELLOW", 2);
        a.addLine(white_line); 

        while (true)
        {
            a.pause();

            double white_Xposition = white_ball.getXPosition(); //white ball xposition
            double white_Yposition = white_ball.getYPosition(); //white ball Y position
            double mouse_Xposition = a.getMousePositionX();
            double mouse_Yposition = a.getMousePositionY();

           
            a.addMouseListener(new MouseAdapter(){

                //creates aim line
                Line line2 = new Line(white_ball.getXPosition(), white_ball.getYPosition(),  a.getMousePositionX(),a.getMousePositionY(), 2.5, "YELLOW", 2);

                //make aim line visible when mouse pressed down
               public void mousePressed(MouseEvent e){

                //changes aimline position to where user pressed

                line2.setLinePosition(white_ball.getXPosition(), white_ball.getYPosition(),  a.getMousePositionX(),a.getMousePositionY());

                    a.addLine(line2);
                   
                }

                //removes aimline when mouse released
                public void mouseReleased(MouseEvent e){
                    a.removeLine(line2);
                }
            });
            
           

            

        }



        
    }
    

}