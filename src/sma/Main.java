package sma;

import sma.Ant.AntFoodEnvironment;
import sma.Ant.GreedyAnt;
import sma.Ant.LazyAnt;
import sma.Ant.RandomAnt;
import sma.WolfSheep.GridEnvironment;
import sma.WolfSheep.Sheep;
import sma.WolfSheep.Wolf;

public class Main {
    public static void main(String[] args) {

        GridEnvironment env = new GridEnvironment(10, 5);

        env.addAgent(new Sheep(5, 2));
        env.addAgent(new Sheep(5, 3));
        env.addAgent(new Wolf(3, 5));

        BasicScheduler scheduler = new BasicScheduler(env, 5);

        scheduler.runSimulation();

        System.out.println("Simulation terminée !");

        /*

        AntFoodEnvironment env = new AntFoodEnvironment(15, 8);

        env.addAgent(new RandomAnt(0, 0));
        env.addAgent(new RandomAnt(14, 7));

        env.addAgent(new GreedyAnt(3, 3));
        env.addAgent(new GreedyAnt(12, 2));

        env.addAgent(new LazyAnt(7, 4));

        BasicScheduler scheduler = new BasicScheduler(env, 15);

        scheduler.runSimulation();

        System.out.println("Simulation terminée !");

         */
    }
}
