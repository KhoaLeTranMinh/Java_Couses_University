package Week14;

import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class RichPaintTool {
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
	ButtonGroup group;
	ButtonGroup colorGroup;

	public MainWindow() {
		super("Paint Tool");
		group = new ButtonGroup();
		colorGroup = new ButtonGroup();
		setContentPane(createContentPane());
		setSize(600, 400);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
	}

	private void addColorButton(String text, Container container, CanvasPanel canvas) {
		JRadioButton button = new JRadioButton(text);
		button.setName(text);
//        button.setAlignmentX(Component.RIGHT_ALIGNMENT);
		button.setAlignmentY(Component.CENTER_ALIGNMENT);
//   
		button.addItemListener(new ItemListener() {

			@Override
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				canvas.setColor(button.getName());
			}

		});
		colorGroup.add(button);
		if (button.getName() == "Black") {
			button.setSelected(true);
		}
		container.add(button);
	}

	private void addButton(String text, Container container, CanvasPanel canvas, DrawingMode mode) {
		JRadioButton button = new JRadioButton(text);
		button.setName(text);
		button.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent e) {
				// TODO Auto-generated method stub
				canvas.setDrawingMode(mode);
			}
		});
		group.add(button);
		if (button.getName() == "Pen") {
			button.setSelected(true);
		}
		container.add(button);
	}

	private JPanel createContentPane() {
		CanvasPanel canvas = new CanvasPanel();
		MouseListener listener = new MouseListener(canvas);
		canvas.addMouseListener(listener);
		canvas.addMouseMotionListener(listener);

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(canvas, BorderLayout.CENTER);

		JPanel rightPanel = new JPanel();
		rightPanel.setLayout(new BoxLayout(rightPanel, BoxLayout.Y_AXIS));
		contentPane.add(rightPanel, BorderLayout.EAST);
		/********************************/
		/* You need to write code here. */
		/********************************/
		addButton("Pen", rightPanel, canvas, DrawingMode.Pen);
		addButton("RectangleFill)", rightPanel, canvas, DrawingMode.RectangleFill);
		addButton("CircleFill)", rightPanel, canvas, DrawingMode.CircleFill);
		addButton("RectangleOutline)", rightPanel, canvas, DrawingMode.RectangleOutline);
		addButton("CircleOutline)", rightPanel, canvas, DrawingMode.CircleOutline);

		JPanel downPanel = new JPanel();
		downPanel.setLayout(new BoxLayout(downPanel, BoxLayout.LINE_AXIS));
		addColorButton("Black", downPanel, canvas);
		addColorButton("White", downPanel, canvas);
		addColorButton("Red", downPanel, canvas);
		addColorButton("Green", downPanel, canvas);
		addColorButton("Blue", downPanel, canvas);

		contentPane.add(downPanel, BorderLayout.SOUTH);

		JPanel boxPane = new JPanel(new FlowLayout());
		String choices[] = { "1", "2", "3", "5" };
		JComboBox comboBox = new JComboBox(choices);
		comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox) e.getSource();
				String sizeString = (String) cb.getSelectedItem();
				int size = Integer.parseInt(sizeString);
				canvas.setPenSize(size);
			}

		});

		boxPane.add(comboBox);
		rightPanel.add(boxPane);
		return contentPane;
	}
}

class MouseListener extends MouseAdapter {
	private final CanvasPanel canvasPanel;
	private int startX;
	private int startY;
	private int x1, x2, y1, y2;
	private int width, height;
	private int lastX, lastY;

	MouseListener(CanvasPanel canvas) {
		canvasPanel = canvas;
	}

	@Override
	public void mousePressed(MouseEvent e) {
		/********************************/
		/* You need to write code here. */

		/********************************/

		if (canvasPanel.getDrawingMode() == DrawingMode.Pen) {
			lastX = e.getX();
			lastY = e.getY();
			canvasPanel.drawLine(lastX, lastY, lastX, lastY);
		} else {
			x1 = e.getX();
			y1 = e.getY();
		}
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		if (canvasPanel.getDrawingMode() != DrawingMode.Pen) {
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
		} else {
			canvasPanel.drawLine(lastX, lastY, e.getX(), e.getY());
			lastX = e.getX();
			lastY = e.getY();
		}

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		/********************************/
		/* You need to write code here. */
		/********************************/

		if (canvasPanel.getDrawingMode() != DrawingMode.Pen) {
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
}

enum DrawingMode {
	Pen, RectangleFill, CircleFill, RectangleOutline, CircleOutline,
}

class CanvasPanel extends JPanel {
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

	private DrawingMode mode;
	private String color;
	private int penSize;

	public CanvasPanel() {
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
	 * 指定した位置とサイズの図形を描画する。Draw a shape with the given location and size.
	 *
	 * @param rectangle  図形を描画する位置とサイズ。 A position and size of a shape to be drawn.
	 * @param inProgress マウスをドラッグしている最中か否か。A boolean value indicating whether the
	 *                   mouse is being dragged or not.
	 */
	public void drawLine(int startX, int startY, int endX, int endY) {
		isInProgress = false;
		Graphics2D g = image.createGraphics();
		g.setColor(getColor());
		BasicStroke stroke = new BasicStroke(this.penSize);
		g.setStroke(stroke);
		g.drawLine(startX, startY, endX, endY);
		repaint();
	}

	public void drawShape(Rectangle rectangle, boolean inProgress) {
		isInProgress = inProgress;
		Graphics2D g = (inProgress ? imageInProgress : image).createGraphics();
		if (inProgress) {
			g.drawImage(image, 0, 0, this);
		}
		/********************************/
		/* You need to write code here. */
		/********************************/
		g.setColor(getColor());
		BasicStroke stroke = new BasicStroke(this.penSize);
		g.setStroke(stroke);
		if (mode == DrawingMode.RectangleFill) {
			g.fill(rectangle);
		} else if (mode == DrawingMode.CircleFill) {
			g.fillOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		} else if (mode == DrawingMode.RectangleOutline) {
			g.drawRect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		} else {
			g.drawOval(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
		}

		repaint();
	}

	public Color getColor() {
		Graphics2D graphics = image.createGraphics();
		Color result = null;
		switch (this.color) {
		case "Black": {
			result = Color.black;
			break;
		}
		case "White": {
			result = Color.white;
			break;
		}
		case "Red": {
			result = Color.red;
			break;
		}
		case "Green": {
			result = Color.green;
			break;
		}
		case "Blue": {
			result = Color.blue;
			break;
		}
		}
		return result;

	}

	public void setColor(String col) {
		this.color = col;
	}
    public void setPenSize(int size) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	this.penSize = size;
    }
	@Override
	public void paint(Graphics g) {
		g.drawImage(isInProgress ? imageInProgress : image, 0, 0, this);
	}
}