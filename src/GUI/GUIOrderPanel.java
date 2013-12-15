package GUI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JTabbedPane;
import javax.swing.JList;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;

public class GUIOrderPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	public GUIOrderPanel() {
		setLayout(new BorderLayout(0, 0));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		add(tabbedPane, BorderLayout.CENTER);
		
		JList list = new JList();

		tabbedPane.addTab("Ordre", null, list, null);
		
		JPanel panel = new JPanel();
//		tabbedPane.addTab("New tab", null, GUIOrderAdd, null);
		panel.setLayout(new BorderLayout(0, 0));

	}

}
