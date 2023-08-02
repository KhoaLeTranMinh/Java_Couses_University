package Week_11;

import javax.swing.*;
import java.awt.*;

/*** I DON'T RECOMMEND TO CHANGE THE BELOW CODE (EVEN THOUGH YOU CAN) ***/
public class boxLayout {
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
    public MainWindow3() {
        super("Layout");
        setContentPane(createContentPane());
        setSize(480, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void addButton (String text, Container container) {
    	JButton button = new JButton(text);
    	container.add(button);
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
    	
    	//blackPanel
    	JPanel blackPanel = new JPanel ();
    	blackPanel.setLayout(new BoxLayout(blackPanel, BoxLayout.LINE_AXIS));
    	blackPanel.setBackground(Color.BLACK);
    	
    	//whitePanel
    	JPanel whitePanel = new JPanel ();
    	whitePanel.setLayout(new BoxLayout(whitePanel, BoxLayout.PAGE_AXIS));
    	whitePanel.setBackground(Color.WHITE);	
    	addButton("Box1-1", whitePanel);
    	addButton("Box1-22", whitePanel);
    	addButton("Box1-333", whitePanel);
    	addButton("Box1-4444", whitePanel);
    	
    	//greenPanel
    	JPanel greenPanel = new JPanel();
    	greenPanel.setLayout(new BoxLayout(greenPanel, BoxLayout.PAGE_AXIS));
    	greenPanel.setBackground(Color.GREEN);
    	addButton("Box2-1",greenPanel);
    	addButton("Box2-22",greenPanel);
    	addButton("Box2-333",greenPanel);
    	addButton("Box2-4444",greenPanel);
    	
    	blackPanel.add(whitePanel);
    	blackPanel.add(greenPanel);
    	
    	JButton grid1 = new JButton("Grid1");
    	JButton grid2 = new JButton("Grid2");
    	JButton grid3 = new JButton("Grid13");

    	
    	contentPane.add(button1, BorderLayout.NORTH);
    	contentPane.add(button2, BorderLayout.WEST);
    	contentPane.add(blackPanel,BorderLayout.CENTER);
    	contentPane.add(button4, BorderLayout.EAST);
    	contentPane.add(button5, BorderLayout.SOUTH);
    	
    	return contentPane;
    }
}

