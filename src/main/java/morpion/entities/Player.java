package morpion.entities;


/**
 * Created by jeremux on 05/09/2016.
 */
public class Player
{
    private Character    c;
    private String       pseudo;
    private boolean      turn;

    public Player(String pseudo)
    {
        this.pseudo       = pseudo;

    }

    public Player(Player p)
    {
        this.c = p.c;
        this.pseudo = p.pseudo;
        this.turn = p.turn;
    }

    public Character getC()
    {
        return c;
    }

    public void setC(Character c)
    {
        this.c = c;
    }

    public String getPseudo()
    {
        return pseudo;
    }

    public void setPseudo(String pseudo)
    {
        this.pseudo = pseudo;
    }

    public boolean isTurn()
    {
        return turn;
    }

    public void setTour(boolean turn)
    {
        this.turn = turn;
    }

    public boolean isWinner(Grid grid)
    {
        return (checkColums(grid) || checkLines(grid) || checkDiagonals(grid));
    }

    private boolean checkDiagonals(Grid grid)
    {
        return (checkDiagonal1(grid)||checkDiagonal2(grid));
    }

    private boolean checkDiagonal1(Grid grid)
    {
        int i=0;
        boolean res = true;
        while(i<grid.getSize() && res)
        {
            res = grid.checkChar(this.c,i,i);
            i++;
        }
        return res;
    }

    private boolean checkDiagonal2(Grid grid)
    {
        int     i   = 0;
        int     j   = grid.getSize()-1;
        boolean res = true;
        while(i<grid.getSize() && res)
        {
            res = grid.checkChar(this.c,i,j);
            i++;
            j--;
        }
        return res;
    }

    private boolean checkColums(Grid grid)
    {
        boolean res = false;
        int i = 0;
        int size = grid.getSize();

        while (i<size && !res)
        {
            res = checkColumn(i,grid);
            i++;
        }
        return res;
    }

    private boolean checkColumn(int i,Grid grid)
    {
        boolean res  = true;
        int     j    = 0;
        while(j<grid.getSize() && res)
        {
            res = grid.checkChar(c, j, i);
            j++;
        }
        return res;
    }

    private boolean checkLines(Grid grid)
    {
        boolean res = false;
        int     i   = 0;
        int size = grid.getSize();

        while (i<size && !res)
        {
            res = checkLine(i,grid);
            i++;
        }
        return res;
    }

    private boolean checkLine(int i,Grid grid)
    {
        boolean res  = true;
        int     j    = 0;
        int size = grid.getSize();

        while(j<size && res)
        {
            res = grid.checkChar(c, i, j);
            j++;
        }
        return res;
    }


    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((c == null) ? 0 : c.hashCode());
        result = prime * result + ((pseudo == null) ? 0 : pseudo.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Player other = (Player) obj;
        if (c != other.c)
            return false;
        if (pseudo == null)
        {
            if (other.pseudo != null)
                return false;
        }
        else if (!pseudo.equals(other.pseudo))
            return false;
        return true;
    }

}
