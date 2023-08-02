package Week9;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
// Please add missing import statements here
import java.net.URL;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Problem2 {
	public static void main(String[] args)  {
		showWindow();
	}

	// DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
	public static MainWindow2 showWindow()  {
		return new MainWindow2();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow2 extends JFrame {
	/********************************/
	/* You need to write code here. */
	/********************************/
	MyCanvas2 canva = new MyCanvas2();
	public MainWindow2()   {
		super("Problem2");
		try {
			canva.insert();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setVisible(true);
		this.setSize(600, 400);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton button1 = new JButton("Clockwise");
		JButton button2 = new JButton("Counterclockwise");

		button1.addActionListener(new ActionListener() {
			@Override
			//UP
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				canva.clockwise();
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			//DOWN
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canva.counterClockwise();
			}
		});

		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(button1, BorderLayout.WEST);
		contentPane.add(button2, BorderLayout.EAST);
		contentPane.add(canva, BorderLayout.CENTER);
		this.setContentPane(contentPane);
	}
}

class MyCanvas2 extends Canvas {
	private BufferedImage image;
	private int[][] imageBits;

	public MyCanvas2()  {
		
	}
	
	public void insert() throws IOException {
		URL url = new URL("https://docs.oracle.com/javase/tutorial/2d/images/examples/strawberry.jpg");
		this.image = ImageIO.read(url);
	}
	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(this.image, 0, 0, this);
	}

	
	public void clockwise() {
		int width = this.image.getWidth();
		int height = this.image.getHeight();
		imageBits = new int[height][width];
		for (int i = 0; i< height; i++) {
			for(int j = 0; j< width; j++) {
				imageBits[i][j] = image.getRGB(j, i);
			}
		}
		int [][]clockwiseBits= new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				clockwiseBits[j][height-1-i] = imageBits[i][j];
			}
		}
		BufferedImage newImage = new BufferedImage(height, width, this.image.getType());
		for (int i = 0; i< width; i++) {
			for (int j = 0; j< height; j++) {
				newImage.setRGB(j, i, clockwiseBits[i][j]);
			}
		}
		this.image = newImage;
		this.repaint();
	}
	
	
	public void counterClockwise() {
		int width = this.image.getWidth();
		int height = this.image.getHeight();
		BufferedImage newImage = new BufferedImage(height, width, this.image.getType());
		imageBits = new int[height][width];
		for (int i = 0; i< height; i++) {
			for(int j = 0; j< width; j++) {
				imageBits[i][j] = image.getRGB(j, i);
			}
		}
		int [][]counterclockwiseBits= new int[width][height];
		for (int i = 0; i < width; i++) {
			for (int j = 0; j < height; j++) {
				counterclockwiseBits[i][j] = imageBits[j][width-1-i];
			}
		}
		for (int i = 0; i< width; i++) {
			for (int j = 0; j< height; j++) {
				newImage.setRGB(j, i, counterclockwiseBits[i][j]);
			}
		}
		this.image = newImage;
		this.repaint();
	}
		/********************************/
		/* You need to write code here. */
		/********************************/
}
