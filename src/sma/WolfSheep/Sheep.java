package sma.WolfSheep;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.List;


public class Sheep extends Agent {

    public Sheep(int x, int y) {
        super(x, y);
    }

    @Override
    public void decide(Environment env) {
        if (!(env instanceof GridEnvironment)) {
            return;
        }
        GridEnvironment gridEnv = (GridEnvironment) env;

        Wolf closestWolf = findClosestWolf(gridEnv.getAgents());

        if (closestWolf == null) {
            return;
        }

        int dx = Integer.compare(this.x, closestWolf.getX());
        int dy = Integer.compare(this.y, closestWolf.getY());

        int newX = this.x + dx;
        int newY = this.y + dy;

        if (gridEnv.isValidPosition(newX, newY)) {
            setPosition(newX, newY);
        }
    }

    private Wolf findClosestWolf(List<Agent> agents) {
        Wolf closest = null;
        double minDist = Double.MAX_VALUE;

        for (Agent a : agents) {
            if (a instanceof Wolf) {
                double dist = distance(a.getX(), a.getY(), this.x, this.y);
                if (dist < minDist) {
                    minDist = dist;
                    closest = (Wolf) a;
                }
            }
        }
        return closest;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
