package userInterface;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class Test {
	public static void main ( String[] args )
	{
	    JPanel middlePanel = new JPanel ();
	    middlePanel.setBorder ( new TitledBorder ( new EtchedBorder (), "Display Area" ) );

	    // create the middle panel components

	    JTextArea display = new JTextArea ( 16, 58 );
	    display.setEditable ( false ); // set textArea non-editable
	    JScrollPane scroll = new JScrollPane ( display );
	    scroll.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

	    //Add Textarea in to middle panel
	    middlePanel.add ( scroll );

	    display.setText("Hello");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    display.setText(display.getText()+"  sfdgsdf \n jkfdsfldsfklsdkfls;dfk;lsdk");
	    // My code
	    JFrame frame = new JFrame ();
	    frame.add ( middlePanel );
	    frame.pack ();
	    frame.setLocationRelativeTo ( null );
	    frame.setVisible ( true );
	}
}
