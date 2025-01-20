package sma.Abstract;

import sma.Abstract.Agent;

import java.util.List;

public abstract class Environment {

    public abstract List<Agent> getAgents();

    public abstract void addAgent(Agent agent);

    public abstract void printEnvironment();

    public abstract boolean isValidPosition(int x, int y);
}
