package net.ellise.backend.model;

public record Point(int x, int y) implements Comparable<Point> {
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

    @Override
    public int compareTo(Point other) {
        if (other.y > y) {
            return 1;
        } else if (other.y < y) {
            return -1;
        } else if (other.x > x) {
            return 1;
        } else if (other.x < x) {
            return -1;
        } else {
            return 0;
        }
    }
}
