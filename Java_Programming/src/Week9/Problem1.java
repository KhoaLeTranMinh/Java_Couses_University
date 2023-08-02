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
public class Problem1 {
	public static void main(String[] args)  {
		showWindow();
	}

	// DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
	public static MainWindowTest showWindow()  {
		return new MainWindowTest();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindowTest extends JFrame {
	/********************************/
	/* You need to write code here. */
	/********************************/
	MyCanvas canva = new MyCanvas();
	public MainWindowTest()   {
		super("Problem1");
		try {
			canva.insert();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		this.setVisible(true);
		this.setSize(320, 240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JButton button1 = new JButton("Up");
		JButton button2 = new JButton("Down");
		JButton button3 = new JButton("Left");
		JButton button4 = new JButton("Right");
		button1.addActionListener(new ActionListener() {
			@Override
			//UP
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canva.shift(0,1);
				
			}
		});
		button2.addActionListener(new ActionListener() {
			@Override
			//DOWN
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				canva.shift(0, -1);
			}
		});
		button3.addActionListener(new ActionListener() {
			@Override
			//LEFT
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
			
				canva.shift(1, 0);
			}
		});
		button4.addActionListener(new ActionListener() {
			@Override
			//RIGHT
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				canva.shift(-1, 0);
			}
		});
		JPanel contentPane = new JPanel(new BorderLayout());
		contentPane.add(button1, BorderLayout.NORTH);
		contentPane.add(button2, BorderLayout.SOUTH);
		contentPane.add(button3, BorderLayout.WEST);
		contentPane.add(button4, BorderLayout.EAST);
		contentPane.add(canva, BorderLayout.CENTER);
		this.setContentPane(contentPane);
	}
}

class MyCanvas extends Canvas {
	private BufferedImage image;

	public MyCanvas()  {
		
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

	public void shift(int dx, int dy) {
		int width = this.image.getWidth();
		int height = this.image.getHeight();
		int white = new Color(255,255,255).getRGB();
		BufferedImage newImage = new BufferedImage(width, height, this.image.getType());

		/********************************/
		/* You need to write code here. */
		/********************************/
		if (dy == 1) {//UP
			for (int j = 0; j< height; j++) {
				for (int i = 0; i < width; i++) {
					if(j == height -1) {
						newImage.setRGB(i, j, white);
						continue;
					}
					newImage.setRGB(i, j, image.getRGB(i,j+dy));
				}
			}
		}
		
		if (dy== -1) {//DOWN
			for (int j = height-1; j>= 0; j--) {
				for (int i = 0; i < width; i++) {
					if( j == 0) {
						newImage.setRGB(i, j, white);
						continue;
					}
					newImage.setRGB(i, j, image.getRGB(i,j+dy));
				}
			}
		}
		
		
		if (dx == +1) {//LEFT
			for (int j = 0; j< height; j++) {
				for (int i = 0; i < width; i++) {
					if (i == width -1) {
						newImage.setRGB(i, j, white);
						continue;
					}
					newImage.setRGB(i, j, image.getRGB(i + dx,j));
				}
			}
		}
		
		
		if (dx == -1) {//RIGHT
			for (int j = 0; j< height; j++) {
				for (int i = width - 1; i >= 0; i--) {
					if (i == 0) {
						newImage.setRGB(i, j, white);
						continue;
					}
					newImage.setRGB(i, j, image.getRGB(i + dx,j));
				}
			}
		}
		this.image = newImage;
		this.repaint();
	}
}
