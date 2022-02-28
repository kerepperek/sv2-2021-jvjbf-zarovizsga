package shipping;

public abstract class Transportable {

    private long weight;
    private boolean breakable;

    public Transportable(long weight, boolean breakable) {
        this.weight = weight;
        this.breakable = breakable;
    }

    public long getWeight() {
        return weight;
    }

    public boolean isBreakable() {
        return breakable;
    }
}
