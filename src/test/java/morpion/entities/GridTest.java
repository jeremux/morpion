package morpion.entities;

import junit.framework.TestCase;
import java.util.Random;

/**
 * Created by jeremux on 04/09/2016.
 */
public class GridTest extends TestCase
{
    private Grid grid;
    private int size;

    public void setUp() throws Exception
    {
        super.setUp();
        size = new Random().nextInt(101);
        grid = new Grid(size);
    }

    public void tearDown() throws Exception
    {
        super.tearDown();
    }

    private int getRandom()
    {
        return new Random().nextInt(size);
    }

    public void testPlay() throws Exception
    {
        int x = getRandom();
        int y = getRandom();
        int nbEmptyCases = grid.getEmptyCases().size();
        grid.play(Character.O,x,y);
        assertEquals("Test nb empty cases",nbEmptyCases-1,grid.getEmptyCases().size());

    }

    public void testIsEmpty() throws Exception
    {
        int x = getRandom();
        int y = getRandom();
        assertTrue("true expected",grid.isEmpty(getRandom(),getRandom()));
        grid.play(Character.O,x,y);
        assertFalse("False expected",grid.isEmpty(x,y));

    }

    public void testIsDone() throws Exception
    {
        assertFalse("Test end game",grid.isDone());
        for (int i = 0; i < grid.getSize(); i++)
        {
            for (int j = 0; j < grid.getSize() ; j++)
            {
                this.grid.play(Character.O,i,j);
            }
        }
        assertTrue("Test end game OK",grid.isDone());
    }

    public void testGetSize() throws Exception
    {
        assertEquals(size+" expected ",size,this.grid.getSize());
    }

    public void testGetEmptyCases() throws Exception
    {
        //List<List<Character>> tmp = new ArrayList<List<Character>>();
        Grid gridCopy = new Grid(grid);
        assertTrue("have to be the same",gridCopy.equals(grid));
        //tmp.addAll(grid.getGrid());
        grid.play(Character.O,getRandom(),getRandom());
        assertFalse("have to differ",gridCopy.equals(grid.getGrid()));
    }

    public void testCheckChar() throws Exception
    {
        int x = getRandom();
        int y = getRandom();
        grid.play(Character.O,x,y);
        assertTrue("have to be the same",Character.O==this.grid.getGrid().get(x).get(y));
    }

}