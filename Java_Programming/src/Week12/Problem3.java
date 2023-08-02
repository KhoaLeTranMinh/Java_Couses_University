package Week12;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Problem3 {
	public static void main(String[] args) {
		showWindow();
	}

	// DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
	public static MainWindow3 showWindow() {
		return new MainWindow3();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow3 extends JFrame {
	ButtonGroup group;

	public MainWindow3() {
		super("Paint Tool");
		group = new ButtonGroup();
		setContentPane(createContentPane());
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addButton(String text, Container container, CanvasPanel3 canvas, DrawingMode mode) {
		JRadioButton button = new JRadioButton(text);
		button.setName(text);
		button.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				canvas.setDrawingMode(mode);
			}
		});
		group.add(button);
		if (button.getName() == "Rectangle") {
			button.setSelected(true);
		}
		container.add(button);
	}

	private JPanel createContentPane() {
		CanvasPanel3 canvas = new CanvasPanel3();
		MouseListener3 listener = new MouseListener3(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(canvas, BorderLayout.CENTER);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.X_AXIS));
		contentPane.add(rightPanel, BorderLayout.EAST);
		/********************************/
		/* You need to write code here. */
		/********************************/
		addButton("Rectangle", rightPanel, canvas, DrawingMode.Rectangle);
		addButton("Circle", rightPanel, canvas, DrawingMode.Circle);

		return contentPane;
	}
}

class MouseListener3 extends MouseAdapter {
	private final CanvasPanel3 canvasPanel;
	private int startX;
	private int startY;
	private int x1, x2, y1, y2;
	private int width, height;

	MouseListener3(CanvasPanel3 canvas) {
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
		canvasPanel.drawShape(rect, true);

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
		canvasPanel.drawShape(rect, false);
	}
}

enum DrawingMode {
	Rectangle, Circle,
}

class CanvasPanel3 extends JPanel {
	private final BufferedImage image;

	/**
	 * �}�E�X���h���b�O���Ă���Œ��ɕ\������摜�B An image to be shown during the mouse is being
	 * dragged.
	 */
	private final BufferedImage imageInProgress;

	/**
	 * �}�E�X���h���b�O���Ă���Œ����ۂ���\���l�B A boolean value indicating whether the mouse is being
	 * dragged or not.
	 */
	private boolean isInProgress;

	private DrawingMode mode;

	public CanvasPanel3() {
		setName("canvas");
		image = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
		imageInProgress = new BufferedImage(320, 240, BufferedImage.TYPE_INT_RGB);
		Graphics2D g = image.createGraphics();
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, image.getWidth(), image.getHeight());
		g.dispose();
	}

	public void setDrawingMode(DrawingMode newMode) {
		mode = newMode;
	}

	public DrawingMode getDrawingMode() {
		return this.mode;
	}

	/**
	 * �w�肵���ʒu�ƃT�C�Y�̐}�`��`�悷��BDraw a shape with the given location and size.
	 *
	 * @param rectangle  �}�`��`�悷��ʒu�ƃT�C�Y�B A position and size of a shape to be drawn.
	 * @param inProgress �}�E�X���h���b�O���Ă���Œ����ۂ��BA boolean value indicating whether the
	 *                   mouse is being dragged or not.
	 */
	public void drawShape(Rectangle rectangle, boolean inProgress) {
		isInProgress = inProgress;
		Graphics2D g = (inProgress ? imageInProgress : image).createGraphics();
		if (inProgress) {
			g.drawImage(image, 0, 0, this);
		}
		g.setColor(Color.BLACK);
		/********************************/
		/* You need to write code here. */
		/********************************/
		if (mode == DrawingMode.Rectangle) {
			g.fill(rectangle);
		}else if (mode == DrawingMode.Circle) {
			g.fillOval(rectangle.x,rectangle.y , rectangle.width, rectangle.height);
		}

		repaint();
	}

	@Override
	public void paint(Graphics g) {
		g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
	}
}
