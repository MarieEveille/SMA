package sma;

import java.util.ArrayList;
import java.util.List;

/**
 * Environnement concret en forme de grille 2D.
 */
public class GridEnvironment extends Environment {

    private int width;
    private int height;
    private List<Agent> agents; // On stocke simplement tous les agents dans une liste

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
        // Création d'une matrice de caractères pour l'affichage
        char[][] grid = new char[height][width];
        // On remplit tout avec '.'
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                grid[y][x] = '.';
            }
        }
        // On place chaque agent : 'W' pour Wolf, 'S' pour Sheep (ou tout autre symbole)
        for (Agent a : agents) {
            if (isValidPosition(a.getX(), a.getY())) {
                char symbol = '?'; // défaut
                if (a instanceof Wolf) symbol = 'W';
                if (a instanceof Sheep) symbol = 'S';
                grid[a.getY()][a.getX()] = symbol;
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

    @Override
    public boolean isValidPosition(int x, int y) {
        return (x >= 0 && x < width && y >= 0 && y < height);
    }

    // Getters pour la taille de la grille (si besoin)
    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
}
