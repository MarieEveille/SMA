package sma.Abstract;

public abstract class Agent {
    protected int x;
    protected int y;

    public Agent(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public abstract void decide(Environment env);

    public int getX() { return x; }
    public int getY() { return y; }

    protected void setPosition(int newX, int newY) {
        this.x = newX;
        this.y = newY;
    }
}
