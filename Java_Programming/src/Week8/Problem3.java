package Week8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import javax.imageio.*;
// Please add missing import statements here

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/

public class Problem3 {
	public static void main(String[] args) throws IOException {
		showWindow3();
	}

	// DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
	public static MainWindow3 showWindow3() throws IOException {
		return new MainWindow3();
	}
}

/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindow3 extends JFrame {
	MyCanvas3 canva = new MyCanvas3();

	public MainWindow3() throws MalformedURLException  {
		super("Problem3");
		this.setVisible(true);
		this.setSize(300, 240);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JPanel contentPane = new JPanel(new BorderLayout());
		JTextArea textArea = new JTextArea();
		JButton button1 = new JButton();
		button1.addActionListener(new ActionListener() {
			// UP
			URL urlString = new URL(textArea.getText());

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					canva.insert(urlString);
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		
		contentPane.add(button1,BorderLayout.SOUTH);
		contentPane.add(textArea,BorderLayout.NORTH);
		contentPane.add(canva,BorderLayout.CENTER);
		this.setContentPane(contentPane);
	}
}

class MyCanvas3 extends Canvas {
	private BufferedImage image;

	public MyCanvas3() {

	}

	public void insert(URL url) throws IOException {
		this.image = ImageIO.read(url);
	}

	@Override
	public void paint(Graphics g) {
		g.setColor(Color.WHITE);
		g.fillRect(0, 0, this.getWidth(), this.getHeight());
		g.drawImage(image, 0, 0, this);
	}
}