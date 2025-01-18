package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Environnement concret représentant une grille 2D
 * où certaines cases contiennent de la nourriture (food).
 */
public class AntFoodEnvironment extends Environment {

    private int width;
    private int height;

    private boolean[][] food;  // true si la case (x, y) contient de la nourriture
    private List<Agent> agents;

    public AntFoodEnvironment(int width, int height) {
        this.width = width;
        this.height = height;
        this.agents = new ArrayList<>();

        // On initialise la grille de nourriture avec, par exemple,
        // 20 % de chances d'avoir de la nourriture dans chaque case
        food = new boolean[height][width];
        Random rand = new Random();
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                // 20% de chances de mettre de la nourriture
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

    /**
     * Retire la nourriture de la case (x, y) si elle existe.
     */
    public void pickupFoodAt(int x, int y) {
        if (isValidPosition(x, y)) {
            food[y][x] = false;
        }
    }

    /**
     * Indique si la case (x, y) contient de la nourriture.
     */
    public boolean hasFoodAt(int x, int y) {
        if (!isValidPosition(x, y)) {
            return false;
        }
        return food[y][x];
    }

    @Override
    public void printEnvironment() {
        // Création d'une matrice de caractères pour afficher l'état
        char[][] grid = new char[height][width];

        // Initialisation de la grille avec '.' s'il n'y a ni agent ni nourriture
        // et 'F' s'il y a de la nourriture
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = food[y][x] ? 'F' : '.';
            }
        }

        // On place les agents
        for (Agent agent : agents) {
            int ax = agent.getX();
            int ay = agent.getY();
            if (isValidPosition(ax, ay)) {
                // On choisit 'A' pour représenter une fourmi
                // Si la case contient aussi de la nourriture, vous pouvez changer le symbole.
                grid[ay][ax] = 'A';
            }
        }

        // Affichage
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print(grid[y][x]);
            }
            System.out.println();
        }
    }

    // Getters si besoin
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
