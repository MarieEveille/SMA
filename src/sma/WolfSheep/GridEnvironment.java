package sma.WolfSheep;

import sma.Abstract.Agent;
import sma.Abstract.Environment;
import sma.WolfSheep.Sheep;
import sma.WolfSheep.Wolf;

import java.util.ArrayList;
import java.util.List;


public class GridEnvironment extends Environment {

    private int width;
    private int height;
    private List<Agent> agents;

    public GridEnvironment(int width, int height) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>();
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
    public void printEnvironment() {
        char[][] grid = new char[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = '.';
            }
        }
        for (Agent a : agents) {
            if (isValidPosition(a.getX(), a.getY())) {
                char symbol = '?'; // défaut
                if (a instanceof Wolf) symbol = 'W';
                if (a instanceof Sheep) symbol = 'S';
                grid[a.getY()][a.getX()] = symbol;
            }
        }
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    @Override
    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
