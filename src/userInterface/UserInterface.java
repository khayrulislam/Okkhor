package userInterface;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import javax.swing.AbstractAction;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;



import javax.swing.JTextArea;

public class UserInterface {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserInterface window = new UserInterface();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public UserInterface() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 933, 649);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		textField = new JTextField(10);
		textField.setBounds(10, 11, 616, 66);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 97, 579, 502);
		
		
		panel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );
		JTextArea display = new JTextArea (29, 48);
	    display.setEditable ( false ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

	    //Add Textarea in to middle panel
	    panel.add ( scroll );

	    display.setText("Hello");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    
		
		
		
		frame.getContentPane().add(panel);
		
		
		ArrayList<String> words = new ArrayList<>();
		
		
		AutoSuggestor autoSuggestor = new AutoSuggestor(textField, frame, null, Color.WHITE.brighter(), Color.black,
				Color.black, 0.75f) {
			@Override
			boolean wordTyped(String typedWord) {
				

				words.add("heritage");
				words.add("happiness");
				words.add("goodbye");
				words.add("cruel");
				words.add("car");
				words.add("war");
				words.add("will");
				words.add("world");
				words.add("wall");
				setDictionary(words);
				// addToDictionary("bye");//adds a single word
				return super.wordTyped(typedWord);// now call super to check for
													// any matches against
													// newest dictionary
			}
		};
		
		
		
		
		
		textField.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	        	display.setText(display.getText()+"\n" + textField.getText());
	        	autoSuggestor.dictionary = new ArrayList<>();
	        	autoSuggestor.dictionary.add("Atiq");
	        	
	        }

	    });
		
		
	}
}
