package navigation;

import java.util.List;

public record Route(String mode, double distanceKm, int durationMinutes, List<String> steps) {

    @Override
    public String toString() {
        return String.format("[%s] %.1f km, %d min%n  %s",
                mode, distanceKm, durationMinutes, String.join(" -> ", steps));
    }
}