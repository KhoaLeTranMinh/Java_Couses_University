package Week12;

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
        super("Paint Tool");
        setContentPane(createContentPane());
        setSize(600, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createContentPane() {
        CanvasPanel canvas = new CanvasPanel();
        canvas.addMouseListener(new MouseAdapter() {
            int startX;
            int startY;
            int x1,y1,x2,y2;

            @Override
            public void mousePressed(MouseEvent e) {
                /********************************/
                /* You need to write code here. */
                /********************************/
            	x1 = e.getX();
            	y1 = e.getY();
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
            	int width = Math.abs(x1-x2);
            	int height = Math.abs(y1-y2);
            	canvas.drawRectangle(startX,startY,startX+width,startY+height);
            	
            }
        });

        JPanel contentPane = new JPanel(new BorderLayout());
        contentPane.add(canvas, BorderLayout.CENTER);
        return contentPane;
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;

    public CanvasPanel() {
        setName("canvas");
        image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
        Graphics2D g = image.createGraphics();
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, image.getWidth(), image.getHeight());
        g.dispose();
    }

    /**
     * Draws a rectangle filled with black color between (x1, y1) and (x2, y2).
     * Note that you cannot expect x1 <= x2 and/or y1 <= y2 do not always hold.
     * (x1, y1) ‚©‚ç (x2, y2) ‚Ì”ÍˆÍ‚Å•F‚Å“h‚è‚Â‚Ô‚µ‚½’·•ûŒ`‚ð•`‰æ‚·‚éB
     * x1 <= x2 ‚â y1 <= y2 ‚ªí‚É¬‚è‚Â—§‚Â‚í‚¯‚Å‚Í‚È‚¢‚±‚Æ‚É’ˆÓ‚¹‚æB
     */
    public void drawRectangle(int x1, int y1, int x2, int y2) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	Graphics2D g = image.createGraphics();
    	g.setColor(Color.black);
    	g.fillRect(x1, y1, x2-x1, y2-y1);
    	image.setRGB(x2, y2, Color.white.getRGB());
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
