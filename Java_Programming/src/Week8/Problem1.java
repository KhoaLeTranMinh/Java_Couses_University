package Week8;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class Problem1 {
    public static void main(String[] args) {
        showWindow();
    }

    // DON'T CHANGE THE METHOD SIGNATURE OF showWindow()
    public static MainWindows showWindow() {
        return new MainWindows();
    }
}
/*** I DON'T RECOMMEND TO CHANGE THE ABOVE CODE (EVEN THOUGH YOU CAN) ***/

class MainWindows extends JFrame {
    /********************************/
    /* You need to write code here. */
    /********************************/
     public MainWindows() {
		super("Problem1");
		this.setVisible(true);
		this.setSize(320,240);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setContentPane(this.createContentPane());;
	}
	
	private JPanel createContentPane() {
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		
		JButton button1 = new JButton("Left");
		JButton button2 = new JButton("Right");
		button1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(textArea.getText()+"Left!\n");
			}
			
		});
		
		button2.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				textArea.setText(textArea.getText()+"Right!\n");
			}
			
		});
		
		JPanel contentPane = new JPanel (new BorderLayout());
		contentPane.add(textArea);
		contentPane.add(button1, BorderLayout.WEST);
		contentPane.add(button2,BorderLayout.EAST);
		return contentPane;
	}
}

