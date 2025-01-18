package sma;

import java.util.List;

/**
 * Un loup qui se rapproche du mouton le plus proche.
 */
public class Wolf extends Agent {

    public Wolf(int x, int y) {
        super(x, y);
    }

    @Override
    public void decide(Environment env) {
        // On cast l'environnement en GridEnvironment si on a besoin de méthodes spécifiques
        if (!(env instanceof GridEnvironment)) {
            return; // ou lever une exception
        }
        GridEnvironment gridEnv = (GridEnvironment) env;

        // 1. Trouver le mouton le plus proche
        Sheep closestSheep = findClosestSheep(gridEnv.getAgents());

        if (closestSheep == null) {
            // Pas de mouton => le loup ne fait rien
            return;
        }

        // 2. Se déplacer d'une case vers ce mouton
        int dx = Integer.compare(closestSheep.getX(), this.x); // renvoie -1, 0 ou 1
        int dy = Integer.compare(closestSheep.getY(), this.y);

        int newX = this.x + dx;
        int newY = this.y + dy;

        // 3. Vérifier si la position est valide, puis s'y déplacer
        if (gridEnv.isValidPosition(newX, newY)) {
            setPosition(newX, newY);
        }
    }

    /**
     * Retourne le mouton le plus proche parmi la liste d'agents, ou null si aucun mouton.
     */
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

    // Méthode utilitaire pour calculer la distance euclidienne (ou manhattan)
    private double distance(int x1, int y1, int x2, int y2) {
        // distance euclidienne
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }
}
