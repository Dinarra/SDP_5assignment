# Strategy Pattern - Navigation / Route Planning

Assignment #5, ShP-2216 Software Design Patterns (Java 17).

## Description
A simple navigator that builds a route between two points using interchangeable
strategies (car, walk, cycle, bus). The strategy can be switched at runtime.

## Structure
src/navigation/
- RouteStrategy.java - Strategy interface
- CarStrategy.java, WalkStrategy.java, CycleStrategy.java, BusStrategy.java - concrete strategies
- Navigator.java - Context
- Main.java - Client
- Location.java, Route.java - data records

## Build and run
    mkdir out
    javac -d out src/navigation/*.java
    java -cp out navigation.Main

Or open the project in IntelliJ IDEA (JDK 17) and run Main.

## How to add a new strategy
1. Create a class, for example ScooterStrategy, that implements RouteStrategy and write buildRoute.
2. Add one line to the map in Main: "scooter", ScooterStrategy::new
3. Navigator and the existing strategies stay unchanged.