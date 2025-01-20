package sma.WolfSheep;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.List;

public class Wolf extends Agent {

    public Wolf(int x, int y) {
        super(x, y);
    }

    @Override
    public void decide(Environment env) {
        if (!(env instanceof GridEnvironment)) {
            return;
        }
        GridEnvironment gridEnv = (GridEnvironment) env;

        Sheep closestSheep = findClosestSheep(gridEnv.getAgents());

        if (closestSheep == null) {
            return;
        }

        int dx = Integer.compare(closestSheep.getX(), this.x);
        int dy = Integer.compare(closestSheep.getY(), this.y);

        int newX = this.x + dx;
        int newY = this.y + dy;

        if (gridEnv.isValidPosition(newX, newY)) {
            setPosition(newX, newY);
        }
    }

    private Sheep findClosestSheep(List<Agent> agents) {
        Sheep closest = null;
        double minDist = Double.MAX_VALUE;

        for (Agent a : agents) {
            if (a instanceof Sheep) {
                double dist = distance(a.getX(), a.getY(), this.x, this.y);
                if (dist < minDist) {
                    minDist = dist;
                    closest = (Sheep) a;
                }
            }
        }
        return closest;
    }

    private double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
