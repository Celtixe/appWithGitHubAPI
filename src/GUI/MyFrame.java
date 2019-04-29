package GUI;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.eclipse.egit.github.core.Repository;

import code.Reader;


/**
 * 
 * @author Mikolaj Miller
 *
 */
public class MyFrame extends JFrame implements ActionListener {

	
	private static final long serialVersionUID = 1L;
	
	//Declares the variables needed for logic
	private String name;
	private Reader reader = new Reader();
	private List<Repository> repos;
	
	//creates panels, buttons, label and text field
	private JPanel mainPanel, topPanel, bottomPanel, botRightPanel, botLeftPanel;
	private JTextField tf1;
	private JLabel label;	
	private JButton search, allegroButton;
	
	/**
	 * Constructor that creates the frame and all its elements
	 * @throws IOException
	 */
	public MyFrame() throws IOException {
		
		
		super("Allegro Task");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		
		//sets the size and centres the frame on the screen
		setSize(700,300);
		setResizable(false);
		setLocationRelativeTo(null);
		
		//Initialises panels with different layout managers
		mainPanel = new JPanel(new GridLayout(2,1));
		topPanel = new JPanel(new FlowLayout(FlowLayout.CENTER,20, 50));
		bottomPanel = new JPanel(new GridLayout(1,2));
		botRightPanel = new JPanel(new FlowLayout());
		botLeftPanel = new JPanel(new FlowLayout());
		
		//Initialises search button
		search = new JButton("search");
		search.setPreferredSize(new Dimension(100,29));
		search.addActionListener(this);
		
		//Initialises tf1 text field
		tf1 = new JTextField("username");
		tf1.setPreferredSize(new Dimension(200,30));
		
		//adds text field and searches button to the bot-left panel
		botRightPanel.add(tf1);
		botRightPanel.add(search);
		
		//initialises the label and adds its to the top panel
		label = new JLabel();
		label.setText( "Please click the 'allegro' button or use search option :)");
		topPanel.add(label);
		
		//initialises allegro button and adds it to the bot-left panel
		allegroButton = new JButton("allegro");
		allegroButton.setPreferredSize(new Dimension(100,30));
		allegroButton.addActionListener(this);	
		botLeftPanel.add(allegroButton);
		
		//connects all the panels
		bottomPanel.add(botLeftPanel);
		bottomPanel.add(botRightPanel);
		mainPanel.add(topPanel);
		mainPanel.add(bottomPanel);
		
		//adds mainPanel to the frame
		add(mainPanel);
		
		setVisible(true);
	}
	
	/**
	 * Actions for buttons
	 * @param e - ActionEvent
	 */
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == allegroButton) {
			name = "allegro";
			try {
				repos = reader.getRepos(name);
				label.setText(reader.getLastModRepo(repos));
			} catch (IOException e1) {}
			
		}else if(e.getSource() == search) {
			if(!tf1.getText().isEmpty()) {
				name = tf1.getText();			
				try {
			        repos = reader.getRepos(name);
					label.setText(reader.getLastModRepo(repos));
				} catch (IOException e1) {}
			}else {
				label.setText("Please provide the username.");
			}
		}
         
    }  
	
}