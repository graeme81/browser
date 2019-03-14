import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

public class ReadFile extends JFrame{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField addressBar;
	private JEditorPane display;
	
	public ReadFile() {
		super("New Browser");
		addressBar = new JTextField("Enter URL!");
		addressBar.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					loadPage(event.getActionCommand());
				}
			}
		);
		add(addressBar, BorderLayout.NORTH);
		
		display = new JEditorPane();
		display.setEditable(false);
		display.addHyperlinkListener(
			new HyperlinkListener() {
				public void hyperlinkUpdate(HyperlinkEvent event) {
					if(event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
						loadPage(event.getURL().toString());
					}
				}
			}
		);
		add(new JScrollPane(display),BorderLayout.CENTER);
		setSize(500,300);
		setVisible(true);
	}
	//loadPage display on the screen
	
	private void loadPage(String userText) {
		try {
			display.setPage(userText);
			addressBar.setText(userText);
		}catch(Exception e) {
			System.out.println("Not valid url!");
		}
	}
	
	
}



















