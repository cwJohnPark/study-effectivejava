package me.cwpark.chatper3.item10;

import java.util.Objects;
import java.util.Set;

public class ComplyWithLiskov {

    /*
     * Favor composition over inheritance(Item 18)
     * Adds a value component without violating the equals contract
     */
    private static class ColorPoint {
        private final Point point;
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            point = new Point(x, y);
            this.color = Objects.requireNonNull(color);
        }

        // Broken - violates symmetry!
        @Override public boolean equals(Object o) {
            if (!(o instanceof ColorPoint))
                return false;
            ColorPoint cp = (ColorPoint) o;

            return cp.point.equals(this.point) && cp.color.equals(this.color);
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    enum Color {
        RED, BLUE
    }


    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override public boolean equals(Object o) {
            if (!(o instanceof Point) || o.getClass() != getClass())
                return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        private static final Set<Point> unitCircle = Set.of(
                new Point(1, 0), new Point(0, 1),
                new Point(-1, 0), new Point(0, -1));

        public static boolean onUnitCircle(Point p) {
            return unitCircle.contains(p);
        }
    }
}
