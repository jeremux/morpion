package morpion.entities;

import junit.framework.TestCase;

/**
 * Created by jeremux on 03/09/2016.
 */
public class CaseTest extends TestCase
{
    private Case aCase;


    public void setUp() throws Exception
    {
        super.setUp();
        aCase = new Case(0,0);
    }

    public void tearDown() throws Exception
    {
        super.tearDown();
        aCase = null;
    }

    public void testGetAbscisse() throws Exception
    {
        aCase.setX(4);
        assertEquals("0 attendu",4,aCase.getAbscisse());
        aCase.setX(2);
        assertFalse("test Ko",2!=aCase.getAbscisse());
    }

    public void testGetOrdonne() throws Exception
    {
        aCase.setY(5);
        assertEquals("0 attendu",5,aCase.getOrdonne());
        aCase.setY(2);
        assertFalse("test Ko",2!=aCase.getOrdonne());
    }

    public void testIsEmpty() throws Exception
    {
        assertFalse("test non null",aCase.isEmpty());
    }

    public void testSetX()
    {
        aCase.setX();
        assertTrue("Test setX()",Character.X==aCase.getCharacter());
    }

    public void testSetO()
    {
        aCase.setO();
        assertTrue("Test setO()",Character.O==aCase.getCharacter());
    }
}
