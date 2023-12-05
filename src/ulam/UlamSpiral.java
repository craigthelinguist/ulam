package ulam;

import java.awt.*;
import java.awt.image.BufferedImage;

public class UlamSpiral {

    private final int width;

    protected boolean[][] data;

    private enum Direction {
        LEFT, RIGHT, UP, DOWN;

        private static Direction next(Direction direction) {
            return switch (direction) {
                case UP -> Direction.RIGHT;
                case RIGHT -> Direction.DOWN;
                case DOWN -> Direction.LEFT;
                case LEFT -> Direction.UP;
            };
        }

    }

    public UlamSpiral(int width) {
        if (width % 2 == 0) {
            width++;
        }
        this.width = width;
        this.data = createSpiral(width);
    }

    public BufferedImage toImage() {
        var image = new BufferedImage(this.width, this.width, BufferedImage.TYPE_INT_ARGB);
        var primeColour = new Color(100, 250, 150, 150).getRGB();
        var nonPrimeColour = new Color(100, 100, 220, 150).getRGB();
        for (int row = 0; row < this.width; row++) {
            for (int col = 0; col < this.width; col++) {
                image.setRGB(row, col, this.data[row][col] ? primeColour : nonPrimeColour);
            }
        }
        return image;
    }

    private boolean[][] createSpiral(int width) {
        boolean[][] spiral = new boolean[width][width];

        int x = width/2;
        int y = width/2;
        Direction direction = Direction.UP;
        int magnitude = 1;
        int directionSwitch = 0;

        int number = 0;

        while (true) {
            switch (direction) {
                case UP -> {
                    for (int i = 0; i < magnitude && y >= 0; i++, y--, number++) {
                       spiral[y][x] = Primes.isPrime(number);
                    }
                }
                case RIGHT -> {
                    for (int i = 0; i < magnitude && x <= width; i++, x++, number++) {
                        spiral[y][x] = Primes.isPrime(number);
                    }
                }
                case DOWN -> {
                    for (int i = 0; i < magnitude && y <= width; i++, y++, number++) {
                        spiral[y][x] = Primes.isPrime(number);
                    }
                }
                case LEFT -> {
                    for (int i = 0; i < magnitude && x >= 0; i++, x--, number++) {
                        spiral[y][x] = Primes.isPrime(number);
                    }
                }
            }

            if (y < 0 || y >= width || x < 0 || x >= width) {
                break;
            }

            direction = Direction.next(direction);

            // increase magnitude every time you go between horizontal and vertical
            directionSwitch = (directionSwitch + 1) % 2;
            if (directionSwitch == 0) {
                magnitude++;
            }

        }

        return spiral;
    }

}
