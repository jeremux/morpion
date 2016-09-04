package morpion.entities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jeremux on 04/09/2016.
 */
public class Grid
{


    private int size;
    private List<List<Character>> grid;
    private int nbEmptyCase;
    private List<Couple> emptyCases;


    public Grid(int size)
    {
        this.size = size;
        nbEmptyCase = size * size;
        grid = new ArrayList<List<Character>>();
        emptyCases = new ArrayList<Couple>();
        List<Character> tmp ;

        for(int i = 0; i< size; i++)
        {
            tmp = new ArrayList<Character>();

            for(int j = 0; j< size; j++)
            {
                tmp.add(Character.V);
                emptyCases.add(new Couple(i,j));
            }

            grid.add(tmp);
        }
    }

    private void add(List<Character> l)
    {
        this.grid.add(l);
    }

    public Grid(Grid grid)
    {
        // TODO Auto-generated constructor stub
        this.size = grid.size;
        this.nbEmptyCase = grid.nbEmptyCase;
        this.emptyCases = new ArrayList<Couple>(grid.emptyCases);
        this.grid = new ArrayList<List<Character>>();

        List<Character> tmpCar ;
        for(int i = 0; i< size; i++)
        {
            tmpCar = new ArrayList<Character>();
            for(int j = 0; j< size; j++)
            {
                tmpCar.add(grid.grid.get(i).get(j));
            }
            this.grid.add(i, tmpCar);
        }
    }

    public void print()
    {
        System.out.print("|");
        for(int i = 0; i< size -1; i++)
            System.out.print("---|");
        System.out.println("---|");
        for(int i = 0; i< size; i++)
        {
            System.out.print("|");
            for(int j = 0; j< size -1; j++)
            {
                if(grid.get(i).get(j).toString().equalsIgnoreCase("v"))
                    //System.out.print(""+i+","+j+"|");
                    System.out.print(" "+(i* size +j)+" |");
                else
                    System.out.print(" "+ grid.get(i).get(j).toString()+ " |");
            }

            if(grid.get(i).get(size -1).toString().equalsIgnoreCase("v"))
                //System.out.println(""+i+","+(size-1)+"|");
                System.out.println(" "+(i* size +(size -1))+" |");
            else
                System.out.println(" "+ grid.get(i).get(size -1).toString()+ " |");

            System.out.print("|");
            for(int j = 0; j< size -1; j++)
                System.out.print("---|");
            System.out.println("---|");
        }
    }

    public boolean isEmpty(int x, int y)
    {
        return grid.get(x).get(y).toString().equalsIgnoreCase("v");
    }

    //TODO: PROBLEME VISIBILITY
    public Couple play(Character car,int x,int y)
    {
        //TODO: raise erreur borne...
        Couple res;
        List<Character> tmp = grid.get(x);
        tmp.set(y, car);
        grid.set(x, tmp);
        this.nbEmptyCase--;
        res = new Couple(x,y);

        this.emptyCases.remove(res);
                /*if (!this.emptyCases.remove(res))
                {
                        //TODO: raise erreur
                        System.err.println("ERREUR");
                }*/
        return res;

    }

    public boolean isDone()
    {
        return this.nbEmptyCase ==0;
    }

    public int getSize()
    {
        return size;
    }

    public List<Couple> getEmptyCases()
    {
        return this.emptyCases;
    }

    public List<List<Character>> getGrid()
    {
        return grid;
    }

    public boolean checkChar(Character c, int i, int i2)
    {
        return this.grid.get(i).get(i2).equals(c);
    }

    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Grid grid1 = (Grid) o;

        if (size != grid1.size) return false;
        if (nbEmptyCase != grid1.nbEmptyCase) return false;
        if (!grid.equals(grid1.grid)) return false;
        return emptyCases.equals(grid1.emptyCases);

    }

    public int hashCode()
    {
        int result = size;
        result = 31 * result + grid.hashCode();
        result = 31 * result + nbEmptyCase;
        result = 31 * result + emptyCases.hashCode();
        return result;
    }
}
