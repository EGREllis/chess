package net.ellise.backend.model;

public record Point(int x, int y) {
    @Override
    public boolean equals(Object obj) {
        boolean result = false;
        if (obj instanceof Point) {
            Point other = (Point)obj;
            result = x == other.x && y == other.y;
        }
        return result;
    }

    @Override
    public int hashCode() {
        return x + (8 * y);
    }

    public String toString() {
        return String.format("(%1$d,%2$d)", x, y);
    }

    public Point apply(Vector vector) {
        return new Point(x + vector.dx(), y + vector.dy());
    }
}
