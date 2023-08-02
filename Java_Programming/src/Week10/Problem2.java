package Week10;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Problem2 {
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
        super("Paint Tool");
        setContentPane(createContentPane());
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        MouseListener listener = new MouseListener(canvas);
        /**********************************************************/
        /* You need to register `listener` twice                  */
        /* (`addMouseListener()` and `addMouseMotionListener()`). */
        /**********************************************************/
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);
        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);
        return contentPane;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int previousX;
    private int previousY;

    
    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/
        previousX = e.getX();
        previousY= e.getY();
    	canvasPanel.blackPixel(e.getX(), e.getY());
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	canvasPanel.drawLine(previousX, previousY, e.getX(), e.getY());
    	previousX = e.getX();
    	previousY = e.getY();
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final Graphics2D graphics;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        graphics = image.createGraphics();
        graphics.setColor(Color.WHITE);
        graphics.fillRect(0, 0, image.getWidth(), image.getHeight());
    }

    public void drawLine(int startX, int startY, int endX, int endY) {
        /***********************************************************/
        /* Draw line between (startX, startY) and (endX, endY).    */
        /* Note that you don't need to check the range of x and y. */
        /***********************************************************/
    	graphics.setColor(Color.BLACK);
    	graphics.drawLine(startX, startY, endX, endY);
        repaint();
    }
    public void blackPixel (int x, int y) {
    	image.setRGB(x, y, Color.BLACK.getRGB());
    }
    @Override
    public void paint(Graphics g) {
    	g.setColor(Color.YELLOW);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(image, 0, 0, this);
    }
}