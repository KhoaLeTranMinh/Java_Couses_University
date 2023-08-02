package Week_11;

import javax.swing.*;
import java.awt.*;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class gridLayout {
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
    	JButton button1 = new JButton("Border-Up");
    	JButton button2 = new JButton("Border-Left");
    	JButton button4 = new JButton("Border-Right");
    	JButton button5 = new JButton("Border-Down");
    	
    	JPanel gridPane = new JPanel (new GridLayout (1,0));
    	JButton grid1 = new JButton("Grid1");
    	JButton grid2 = new JButton("Grid2");
    	JButton grid3 = new JButton("Grid13");
    	gridPane.add(grid1);
    	gridPane.add(grid2);
    	gridPane.add(grid3);
    	
    	contentPane.add(button1, BorderLayout.NORTH);
    	contentPane.add(button2, BorderLayout.WEST);
    	contentPane.add(gridPane,BorderLayout.CENTER);
    	contentPane.add(button4, BorderLayout.EAST);
    	contentPane.add(button5, BorderLayout.SOUTH);
    	
    	return contentPane;
    }
}

