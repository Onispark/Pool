
public class Table 
{
    public static void main(String[]args)
    {


    
        GameArena a = new GameArena(800, 500);

        //add pool table
        Rectangle[] poolTable = new Rectangle[2];
        poolTable[0] = new Rectangle(150.0, 100.0, 550.0, 250.0, "BROWN",3);
        poolTable[1] = new Rectangle(162.5, 112.5, 525.0, 225.0, "DARK_GREEN",3);

        for (int i=0; i < poolTable.length; i++)
            {
                a.addRectangle(poolTable[i]);
            }



        //add white ball
        
        Ball white_ball = new Ball(250.0, 227.0, 10, "WHITE", 4);
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
        Ball[] holes = new Ball[7];
        holes[0] = new Ball(160.0, 160.0, 15, "PINK", 3);
        holes[1] = new Ball(170.0, 130.0, 15, "BLUE", 3);
        
        for (int i=0; i < holes.length; i++)
        {
            a.addBall(holes[i]);
        }

        
    }

}