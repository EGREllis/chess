package net.ellise.backend.model;

import java.util.HashSet;
import java.util.Set;

public class Util {
    private static final int MIN_X = 0;
    private static final int MAX_X = 7;
    private static final int MIN_Y = 0;
    private static final int MAX_Y = 7;

    public static Set<Point> cropToBoard(Set<Point> points) {
        Set<Point> results = new HashSet<>();
        for (Point destination : points) {
            if (isOnBoard(destination)) {
                results.add(destination);
            }
        }
        return results;
    }

    public static boolean isOnBoard(Point point) {
        return point.x() >= MIN_X &&
                point.x() <= MAX_X &&
                point.y() >= MIN_Y &&
                point.y() <= MAX_Y;
    }
}
