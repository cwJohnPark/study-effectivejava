package me.cwpark.chatper3.item10;

import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class ViolateLiskov {

    public static void main(String[] args) {
        // The onUnitCircle method will return false regardless of the CounterPoint instance's x and y coordinates
        boolean isOnUnitCircle = Point.onUnitCircle(new CounterPoint(1, 0));
        System.out.println(isOnUnitCircle);
    }

    private static class CounterPoint extends Point {
        private static final AtomicInteger counter = new AtomicInteger();

        public CounterPoint(int x, int y) {
            super(x, y);
            counter.incrementAndGet();
        }

        public static int numberCreated() { return counter.get(); }
    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        // Broken - violates Liskov substitution
        @Override public boolean equals(Object o) {
            // getClass-based equals method violates Liskov substitution principle
            if (!(o instanceof Point) || o.getClass() != getClass())
                return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
        }

        // Initialize unitCircle to contain all Points on the unit Circle
        private static final Set<Point> unitCircle = Set.of(
                new Point(1, 0), new Point(0, 1),
                new Point(-1, 0), new Point(0, -1));

        public static boolean onUnitCircle(Point p) {
            return unitCircle.contains(p);
        }
    }

    private static class ColorPoint extends Point {
        private final Color color;

        public ColorPoint(int x, int y, Color color) {
            super(x, y);
            this.color = color;
        }

        // Broken - violates symmetry!
        @Override public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;

            // If o is a normal Point, do a color-blind comparison
            if (!(o instanceof ColorPoint))
                return o.equals(this);

            return super.equals(o) && ((ColorPoint) o).color == color;
        }

        @Override
        public int hashCode() {
            return 0;
        }
    }

    enum Color {
        RED, BLUE
    }
}
