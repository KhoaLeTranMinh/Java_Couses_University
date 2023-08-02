package Week8;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import javax.imageio.*;
// Please add missing import statements here

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/

public class Problem2 {
	public static void main(String[] args) {
		showWindow();
	}

	// DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
	public static MainWindow2 showWindow() {
		return new MainWindow2();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow2 extends JFrame {
    public MainWindow2 () {
        super("Problem2");
        this.setVisible(true);
        this.setSize(300,240);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        try {
            this.add(new MyCanvas());
        }
        catch(Exception e) {
            e.printStackTrace();
        }
    }
}

class MyCanvas extends Canvas {
    private final BufferedImage image;

    public MyCanvas() throws Exception {
        image = ImageIO.read(new URL("https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg"));
        this.setBounds(0,0,image.getWidth(),image.getHeight());
    }

    @Override
    public void paint(Graphics g) {
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
        g.drawImage(image, 0, 0, this);
    }
}