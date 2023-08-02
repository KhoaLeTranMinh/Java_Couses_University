package Week13;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class PenSize {
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

        /********************************/
        /* You need to write code here. */
        /********************************/
        JPanel boxPane = new JPanel(new FlowLayout());
        
        String choices[] = {"1","2","3","5"};
        JComboBox comboBox = new JComboBox(choices);
        comboBox.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JComboBox cb = (JComboBox)e.getSource();
				String sizeString = (String) cb.getSelectedItem();
				int size = Integer.parseInt(sizeString);
				System.out.println(size);
				canvas.setPenSize(size);
			}
        	
        });
        
        boxPane.add(comboBox);
        
        contentPane.add(boxPane, BorderLayout.EAST);
        return contentPane;
    }
}

class MouseListener extends MouseAdapter {
    private final CanvasPanel canvasPanel;

    // Store the most recent X and Y of `mousePressed` or `mousePressed`.
    // 最も最近の `mousePressed` もしくは `mousePressed` のXとYを保存する。
    private int lastX;
    private int lastY;

    MouseListener(CanvasPanel canvas) {
        canvasPanel = canvas;
    }

    @Override
    public void mousePressed(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/

        // Draw a line (i.e., dot) between the current mouse position and the current mouse position.
        // 現在のマウス位置から現在のマウス位置間で直線（つまり、ドット）を描く。
    	lastX = e.getX();
    	lastY = e.getY();
    	canvasPanel.drawLine(lastX,lastY,lastX,lastY);
    	
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	
        // Draw a line between the post-movement pixel (i.e., current mouse position) and the pre-movement pixel (i.e., (lastX, lastY)).
        // 移動前のピクセル（つまり、現在のマウス）から移動後のピクセル（つまり、(lastX, lastY)）間で直線を描く。
    	canvasPanel.drawLine(lastX,lastY,e.getX(),e.getY());
    	lastX = e.getX();
    	lastY = e.getY();
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
        graphics.setColor(Color.BLACK);
    }

    public void setPenSize(int size) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	BasicStroke stroke = new BasicStroke(size);
    	graphics.setStroke(stroke);
    }
    
    public void drawLine(int startX, int startY, int endX, int endY) {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	graphics.drawLine(startX, startY, endX, endY);
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        g.drawImage(image, 0, 0, this);
    }
}
