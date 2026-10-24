package navigation;

import java.util.List;

public class CarStrategy implements RouteStrategy {

    private static final double ROAD_FACTOR = 1.3;
    private static final double SPEED_KMH = 50.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceTo(to) * ROAD_FACTOR;
        int minutes = (int) Math.round(distance / SPEED_KMH * 60);
        return new Route("Car", distance, minutes,
                List.of(from.name(), "Main avenue", "Ring road", to.name()));
    }
}