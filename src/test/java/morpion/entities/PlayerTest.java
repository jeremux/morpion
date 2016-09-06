package morpion.entities;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by jeremux on 05/09/2016.
 */
public class PlayerTest extends TestCase
{
    Player p;
    Character c;

    public void setUp() throws Exception
    {
        super.setUp();
        p = new Player("toto");
        c = Character.O;
        p.setC(c);
    }

    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    private int getRandom()
    {
        return new Random().nextInt(100)+1;
    }

    public void testIsWinner() throws Exception
    {
        checkDiag1(getRandom());
        checkDiag2(getRandom());
        checkRandomLine(getRandom());
        checkRandomColumn(getRandom());
    }

    private void checkDiag1(int size) throws Exception
    {
        Grid g = new Grid(size);

        for (int i = 0; i < size; i++)
        {
            g.play(c,i,i);
        }

        assertTrue("Test win diag 1",p.isWinner(g));
    }

    private void checkDiag2(int size) throws Exception
    {
        Grid g = new Grid(size);
        int j = size -1;

        for (int i = 0; i < size; i++)
        {
            g.play(c,i,j);
            j--;
        }

        assertTrue("Test win diag 2",p.isWinner(g));
    }

    private void checkRandomLine(int size) throws Exception
    {
        Grid g = new Grid(size);
        int randomLine = new Random().nextInt(size);

        for (int j = 0; j < size ; j++)
        {
            g.play(c,randomLine,j);
        }
        assertTrue("Test win random line",p.isWinner(g));
    }

    private void checkRandomColumn(int size) throws Exception
    {
        Grid g = new Grid(size);
        int randomColumn = new Random().nextInt(size);

        for (int i = 0; i < size ; i++)
        {
            g.play(c,i,randomColumn);
        }
        assertTrue("Test win random column",p.isWinner(g));
    }

}