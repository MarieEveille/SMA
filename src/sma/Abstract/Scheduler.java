package sma.Abstract;

import sma.Abstract.Environment;


public abstract class Scheduler {

    protected Environment environment;
    protected int nbTicks;  // Nombre de tours de simulation (exemple basique)

    public Scheduler(Environment env, int nbTicks) {
        this.environment = env;
        this.nbTicks = nbTicks;
    }

    public abstract void runSimulation();
}
