package navigation;

import java.util.List;

public class BusStrategy implements RouteStrategy {

    private static final double ROUTE_FACTOR = 1.4;
    private static final double SPEED_KMH = 25.0;
    private static final int WAITING_MINUTES = 5;

    @Override
    public Route buildRoute(Location from, Location to) {
        double distance = from.straightLineDistanceTo(to) * ROUTE_FACTOR;
        int minutes = (int) Math.round(distance / SPEED_KMH * 60) + WAITING_MINUTES;
        return new Route("Bus", distance, minutes,
                List.of(from.name(), "Bus stop", "Bus #12", to.name()));
    }
}