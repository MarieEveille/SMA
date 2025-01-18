package sma;

import java.util.List;

/**
 * Représente un environnement générique.
 * Les classes concrètes doivent définir comment les agents sont stockés et
 * comment on gère leurs interactions/spatialisation/etc.
 */
public abstract class Environment {

    /**
     * Retourne la liste de tous les agents présents dans l'environnement.
     * La gestion de la liste (ou d'une autre structure de données) se fera
     * dans la classe fille.
     */
    public abstract List<Agent> getAgents();

    /**
     * Ajoute un agent dans l'environnement.
     * La manière de l'ajouter (dans une liste, dans une grille, etc.) est laissée aux classes concrètes.
     * @param agent l'agent à ajouter
     */
    public abstract void addAgent(Agent agent);

    /**
     * Affiche ou décrit l'état de l'environnement dans un terminal (ou logger).
     * Les classes concrètes peuvent l'implémenter sous forme de grille, de liste d'états, etc.
     */
    public abstract void printEnvironment();

    /**
     * Vérifie si une position est valide dans l'environnement (si l'environnement est spatial).
     * Dans un environnement non-spatial, cette méthode peut être vide
     * ou se limiter à retourner true.
     */
    public abstract boolean isValidPosition(int x, int y);
}
