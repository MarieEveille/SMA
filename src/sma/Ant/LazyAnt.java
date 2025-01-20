package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;


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

        if (afe.hasFoodAt(this.x, this.y)) {
            afe.pickupFoodAt(this.x, this.y);
        }
    }
}
