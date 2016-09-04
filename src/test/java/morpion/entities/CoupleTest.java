package morpion.entities;

import junit.framework.TestCase;

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


    public void testGetX() throws Exception
    {
        c = new Couple(3,2);
        assertEquals("3 attendu",3,c.getX());
    }

    public void testSetX() throws Exception
    {
        fail("not implemented");
    }


    public void testGetY() throws Exception
    {
        fail("not implemented");
    }

    public void testSetY() throws Exception
    {
        fail("not implemented");

    }

    public void testGetPositionX() throws Exception
    {
        fail("not implemented");

    }

    public void testGetPositionY() throws Exception
    {
        fail("not implemented");

    }

    public void testSetPositionX() throws Exception
    {
        fail("not implemented");

    }

    public void testSetPositionY() throws Exception
    {
        fail("not implemented");

    }

}