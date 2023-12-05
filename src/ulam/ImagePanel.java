package ulam;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class which represents an image in a JPanel.
 */
public class ImagePanel extends JPanel {

    private final BufferedImage image;

    public ImagePanel(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(this.image, 0, 0, this);
    }

}
