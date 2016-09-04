package morpion.entities;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by jeremux on 04/09/2016.
 */
public class CoupleTest extends TestCase
{
    Couple c;
    public void setUp() throws Exception
    {
        super.setUp();
    }

    public void tearDown() throws Exception
    {
        c = null;
    }

    private void myAssert(int expected,int current) throws Exception
    {
        assertEquals(expected+" expected",expected,current);
    }

    private int getRandom()
    {
        return new Random().nextInt(10001);
    }

    public void testGetX() throws Exception
    {
        int x = getRandom();
        c = new Couple(x,2);
        myAssert(x,c.getX());
    }

    public void testSetX() throws Exception
    {
        int x = getRandom();
        c = new Couple(0,2);
        c.setX(x);
        myAssert(x,c.getX());
    }


    public void testGetY() throws Exception
    {
        int y = getRandom();
        c = new Couple(2,y);
        myAssert(y,c.getY());
    }

    public void testSetY() throws Exception
    {
        int y = getRandom();
        c = new Couple(0,2);
        c.setY(y);
        myAssert(y,c.getY());
    }

    public void testGetPositionX() throws Exception
    {
        int px = getRandom();
        c = new Couple(0,0,px,0);
        myAssert(px,c.getPositionX());
    }

    public void testGetPositionY() throws Exception
    {
        int py = getRandom();
        c = new Couple(0,0,0,py);
        myAssert(py,c.getPositionY());
    }

    public void testSetPositionX() throws Exception
    {
        int px = getRandom();
        c = new Couple(0,0);
        c.setPositionX(px);
        myAssert(px,c.getPositionX());

    }

    public void testSetPositionY() throws Exception
    {
        int py = getRandom();
        c = new Couple(0,0);
        c.setPositionY(py);
        myAssert(py,c.getPositionY());
    }

}