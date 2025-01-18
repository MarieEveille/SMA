package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

/**
 * Une fourmi qui ne bouge pas,
 * mais qui ramasse la nourriture si jamais elle est sur la même case.
 */
public class LazyAnt extends Agent {

    public LazyAnt(int x, int y) {
        super(x, y);
    }

    @Override
    public void decide(Environment env) {
        if (!(env instanceof AntFoodEnvironment)) {
            return;
        }
        AntFoodEnvironment afe = (AntFoodEnvironment) env;

        // Cette fourmi ne bouge pas.
        // Elle ramasse juste la nourriture si elle se trouve sur sa position.
        if (afe.hasFoodAt(this.x, this.y)) {
            afe.pickupFoodAt(this.x, this.y);
        }
    }
}
