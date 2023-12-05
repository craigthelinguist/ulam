package ulam;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class Gui {

    private final JFrame frame;
    private final ImagePanel imagePanel;

    public Gui() {
        this.frame = new JFrame();

        this.imagePanel = new ImagePanel(800);
        this.frame.add(imagePanel, BorderLayout.CENTER);

        JPanel savePanel = this.makeSavePanel();
        this.frame.add(savePanel, BorderLayout.SOUTH);

        this.frame.pack();
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.frame.setResizable(false);
    }

    public void start() {
        this.frame.setVisible(true);
    }

    private JPanel makeSavePanel() {

        // make panel
        var panel = new JPanel();
        panel.setPreferredSize(new Dimension(this.imagePanel.getPreferredSize().width, 30));

        var spiralButton = makeSpiralButton();
        var saveButton = makeSaveButton();

        // make layout
        var gl = new GroupLayout(panel);
        panel.setLayout(gl);
        var horizontal = gl.createSequentialGroup();
        var vertical = gl.createSequentialGroup();
        gl.setHorizontalGroup(horizontal);
        gl.setVerticalGroup(vertical);
        gl.setAutoCreateGaps(true);

        // add components
        horizontal.addComponent(spiralButton);
        horizontal.addComponent(saveButton);

        vertical.addGroup(
                gl.createParallelGroup()
                        .addComponent(spiralButton)
                        .addComponent(saveButton)
        );

        return panel;
    }

    private JButton makeSpiralButton() {
        var makeSpiralButton = new JButton("Generate Spiral");
        makeSpiralButton.addActionListener(e -> {
            int width = this.imagePanel.getPreferredSize().width;
            var spiral = new UlamSpiral(width);
            this.imagePanel.updateImage(spiral.toImage());
            this.frame.pack();
        });
        return makeSpiralButton;
    }

    private JButton makeSaveButton() {
        var saveButton = new JButton("Save Image");
        saveButton.addActionListener(e -> {
            var image = this.imagePanel.getImage();
            if (image == null) {
                return;
            }
            File file = this.selectFileToSave();
            if (file == null) {
                return;
            }

            try {
                if (!file.getAbsolutePath().endsWith(".png")) {
                    throw new IOException("unsupported file type, only `.png` is supported");
                }
                ImageIO.write(image, "png", file);
            } catch (IOException ioe) {
                // TODO actual error handling
                System.err.println(ioe.getMessage());
            }
        });
        return saveButton;
    }

    protected File selectFileToSave() {
        JFileChooser chooser = new JFileChooser();
        chooser.showSaveDialog(this.frame);
        return chooser.getSelectedFile();
    }

}
