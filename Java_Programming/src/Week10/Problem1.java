package Week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Problem1 {
    public static void main(String[] args) {
        showWindow();
    }

    // DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
    public static MainWindow showWindow() {
        return new MainWindow();
    }
}
/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow extends JFrame {
    public MainWindow() {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	super("Paint Tool");
    	this.setVisible(true);
		this.setSize(800, 600);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(createContentPane());
    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        /********************************/
        // You need to write code here.
        // Please use addMouseListener().
        // - ���{��: https://docs.oracle.com/javase/jp/8/docs/api/java/awt/event/MouseListener.html
        // - English: https://docs.oracle.com/javase/8/docs/api/java/awt/event/MouseListener.html
        /********************************/
        canvas.addMouseListener( new MouseAdapter() {

        	public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				int x = e.getX();
				int y = e.getY();
				canvas.blackPixel(x, y);
			}   
		     	
        });
        
        
        return canvas;
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;

    public CanvasPanel() {
    	setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        /********************************/
        /* You need to write code here. */
        /********************************/
		for (int i = 0; i< image.getWidth(); i++) {
			for (int j = 0; j < image.getHeight();j++) {
				image.setRGB(i, j, Color.WHITE.getRGB());
			}
		}
    }

    /******************************************************/
    /* You need to write code here.                       */
    /* Please declare a method for putting a black pixel. */
    /******************************************************/
    public void blackPixel (int x, int y) {
    	image.setRGB(x, y, Color.BLACK.getRGB());
    	System.out.println(image.getRGB(x, y));
    }
    
    @Override
    public void paint(Graphics g) {
    	g.setColor(Color.BLUE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(image, 0, 0, this);
    }
    
    
}
