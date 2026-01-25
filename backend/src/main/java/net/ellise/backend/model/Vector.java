package net.ellise.backend.model;

public record Vector(int dx, int dy) {
    public static Vector NULL_ADDITION = new Vector(0,0);
    public static Vector NORTH = new Vector(0, -1);
    public static Vector SOUTH = new Vector(0, 1);
    public static Vector WEST = new Vector(-1, 0);
    public static Vector EAST = new Vector(1, 0);

    public Vector add(Vector vector) {
        return new Vector(dx + vector.dx(), dy + vector.dy());
    }

    public Vector multiply(Vector vector) {
        return new Vector(dx * vector.dx(), dy * vector.dy());
    }
}
