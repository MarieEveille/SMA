package sma;

import java.util.Random;

public class RandomAgent extends Agent {

    private Random random;

    public RandomAgent(int x, int y) {
        super(x, y);
        this.random = new Random();
    }

    @Override
    public void decide(Environment env) {
        // Exemple : se déplace dans l’une des 4 directions aléatoirement
        int dx = 0;
        int dy = 0;
        switch(random.nextInt(4)) {
            case 0: dx = 1; break;   // Droite
            case 1: dx = -1; break;  // Gauche
            case 2: dy = 1; break;   // Bas
            case 3: dy = -1; break;  // Haut
        }

        int newX = x + dx;
        int newY = y + dy;

        // On vérifie si la position est valide dans l'environnement
        if (env.isValidPosition(newX, newY)) {
            setPosition(newX, newY);
        }

        // Ici, on pourrait faire d’autres actions, comme interagir avec d’autres agents, etc.
    }
}
