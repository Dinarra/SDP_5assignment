package navigation;

import java.util.List;

public class WalkStrategy implements RouteStrategy {

    private static final double PATH_FACTOR = 1.1;
    private static final double SPEED_KMH = 5.0;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceTo(to) * PATH_FACTOR;
        int minutes = (int) Math.round(distance / SPEED_KMH * 60);
        return new Route("Walk", distance, minutes,
                List.of(from.name(), "Pedestrian street", "Park path", to.name()));
    }
}