package navigation;

import java.util.List;

public class CycleStrategy implements RouteStrategy {

    private static final double PATH_FACTOR = 1.2;
    private static final double SPEED_KMH = 15.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceTo(to) * PATH_FACTOR;
        int minutes = (int) Math.round(distance / SPEED_KMH * 60);
        return new Route("Cycle", distance, minutes,
                List.of(from.name(), "Bike lane", "Embankment", to.name()));
    }
}