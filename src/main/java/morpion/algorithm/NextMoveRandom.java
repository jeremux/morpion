package morpion.algorithm;

import morpion.entities.Couple;
import morpion.entities.Grid;

import java.util.Random;

/**
 * Created by jeremux on 09/09/2016.
 */
public class NextMoveRandom implements NextMove
{
    public Couple getNextMove(Grid g)
    {
        int nbEmptyCases = g.getEmptyCases().size();

        if(nbEmptyCases>0)
        {
            Random rand = new Random();
            int randomIndex = rand.nextInt(nbEmptyCases);
            return g.getEmptyCases().get(randomIndex);
        }
        else
        {
            return new Couple(-1,-1);
        }
    }
}
