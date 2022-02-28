package shipping;

public class InternationalPackage extends Transportable {
private String destinationCountry;
private long distance;

    public InternationalPackage(long weight, boolean breakable, String destinationCountry, long distance) {
        super(weight, breakable);
        this.destinationCountry = destinationCountry;
        this.distance = distance;
    }

    public String getDestinationCountry() {
        return destinationCountry;
    }

    public long getDistance() {
        return distance;
    }
}
