package morpion.algorithm;

import junit.framework.TestCase;
import morpion.entities.Character;
import morpion.entities.Couple;
import morpion.entities.Grid;
import morpion.entities.Player;

import java.util.Random;

/**
 * Created by jeremux on 09/09/2016.
 */
public class NextMoveToWinTest extends TestCase
{
    private Player player1;
    private Player player2;
    private Grid grid;
    private int size;
    private NextMove nextMoveAlgorithm;

    public void setUp() throws Exception
    {
        super.setUp();
        player1 = new Player("player1");
        player2 = new Player("player2");

        player1.setC(Character.X);
        player2.setC(Character.O);

        player1.setTour(true);
        player2.setTour(false);
        size = getRandom();
        nextMoveAlgorithm = new NextMoveToWin(player1,player2);
    }

    private int getRandom()
    {
        return new Random().nextInt(100)+1;
    }

    private int getRandom(int min,int max)
    {
        Random rand =  new Random();
        int randomNum = rand.nextInt((max - min) + 1) + min;

        return randomNum;
    }

    public void testGetNextMove() throws Exception
    {
        fillDiag1();
        fillDiag2();
        fillRandomColumn();
        fillRandomLine();
    }

    private void fillDiag1() throws  Exception
    {
        grid = new Grid(size);
        int i = getRandom(0,size-1); //where not to play

        Couple returnExpected = new Couple(i,i);

        for (int j = 0; j < size ; j++)
        {
            if (!(j == i))
            {
                grid.play(Character.X, j, j); //player1 play
            }
        }

        Couple nextMove = nextMoveAlgorithm.getNextMove(grid);
        assertEquals("have to be the same",returnExpected,nextMove);
        grid = null;
    }

    private void fillDiag2() throws Exception
    {
        grid = new Grid(size);
        int j = size - 1;
        int randomI = getRandom(0,size-1);
        int randomJ = size-1-randomI;
        Couple returnExpected = new Couple(randomI,randomJ);

        for (int i = 0; i < size ; i++)
        {
            if(!(i==randomI && j==randomJ))
            {
                grid.play(Character.X,i,j);
            }
            j--;
        }

        Couple nextMove = nextMoveAlgorithm.getNextMove(grid);
        assertEquals("have to be the same",returnExpected,nextMove);
        grid = null;
    }


    private  void fillRandomColumn() throws Exception
    {
        grid = new Grid(size);

        int randomI = getRandom(0,size-1);
        int randomJ = getRandom(0,size-1);
        Couple returnExpected = new Couple(randomI,randomJ);


        for (int j = 0; j < size; j++)
        {
            if (!(randomJ == j))
            {
                grid.play(Character.X, randomI, j);
            }
        }


        Couple nextMove = nextMoveAlgorithm.getNextMove(grid);
        assertEquals("have to be the same",returnExpected,nextMove);
        grid = null;
    }

    private void fillRandomLine() throws Exception
    {
        grid = new Grid(size);

        int randomI = getRandom(0,size-1);
        int randomJ = getRandom(0,size-1);
        Couple returnExpected = new Couple(randomI,randomJ);


        for (int i = 0; i < size; i++)
        {
            if(!(randomI==i))
            {
                grid.play(Character.X,i,randomJ);
            }
        }


        Couple nextMove = nextMoveAlgorithm.getNextMove(grid);
        assertEquals("have to be the same",returnExpected,nextMove);
        grid = null;
    }



}