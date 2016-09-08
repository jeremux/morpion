package morpion.algorithm;

import morpion.entities.Couple;
import morpion.entities.Grid;

/**
 * Created by jeremux on 09/09/2016.
 */
public interface NextMove
{
    Couple getNextMove(Grid g);
}
