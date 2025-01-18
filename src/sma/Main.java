package sma;

public class Main {
    public static void main(String[] args) {
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
    }
}
