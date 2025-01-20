package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.List;


public class GreedyAnt extends Agent {

    public GreedyAnt(int x, int y) {
        super(x, y);
    }

    @Override
    public void decide(Environment env) {
        if (!(env instanceof AntFoodEnvironment)) {
            return;
        }
        AntFoodEnvironment afe = (AntFoodEnvironment) env;

        int[] closestFoodPos = findClosestFood(afe);
        if (closestFoodPos == null) {
            return;
        }

        int fx = closestFoodPos[0];
        int fy = closestFoodPos[1];

        int dx = Integer.compare(fx, this.x);
        int dy = Integer.compare(fy, this.y);

        int newX = this.x + dx;
        int newY = this.y + dy;

        if (afe.isValidPosition(newX, newY)) {
            setPosition(newX, newY);

            if (afe.hasFoodAt(newX, newY)) {
                afe.pickupFoodAt(newX, newY);
            }
        }
    }

    private int[] findClosestFood(AntFoodEnvironment afe) {
        double minDist = Double.MAX_VALUE;
        int[] result = null;
        for (int y = 0; y < afe.getHeight(); y++) {
            for (int x = 0; x < afe.getWidth(); x++) {
                if (afe.hasFoodAt(x, y)) {
                    double dist = distance(x, y, this.x, this.y);
                    if (dist < minDist) {
                        minDist = dist;
                        result = new int[] {x, y};
                    }
                }
            }
        }
        return result;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
