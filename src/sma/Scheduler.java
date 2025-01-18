package sma;

/**
 * Gère l'ordonnancement (le "tour par tour") de la simulation.
 * C'est un squelette : à vous d'implémenter comment l'ordonnancement est fait
 * (ordonnancement centralisé, parallèle, pseudo-aléatoire, etc.).
 */
public abstract class Scheduler {

    protected Environment environment;
    protected int nbTicks;  // Nombre de tours de simulation (exemple basique)

    public Scheduler(Environment env, int nbTicks) {
        this.environment = env;
        this.nbTicks = nbTicks;
    }

    /**
     * Boucle principale de simulation.
     * Les classes concrètes décideront comment elles font tourner le système (ordre des agents, etc.).
     */
    public abstract void runSimulation();
}
