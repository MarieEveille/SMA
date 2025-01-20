package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.Random;

public class RandomAnt extends Agent {

    private Random rand;

    public RandomAnt(int x, int y) {
        super(x, y);
        this.rand = new Random();
    }

    @Override
    public void decide(Environment env) {
        if (!(env instanceof AntFoodEnvironment)) {
            return;
        }
        AntFoodEnvironment afe = (AntFoodEnvironment) env;

        int dx = 0;
        int dy = 0;
        switch (rand.nextInt(4)) {
            case 0 -> dx = 1;
            case 1 -> dx = -1;
            case 2 -> dy = 1;
            case 3 -> dy = -1;
        }

        int newX = this.x + dx;
        int newY = this.y + dy;

        if (afe.isValidPosition(newX, newY)) {
            setPosition(newX, newY);

            if (afe.hasFoodAt(newX, newY)) {
                afe.pickupFoodAt(newX, newY);
            }
        }
    }
}
