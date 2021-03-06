package me.cwpark.chapter3.item10;


/*
 * Transitive: For any non-null reference values x,y,z
 *  if x.equals(y) returns true and y.equals(z) returns true,
 *  then x.equals(z) must return true
 */
public class Transitivity {
    public static void main(String[] args) {
        Point p = new Point(1, 2);
        ColorPoint cp = new ColorPoint(1, 2, Color.RED);

        boolean bool1 = p.equals(cp);
        boolean bool2 = cp.equals(p);

        System.out.println(bool1);
        System.out.println(bool2);

        ColorPoint p1 = new ColorPoint(1, 2, Color.RED);
        Point p2 = new Point(1, 2);
        ColorPoint p3 = new ColorPoint(1, 2, Color.BLUE);

    }

    private static class Point {
        private final int x;
        private final int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (!(o instanceof Point))
                return false;
            Point p = (Point) o;
            return p.x == x && p.y == y;
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
