package GUI;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle.ComponentPlacement;

import server.QueueChecker;
import server.SocketReceiver;
import Listener.OrderReceiver;

public class GUIMain {
	JLabel actionBar;
	private JFrame frame;
	private JPanel panel_1, panel_4, panel_5, panel_3;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUIMain window = new GUIMain();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		OrderReceiver receive = new OrderReceiver();

	}

	/**
	 * Create the application.
	 */
	public GUIMain() {
		initialize();
		QueueChecker checker = new QueueChecker();
		Thread t = new Thread(checker);
		t.start();
		
		SocketReceiver sock = new SocketReceiver();
		Thread x = new Thread(sock);
		x.start();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 1000, 700);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		JButton btnNewButton = new JButton("Ordre");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(new GUIOrderView());
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		
		JButton btnNewButton_1 = new JButton("Produkter");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				panel_1.removeAll();
				panel_1.repaint();
				panel_1.revalidate();
				
				panel_1.add(new GUIProductView());
				panel_1.repaint();
				panel_1.revalidate();
			}
		});
		
		
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(gl_panel.createSequentialGroup()
					.addContainerGap()
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGap(18))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnNewButton, GroupLayout.DEFAULT_SIZE, 105, Short.MAX_VALUE)
							.addGap(18))))

		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(11)
					.addComponent(btnNewButton)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnNewButton_1)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addPreferredGap(ComponentPlacement.RELATED, 277, Short.MAX_VALUE)
					.addGap(36))
		);
		panel.setLayout(gl_panel);
		
		panel_1 = new JPanel();
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new CardLayout(0, 0));
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_1.add(panel_3, "name_1386894178115656000");
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.GREEN);
		panel_1.add(panel_4, "name_1386894181649122000");
		panel_4.setLayout(new BorderLayout(0, 0));
		


		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.ORANGE);
		panel_1.add(panel_5, "name_1386894184155704000");
		
		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);
		
		
		
//		mes.getActive();
		
	}
}
