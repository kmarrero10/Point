package com.kylemarrero;

import java.util.ArrayList;
import java.util.Arrays;

public class BruteCollinearPoints {

    private ArrayList<LineSegment> lineSegments = new ArrayList<>();

    public BruteCollinearPoints(Point[] points) {
        Arrays.sort(points);
        int length = points.length;

        for (int i = 1; i < length; i++) {
            if (points[i].compareTo(points[i - 1]) == 0) {
                throw new IllegalArgumentException();
            }
        }

        for (int p = 0; p < length; p++)
            for (int q = p + 1; q < length; q++)
                for (int r = q + 1; r < length; r++)
                    for (int s = r + 1; s < length; s++) {
                        Point p1 = points[p], p2 = points[q], p3 = points[r], p4 = points[s];

                        if (p1.slopeTo(p2) == p1.slopeTo(p3) && p1.slopeTo(p2) == p1.slopeTo(p4)) {
                            lineSegments.add(new LineSegment(p1, p4));
                        }

                    }

    }

    public int numberOfSegments () {
        return lineSegments.size();
    }

    public LineSegment[] segments () {
        LineSegment[] segments = new LineSegment[lineSegments.size()];

        return lineSegments.toArray(segments);
    }
}
