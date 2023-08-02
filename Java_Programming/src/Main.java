import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Main {
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
    private int startX, distX, originX;
    private int startY, distY, originY;
    private Rectangle Rect;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
        originX = e.getX();
        originY = e.getY();
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        if(startX > e.getX()){
            distX = startX - e.getX();
            originX = e.getX();
        }
        else{
            distX = e.getX() - startX;
        }
        if(startY > e.getY()){
            distY = startY - e.getY();
            originY = e.getY();
        }
        else{
            distY = e.getY() - startY;
        }
        Rect = new Rectangle(originX, originY, distX, distY);
        canvasPanel.drawRectangle(Rect);
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        canvasPanel.trim(Rect);
    }
}

class CanvasPanel extends JPanel {
    private final BufferedImage image;
    private final BufferedImage imageInProgress;
    private boolean isInProgress;
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
     * �w�肵���ʒu�ƃT�C�Y�̋�`��`�悷��BDraw a rectangle with the given location and size.
     *
     * @param rectangle  ��`��`�悷��ʒu�ƃT�C�Y�B A position and size of a rectangle to be drawn.
     */
    public void drawRectangle(Rectangle rectangle) {
        isInProgress = true;

        Graphics2D g = imageInProgress.createGraphics();
        // "image" �̓��e�� "imageInProgress" �ɃR�s�[���āA�`�撆�̐}�`�������B
        // Copy the content of "image" to "imageInProgress" to clear the square drawing in progress.
        g.drawImage(image, 0, 0, this);
        g.setStroke(DASHED_LINE);
        g.setColor(Color.BLACK);
        g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);

        repaint();
    }

    public void trim(Rectangle rectangle) {
        isInProgress = false;
        int i, j;
        int x1 = rectangle.x;
        int x2 = rectangle.x + rectangle.width;
        int y1 = rectangle.y;
        int y2 = rectangle.y + rectangle.height;
        int width = 320, height = 213;
        for(i = 0; i<width; i++){
            for(j=0; j<y1; j++){
                image.setRGB(i, j, Color.white.getRGB());
            }
        }
        for(i = 0; i<x1; i++){
            for(j=y1; j<=y2; j++){
                image.setRGB(i, j, Color.white.getRGB());
            }
        }
        for(i = x2+1; i<width; i++){
            for(j=y1; j<=y2; j++){
                image.setRGB(i, j, Color.white.getRGB());
            }
        }
        for(i = 0; i<width; i++){
            for(j=y2+1; j<height; j++){
                image.setRGB(i, j, Color.white.getRGB());
            }
        }
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
    }
}