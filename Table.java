import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.awt.image.*;
import java.awt.event.*;
import java.util.*;
import java.lang.Class;
import java.lang.reflect.*;



public class Table extends MouseAdapter
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
        
        Ball white_ball = new Ball(270.0, 227.0, 10, "WHITE", 4, 5, 5);
        a.addBall(white_ball);

        //add black ball

        Ball black_ball = new Ball(560.0, 227.0, 10, "BLACK", 4, 4, 4);
        a.addBall(black_ball);
          

        //add Red balls
        Ball[] red_balls = new Ball[7];
        red_balls[0] = new Ball(540.0, 227.0, 10, "Red", 4, 4, 4);
        red_balls[1] = new Ball(550.0, 221.0, 10, "Red", 4, 4, 4);
        red_balls[2] = new Ball(560.0, 238.0, 10, "Red", 4, 4, 4);
        red_balls[3] = new Ball(570.0, 232.0, 10, "Red", 4, 4, 4);
        red_balls[4] = new Ball(570.0, 209.0, 10, "Red", 4, 4, 4);
        red_balls[5] = new Ball(580.0, 238.0, 10, "Red", 4, 4, 4);
        red_balls[6] = new Ball(580.0, 215.0, 10, "Red", 4, 4, 4);

        //add yellow balls
        Ball[] yellow_balls = new Ball[7];
        yellow_balls[0] = new Ball(550.0, 232.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[1] = new Ball(560.0, 215.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[2] = new Ball(570.0, 221.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[3] = new Ball(570.0, 244.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[4] = new Ball(580.0, 250.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[5] = new Ball(580.0, 203.0, 10, "YELLOW", 4, 4, 4);
        yellow_balls[6] = new Ball(580.0, 227.0, 10, "YELLOW", 4, 4, 4);


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

        //while loop to make balls animated
        while (true)
        {



            a.pause();
            
            
            if (a.leftMousePressed() == true){
                //When the whiteball hits the edge of the pool table it's direction is reversed to make it look like a rebound
                if(white_ball.getXPosition() >= 687){
                    white_ball.reverseX();
                } 
                else if (white_ball.getXPosition() < 163){
                    white_ball.reverseX();
                }

                if(white_ball.getYPosition() >= 336){
                    white_ball.reverseY();
                } else if (white_ball.getYPosition() < 108){
                    white_ball.reverseY();
                }

                //for loop to make white ball bounce of other balls
                for (int i=0; i < red_balls.length; i++)
                {
                    
                    if (white_ball.collides(red_balls[i]) )                       
                    {
                        white_ball.reverseX();
                        white_ball.reverseY();

                        //code to make redball that was hit by white ball move

                        //int x = 0;

                        // while (x <15){
                        // red_balls[i].setXPosition(red_balls[i].getXPosition()+ red_balls[i].getxvelocity());
                        // red_balls[i].setYPosition(red_balls[i].getYPosition()+ red_balls[i].getyvelocity());
                        // x++;
                        // }

                        // for (int j = 0; j< red_balls.length; j++){

                        // }
                    }
                    if ( white_ball.collides(yellow_balls[i]) )                       
                    {
                        white_ball.reverseX();
                        white_ball.reverseY();
                    }    


                    

                }
                //removes white ball from screen if it overlaps a hole
                for (int i=0; i < holes.length; i++){
                    if (white_ball.collides(holes[i])){
                       a.removeBall(white_ball);
                    }
                    
                }

                white_ball.setXPosition(white_ball.getXPosition()+ white_ball.getxvelocity());
                white_ball.setYPosition(white_ball.getYPosition()+ white_ball.getyvelocity());


                //Code to create and add yellow aim line to show direction white ball is going in

                //Line line2 = new Line(white_ball.getXPosition(), white_ball.getYPosition(),white_ball.getXPosition(), white_ball.getYPosition(), 0.5, "YELLOW", 2);
        
                //make aim line visible when mouse pressed down              
                //  while (a.leftMousePressed() == true){
                    //changes aimline position to where user pressed

                //      line2.setLinePosition(white_ball.getXPosition(), white_ball.getYPosition(),  a.getMousePositionX(),a.getMousePositionY());
                //      a.addLine(line2);
    
                //  }
                //  while (a.leftMousePressed() == false){
                //      a.removeLine(line2); //removes aim line when left press is released
                //  }


            }

        }           
    }
}        
 