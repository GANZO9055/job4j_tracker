package ru.job4j.oop;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class PointTest {
    @Test
    void when00to20then2() {
        double expected = 2;
        Point c = new Point(0, 0);
        Point d = new Point(2, 0);
        double out = c.distance(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when11to22then1Dot41() {
        double expected = 1.41;
        Point c = new Point(1, 1);
        Point d = new Point(2, 2);
        double out = c.distance(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when32to61then3Dot16() {
        double expected = 3.16;
        Point c = new Point(3, 2);
        Point d = new Point(6, 1);
        double out = c.distance(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when02to20then2Dot82() {
        double expected = 2.82;
        Point c = new Point(0, 2);
        Point d = new Point(2, 0);
        double out = c.distance(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when000to023then3Dot6() {
        double expected = 3.6;
        Point c = new Point(0, 0, 0);
        Point d = new Point(0, 2, 3);
        double out = c.distance3d(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }

    @Test
    void when154to023then3Dot31() {
        double expected = 3.31;
        Point c = new Point(1, 5, 4);
        Point d = new Point(0, 2, 3);
        double out = c.distance3d(d);
        assertThat(out).isEqualTo(expected, withPrecision(0.01));
    }
}