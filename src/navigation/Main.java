package navigation;

import java.util.Map;
import java.util.Scanner;
import java.util.function.Supplier;

public class Main {

    public static void main(String[] args) {
        Location home = new Location("AITU", 0, 0);
        Location mall = new Location("Khan Shatyr", 6, 4);

        Map<String, Supplier<RouteStrategy>> strategies = Map.of(
                "car", CarStrategy::new,
                "walk", WalkStrategy::new,
                "cycle", CycleStrategy::new,
                "bus", BusStrategy::new
        );

        Navigator navigator = new Navigator(new CarStrategy());
        System.out.println("=== Default strategy ===");
        System.out.println(navigator.planRoute(home, mall));

        System.out.println("\n=== Switching strategy at runtime ===");
        for (String mode : new String[]{"walk", "cycle", "bus"}) {
            navigator.setStrategy(strategies.get(mode).get());
            System.out.println(navigator.planRoute(home, mall));
        }

        System.out.println("\n=== Interactive mode (type car/walk/cycle/bus, or exit) ===");
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.print("> ");
            if (!scanner.hasNextLine()) break;
            String input = scanner.nextLine().trim().toLowerCase();
            if (input.equals("exit")) break;
            Supplier<RouteStrategy> factory = strategies.get(input);
            if (factory == null) {
                System.out.println("Unknown mode: " + input);
                continue;
            }
            navigator.setStrategy(factory.get());
            System.out.println(navigator.planRoute(home, mall));
        }
    }
}