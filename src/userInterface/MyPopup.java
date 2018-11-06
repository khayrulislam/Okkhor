package userInterface;

import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;
import java.awt.event.WindowFocusListener;

import javax.swing.JLabel;
import javax.swing.JPopupMenu;
import javax.swing.JWindow;
import javax.swing.Popup;

public class MyPopup extends Popup implements WindowFocusListener{

	private final JWindow dialog;
	
	public MyPopup(Frame base, JLabel component, int x, int y) {
	      super();
	      dialog = new JWindow(base);
	      dialog.setFocusable(true);
	      dialog.setLocation(x, y);
	      dialog.setContentPane(component);
	      component.setBorder(new JPopupMenu().getBorder());
	      dialog.setSize(component.getPreferredSize());
	      dialog.addKeyListener(new KeyAdapter() {
	        @Override
	        public void keyPressed(KeyEvent e) {
	          if (e.getKeyCode() == KeyEvent.VK_ESCAPE) {
	            dialog.setVisible(false);
	          }
	        }
	      });
	      
	}
	
	
	
	@Override
	public void windowGainedFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void windowLostFocus(WindowEvent e) {
		// TODO Auto-generated method stub
		
	}

}
