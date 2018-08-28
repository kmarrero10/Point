package com.kylemarrero;


import edu.princeton.cs.algs4.StdDraw;

import java.util.Comparator;

public class Point implements Comparable<Point> {

    private final int x, y; //x and y coords of given point

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public void draw() {
        StdDraw.point(x, y);
    }

    public void drawTo(Point that) {
        StdDraw.line(this.x, this.y, that.x, that.y);
    }

    public String toString() {
        return "(" + x + ", " + y + ")";
    }

    public int compareTo(Point that) {

        return 0;
    }

    public double slopeTo(Point that) {
        double xSlope = that.x - this.x;
        double ySlope = that.y - this.y;
        if (that.x == this.x && that.y == this.y) { return Double.NEGATIVE_INFINITY; }
        if (ySlope == 0){ return 0; }
        if (xSlope == 0){ return Double.POSITIVE_INFINITY; }

        return (ySlope) / (xSlope);
    }

    public Comparator<Point> slopeOrder() {
        return new Comparator<Point>() {
            @Override
            public int compare(Point o1, Point o2) {
                return 0;
            }
        };
    }

    public static void main(String[] args) {
	    Point point1 = new Point(2, 3);
	    Point point2 = new Point(-2, 3);

        System.out.println(point1.slopeTo(point2));
    }
}
