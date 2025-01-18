package sma;

import sma.Abstract.Agent;
import sma.Abstract.Environment;
import sma.Abstract.Scheduler;

public class BasicScheduler extends Scheduler {

    public BasicScheduler(Environment env, int nbTicks) {
        super(env, nbTicks);
    }

    @Override
    public void runSimulation() {
        for (int t = 0; t < nbTicks; t++) {
            System.out.println("===== Tick " + t + " =====");
            // 1. On fait agir chaque agent
            for (Agent agent : environment.getAgents()) {
                agent.decide(environment);
            }
            // 2. On affiche l'environnement
            environment.printEnvironment();
            System.out.println();

            // Petite pause (optionnelle) pour visualiser

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
