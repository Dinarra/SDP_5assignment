package navigation;

public record Location(String name, double x, double y) {

    public double straightLineDistanceTo(Location other) {
        double dx = other.x - this.x;
        double dy = other.y - this.y;
        return Math.sqrt(dx * dx + dy * dy);
    }
}