package net.ellise.backend.model;

public record Vector(int dx, int dy, VectorType vectorType) {
    public static Vector NORTH = new Vector(0, -1, VectorType.FIXED_POINT);
    public static Vector SOUTH = new Vector(0, 1, VectorType.FIXED_POINT);
    public static Vector WEST = new Vector(-1, 0, VectorType.FIXED_POINT);
    public static Vector EAST = new Vector(1, 0, VectorType.FIXED_POINT);

    public Vector add(Vector vector) {
        return new Vector(dx + vector.dx(), dy + vector.dy(), vectorType);
    }

    public Vector multiply(Vector vector) {
        return new Vector(dx * vector.dx(), dy * vector.dy(), vectorType);
    }
}
