package ulam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.io.File;
import java.io.IOException;

public class Main {


    public static void main(String[] args) {

        var spiral = new UlamSpiral(1000);
        var image = spiral.toImage();

        String fpath = "assets/ulam.png";
        File outputFile = new File(fpath);
        try {
            ImageIO.write(image, "png", outputFile);
            System.out.printf("saved image to `%s`", fpath);
        } catch (IOException ioe) {
            System.err.println(ioe.getMessage());
        }

        ImagePanel imagePanel = new ImagePanel(image);

        JFrame frame = new JFrame();
        frame.add(imagePanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setVisible(true);

    }
}