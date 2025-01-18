package sma;

import sma.Ant.AntFoodEnvironment;
import sma.Ant.GreedyAnt;
import sma.Ant.LazyAnt;
import sma.Ant.RandomAnt;

public class Main {
    public static void main(String[] args) {
        /*
        GridEnvironment env = new GridEnvironment(10, 5);

        // 2. Ajouter des agents (loups, moutons)
        // On peut tester avec 2 moutons et 1 loup
        env.addAgent(new Sheep(2, 2));
        env.addAgent(new Sheep(4, 3));
        env.addAgent(new Wolf(3, 5));

        // 3. Créer un scheduler
        BasicScheduler scheduler = new BasicScheduler(env, 10); // 10 tours

        // 4. Lancer la simulation
        scheduler.runSimulation();

        System.out.println("Simulation terminée !");

        */

        AntFoodEnvironment env = new AntFoodEnvironment(15, 8);

        // 2. Ajouter différentes fourmis
        //    (positions initiales choisies arbitrairement)
        env.addAgent(new RandomAnt(0, 0));
        env.addAgent(new RandomAnt(14, 7));

        env.addAgent(new GreedyAnt(3, 3));
        env.addAgent(new GreedyAnt(12, 2));

        env.addAgent(new LazyAnt(7, 4));

        // 3. Créer un scheduler basique
        BasicScheduler scheduler = new BasicScheduler(env, 15);  // 15 tours

        // 4. Lancer la simulation
        scheduler.runSimulation();

        System.out.println("Simulation terminée !");
    }
}
