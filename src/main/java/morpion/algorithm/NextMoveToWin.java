package morpion.algorithm;

/**
 * Created by jeremux on 09/09/2016.
 */

import morpion.entities.Couple;
import morpion.entities.Grid;
import morpion.entities.Player;

import java.util.Random;

/**
 * If a player can win play to this place
 * or random place
 */
public class NextMoveToWin implements NextMove
{
    private Player player;

    public NextMoveToWin(Player p1,Player p2)
    {
        if(p1.isTurn())
        {
            player = p1;
        }
        else
        {
            player = p2;
        }
    }

    public Couple getNextMove(Grid g)
    {
        Couple res = new Couple();
        res.setPositionX(-1);
        res.setPositionY(-1);
        Grid gCopy;
        int  i = 0;
        int randomIndex;
        boolean loop = true;
        int x,y;

        int nbEmptyCase = g.getEmptyCases().size();

        while (i < nbEmptyCase && loop)
        {
            x = g.getEmptyCases().get(i).getX();
            y = g.getEmptyCases().get(i).getY();

            gCopy = new Grid(g);
            gCopy.play(player.getC(),x,y);
            if(player.isWinner(gCopy))
            {
                res.setX(x);
                res.setY(y);
                loop = false;
            }
            i++;
        }

        if(loop)
        {
            System.out.print("TOTO");
            Random r = new Random();
            randomIndex = r.nextInt(g.getEmptyCases().size());
            res = g.getEmptyCases().get(randomIndex);
        }

        return res;
    }
}
