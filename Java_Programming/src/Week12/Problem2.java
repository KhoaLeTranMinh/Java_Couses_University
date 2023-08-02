package Week12;

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
	public static MainWindow2 showWindow() {
		return new MainWindow2();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow2 extends JFrame {
	public MainWindow2() {
		super("Paint Tool");
		setContentPane(createContentPane());
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private JPanel createContentPane() {
		CanvasPanel2 canvas = new CanvasPanel2();
		MouseListener listener = new MouseListener(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(canvas, BorderLayout.CENTER);
		return contentPane;
	}
}

class MouseListener extends MouseAdapter {
	private final CanvasPanel2 canvasPanel;
	private int startX;
	private int startY;
	private int x1, x2, y1, y2;
	private int width, height;

	MouseListener(CanvasPanel2 canvas) {
		canvasPanel = canvas;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/********************************/
		/* You need to write code here. */
		/********************************/
		x1 = e.getX();
		y1 = e.getY();
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

		canvasPanel.drawRectangle(rect, true);
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
		canvasPanel.drawRectangle(rect, false);
	}
}

class CanvasPanel2 extends JPanel {
	private final BufferedImage image;

	/**
	 * マウスをドラッグしている最中に表示する画像。 An image to be shown during the mouse is being
	 * dragged.
	 */
	private final BufferedImage imageInProgress;

	/**
	 * マウスをドラッグしている最中か否かを表す値。 A boolean value indicating whether the mouse is being
	 * dragged or not.
	 */
	private boolean isInProgress;

	public CanvasPanel2() {
		setName("canvas");
		image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
		imageInProgress = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setColor(Color.white);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.dispose();
	}

	/**
	 * 指定した位置とサイズの矩形を描画する。Draw a rectangle with the given location and size.
	 *
	 * @param rectangle  矩形を描画する位置とサイズ。 A position and size of a rectangle to be
	 *                   drawn.
	 * @param inProgress マウスをドラッグしている最中か否か。A boolean value indicating whether the
	 *                   mouse is being dragged or not.
	 */
	public void drawRectangle(Rectangle rectangle, boolean inProgress) {
		isInProgress = inProgress;
		Graphics2D g = (inProgress ? imageInProgress : image).createGraphics();
		if (inProgress) {
			g.drawImage(image, 0, 0, this);
		}
		
		g.setColor(Color.black);
		/********************************/
		/* You need to write code here. */
		/********************************/
        g.fill(rectangle);
        repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
	}
}