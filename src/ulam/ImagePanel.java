package ulam;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;

/**
 * A class which represents an image in a JPanel.
 */
public class ImagePanel extends JPanel {

    private BufferedImage image;

    public ImagePanel(int width) {
        this.setPreferredSize(new Dimension(width, width));
    }

    public void updateImage(BufferedImage image) {
        this.image = image;
        this.setPreferredSize(new Dimension(image.getWidth(), image.getHeight()));
    }

    public BufferedImage getImage() {
        return this.image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        if (this.image != null) {
            g.drawImage(this.image, 0, 0, this);
        }
    }

}
