package sma.Ant;

import sma.Abstract.Agent;
import sma.Abstract.Environment;

import java.util.Random;

/**
 * Une fourmi qui se déplace aléatoirement sur la grille,
 * et qui ramasse la nourriture si elle se trouve dessus par hasard.
 */
public class RandomAnt extends Agent {

    private Random rand;

    public RandomAnt(int x, int y) {
        super(x, y);
        this.rand = new Random();
    }

    @Override
    public void decide(Environment env) {
        // On vérifie qu'on est bien dans AntFoodEnvironment
        if (!(env instanceof AntFoodEnvironment)) {
            return;
        }
        AntFoodEnvironment afe = (AntFoodEnvironment) env;

        // 1. Se déplacer d'une case dans l'une des 4 directions (haut, bas, gauche, droite) aléatoirement
        int dx = 0;
        int dy = 0;
        switch (rand.nextInt(4)) {
            case 0 -> dx = 1;   // droite
            case 1 -> dx = -1;  // gauche
            case 2 -> dy = 1;   // bas
            case 3 -> dy = -1;  // haut
        }

        int newX = this.x + dx;
        int newY = this.y + dy;

        // 2. Vérifier que la case est valide
        if (afe.isValidPosition(newX, newY)) {
            setPosition(newX, newY);

            // 3. Si on tombe sur de la nourriture, on la ramasse
            if (afe.hasFoodAt(newX, newY)) {
                afe.pickupFoodAt(newX, newY);
            }
        }
    }
}
