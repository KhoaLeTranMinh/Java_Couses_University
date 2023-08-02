package Week13;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Trim {
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
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        MouseListener listener = new MouseListener(canvas);
        canvas.addMouseListener(listener);
        canvas.addMouseMotionListener(listener);

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);
        return contentPane;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;
    private int startX;
    private int startY;
    private int x1,x2,y1,y2;
    private int width, height;
    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        x1 = startX;
        y1 = startY;
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/
		x2 = e.getX();
		y2 = e.getY();

		startX = Math.min(x1, x2);
		startY = Math.min(y1, y2);
		width = Math.abs(x1 - x2);
		height = Math.abs(y1 - y2);

		Rectangle rect = new Rectangle(startX, startY, width, height);
		canvasPanel.drawRectangle(rect);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	x2 = e.getX();
		y2 = e.getY();

		startX = Math.min(x1, x2);
		startY = Math.min(y1, y2);
		width = Math.abs(x1 - x2);
		height = Math.abs(y1 - y2);

		Rectangle rect = new Rectangle(startX, startY, width, height);
		canvasPanel.drawRectangle(rect);
		canvasPanel.trim(rect);
    }
}

class CanvasPanel extends JPanel {
    /**
     * 位置およびサイズが確定した図形のみが描かれた画像。
     * An image containing shapes whose locations and sizes are fixed.
     */
    private final BufferedImage image;
    /**
     * マウスをドラッグしている最中に表示する画像。
     * An image to be shown during the mouse is being dragged.
     */
    private final BufferedImage imageInProgress;
    /**
     * マウスをドラッグしている最中か否かを表す値。
     * A boolean value indicating whether the mouse is being dragged or not.
     */
    private boolean isInProgress;

    /**
     * 破線を描くための BasicStroke インスタンス。
     * A BasicStroke instance for drawing a dotted line.
     */
    private static final BasicStroke DASHED_LINE = new BasicStroke(1, BasicStroke.CAP_BUTT, BasicStroke.JOIN_MITER, 10, new float[]{7, 3}, 0);

    public CanvasPanel() {
        setName("canvas");
        try {
            URL url = new URL("https://upload.wikimedia.org/wikipedia/commons/thumb/b/b2/Kagami_mochi_%28Japanese_New_Year_decoration%29%3B_January_2020.jpg/320px-Kagami_mochi_%28Japanese_New_Year_decoration%29%3B_January_2020.jpg");
            image = ImageIO.read(url);
            imageInProgress = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * 指定した位置とサイズの矩形を描画する。Draw a rectangle with the given location and size.
     *
     * @param rectangle  矩形を描画する位置とサイズ。 A position and size of a rectangle to be drawn.
     */
    public void drawRectangle(Rectangle rectangle) {
        isInProgress = true;

        Graphics2D g = imageInProgress.createGraphics();
        // "image" の内容を "imageInProgress" にコピーして、描画中の図形を消す。
        // Copy the content of "image" to "imageInProgress" to clear the square drawing in progress.
        g.drawImage(image, 0, 0, this); //This line will clear the black square

        /********************************/
        /* You need to write code here. */
        /********************************/
        g.setColor(Color.black);
        g.setStroke(DASHED_LINE);
        g.draw(rectangle);

        repaint();
    }

    public void trim(Rectangle rectangle) {
        isInProgress = false;
        /********************************/
        /* You need to write code here. */
        /********************************/
        //Draw a white canvas
        BufferedImage toBeDrawn = new BufferedImage(image.getWidth(), image.getHeight(), BufferedImage.TYPE_INT_RGB);
        Graphics2D graphicDrawn = toBeDrawn.createGraphics();
        graphicDrawn.setColor(Color.white);
        graphicDrawn.fillRect(0, 0, image.getWidth(), image.getHeight());
        
        //Draw the cropped image into the white canvas
        Graphics2D graphic = image.createGraphics();
        BufferedImage subImage = image.getSubimage(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        graphicDrawn.drawImage(subImage,rectangle.x,rectangle.y,this);
        
        
        //Draw the white canvas together with the cropped image into the "image" variable
        graphic.drawImage(toBeDrawn,0,0,this);
        //graphic.drawImage can ONLY be implemented ONCE, you cannot stack it up. The second time 
        // it is called, it will be nullified
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
    }
}
