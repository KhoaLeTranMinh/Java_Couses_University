package Week_11;

import javax.swing.*;
import java.awt.*;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class borderLayout {
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
        super("Layout");
        setContentPane(createContentPane());
        setSize(480, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private JPanel createContentPane() {
        /********************************/
        /* You need to write code here. */
        /********************************/
    	JPanel contentPane = new JPanel(new BorderLayout());  
    	JButton button1 = new JButton("Up");
    	JButton button2 = new JButton("Left");
    	JButton button3 = new JButton("Center");
    	JButton button4 = new JButton("Right");
    	JButton button5 = new JButton("Down");
    	
    	contentPane.add(button1, BorderLayout.NORTH);
    	contentPane.add(button2, BorderLayout.WEST);
    	contentPane.add(button3, BorderLayout.CENTER);
    	contentPane.add(button4, BorderLayout.EAST);
    	contentPane.add(button5, BorderLayout.SOUTH);
    	
    	return contentPane;
    }
}

