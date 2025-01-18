package sma;

import java.util.Random;

public abstract class Agent {
    protected int x;
    protected int y;

    // Constructeur
    public Agent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    // Méthode principale d'action de l'agent
    // Elle prend l'environnement en paramètre pour connaître l'état global
    public abstract void decide(Environment env);

    // Méthodes d'accès
    public int getX() { return x; }
    public int getY() { return y; }

    // Pour changer la position (après décision)
    protected void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
