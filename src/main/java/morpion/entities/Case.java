package morpion.entities;

/**
 * Created by jeremux on 03/09/2016.
 */
public class Case
{
    private int x;
    private int y;
    private Character currentCharacter;

    public Case(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        this.currentCharacter = null;
    }

    public void setX(int x)
    {
        this.x = x;
    }

    public void setY(int y)
    {
        this.y = y;
    }

    public void setCurrentCharacter(Character currentCharacter)
    {
        this.currentCharacter = currentCharacter;
    }

    public int getAbscisse()
    {
        return x;
    }

    public int getOrdonne()
    {
        return y;
    }

    public boolean isEmpty()
    {
        return !((this.currentCharacter)==null);
    }

    public void setX()
    {
        this.currentCharacter = Character.X;
    }

    public void setO()
    {
        this.currentCharacter = Character.O;
    }



    public void print()
    {
        System.out.println("("+x+";"+y+")");
    }

    public Character getCharacter()
    {
        return currentCharacter;
    }
}
