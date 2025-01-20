package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class AntFoodEnvironment extends Environment {

    private int width;
    private int height;

    private boolean[][] food;
    private List<Agent> agents;

    public AntFoodEnvironment(int width, int height) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>();

        food = new boolean[height][width];
        Random rand = new Random();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                food[y][x] = (rand.nextDouble() < 0.2);
            }
        }
    }

    @Override
    public List<Agent> getAgents() {
        return agents;
    }

    @Override
    public void addAgent(Agent agent) {
        agents.add(agent);
    }

    @Override
    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public void pickupFoodAt(int x, int y) {
        if (isValidPosition(x, y)) {
            food[y][x] = false;
        }
    }

    public boolean hasFoodAt(int x, int y) {
        if (!isValidPosition(x, y)) {
            return false;
        }
        return food[y][x];
    }

    @Override
    public void printEnvironment() {
        char[][] grid = new char[height][width];

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = food[y][x] ? 'F' : '.';
            }
        }

        for (Agent agent : agents) {
            int ax = agent.getX();
            int ay = agent.getY();
            if (isValidPosition(ax, ay)) {
                grid[ay][ax] = 'A';
            }
        }

        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
