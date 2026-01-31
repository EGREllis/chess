package net.ellise.backend.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public record Vector(int dx, int dy) {
    public static Vector NULL_ADDITION = new Vector(0,0);
    public static Vector NORTH = new Vector(0, -1);
    public static Vector NORTH_EAST = new Vector(1, -1);
    public static Vector EAST = new Vector(1, 0);
    public static Vector SOUTH_EAST = new Vector(1, 1);
    public static Vector SOUTH = new Vector(0, 1);
    public static Vector SOUTH_WEST = new Vector(-1,1);
    public static Vector WEST = new Vector(-1, 0);
    public static Vector NORTH_WEST = new Vector(-1,-1);
    public static Set<Vector> ALL_NON_ZERO;
    public static Set<Vector> CARDINALS = Collections.unmodifiableSet(Set.of(
            NORTH, EAST, SOUTH, WEST
    ));
    public static Set<Vector> DIAGONALS = Collections.unmodifiableSet(Set.of(
            NORTH_EAST, SOUTH_EAST, SOUTH_WEST, NORTH_WEST
    ));
    public static Set<Vector> KNIGHTS = Collections.unmodifiableSet(
            Set.of( NORTH.add(NORTH.add(EAST)),
                    NORTH.add(EAST.add(EAST)),
                    SOUTH.add(EAST.add(EAST)),
                    SOUTH.add(SOUTH.add(EAST)),
                    SOUTH.add(SOUTH.add(WEST)),
                    SOUTH.add(WEST.add(WEST)),
                    NORTH.add(WEST.add(WEST)),
                    NORTH.add(NORTH.add(WEST))
            ));

    static {
        Set<Vector> allNonZero = new HashSet<>();
        allNonZero.addAll(CARDINALS);
        allNonZero.addAll(DIAGONALS);
        ALL_NON_ZERO = Collections.unmodifiableSet(allNonZero);
    }

    public Vector add(Vector vector) {
        return new Vector(dx + vector.dx(), dy + vector.dy());
    }

    public Vector multiply(Vector vector) {
        return new Vector(dx * vector.dx(), dy * vector.dy());
    }
}
