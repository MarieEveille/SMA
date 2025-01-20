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
            for (Agent agent : environment.getAgents()) {
                agent.decide(environment);
            }
            environment.printEnvironment();
            System.out.println();

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
