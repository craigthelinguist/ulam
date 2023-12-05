package ulam;

import org.junit.Test;

import static org.junit.Assert.*;

public class UlamSpiralTest {

    @Test
    public void test1x1Spiral() {
        var spiral = new UlamSpiral(1);
        boolean[][] expected = new boolean[][] {
                {false}
        };
        assertArrayEquals(spiral.data, expected);
    }

    @Test
    public void test3x3Spiral() {
        var spiral = new UlamSpiral(3);
        boolean[][] expected = new boolean[][]{
                {false, false, true},  // 8 1 2
                {true, false, true},   // 7 0 3
                {false, true, false}   // 6 5 4
        };
        assertArrayEquals(spiral.data, expected);
    }

    @Test
    public void test5x5Spiral() {
        var spiral = new UlamSpiral(4);
        boolean[][] expected = new boolean[][]{
                {},
                {},
                {},
                {},
                {},
        };
        assertArrayEquals(spiral.data, expected);
    }

}