package morpion.entities;

import junit.framework.TestCase;
import morpion.algorithm.NextMove;
import morpion.algorithm.NextMoveRandom;

import java.util.Random;

/**
 * Created by jeremux on 09/09/2016.
 */
public class NextMoveRandomTest extends TestCase
{
    private Grid g;
    private int size;
    private int getRandom()
    {
        return new Random().nextInt(100)+1;
    }
    private NextMove nextMove;

    public void setUp() throws Exception
    {
        super.setUp();
        size = getRandom();
        g = new Grid(size);
        nextMove = new NextMoveRandom();
    }

    public void testGetNextMove() throws Exception
    {
        Couple move ;
        Couple noMove = new Couple(-1,-1);

        while(!g.isDone())
        {
            move = nextMove.getNextMove(g);
            assertTrue("test appartenance",g.getEmptyCases().contains(move));
            g.play(Character.O,move.getX(),move.getY());
            assertFalse("test non-appartenance",g.getEmptyCases().contains(move));
        }

        //all move is done
        move = nextMove.getNextMove(g);
        assertEquals("have to be the same",noMove,move);
    }


}