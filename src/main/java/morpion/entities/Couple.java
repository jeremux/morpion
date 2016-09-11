package morpion.entities;

/**
 * Created by jeremux on 04/09/2016.
 */
public class Couple
{
    private int x;
    private int y;
    private int p1;
    private int p2;

    public int getX()
    {
        return x;
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getY()
    {
        return y;
    }
    public void setY(int y)
    {
        this.y = y;
    }

    public Couple(int x, int y)
    {
        super();
        this.x = x;
        this.y = y;
        this.p1 = -1;
        this.p2 = -1;
    }

    public Couple(int x, int y,int p1,int p2)
    {
        super();
        this.x = x;
        this.y = y;
        this.p1 = p1;
        this.p2 = p2;
    }
    public Couple()
    {
        // TODO Auto-generated constructor stub
        super();
    }
    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + x;
        result = prime * result + y;
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Couple couple = (Couple) o;

        if (x != couple.x) return false;
        if (y != couple.y) return false;
        if (p1 != couple.p1) return false;
        return p2 == couple.p2;

    }

    /**
     * @return the position
     */
    public int getPositionX()
    {
        return p1;
    }

    public int getPositionY()
    {
        return p2;
    }


    public void setPositionX(int x) {
        this.p1=x;
    }

    public void setPositionY(int y) {
        this.p2=y;
    }

    public void print()
    {
        System.out.println("("+x+","+y+","+p1+","+p2+")");
    }

    public void print(String s)
    {
        System.out.print(s);
        print();
    }
}
