package Project;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Jumpingx2 extends JFrame {

	JPanel panel1; // start장면 패널
	JFrame frame;
	JButton button_start, button_rank;
	JButton button_ranking = new JButton();
	jump jp = new jump();
	public static int timer = 0;

	public Jumpingx2() {
		frame = new JFrame();

		////////////////// panel1 //////////////////

		panel1 = new JPanel() {
			ImageIcon i = new ImageIcon("img/panel_start.png");

			public void paintComponent(Graphics g) {
				g.drawImage(i.getImage(), 0, 0, 1000, 640, null);
			}
		};
		frame.add(panel1);
		panel1.setLayout(null);
		button_start = new JButton(new ImageIcon("img/button_start.png"));
		button_start.setBounds(310, 349, 150, 50);
		button_start.addActionListener(new MyListener());
		button_start.setBorderPainted(false);
		panel1.add(button_start);
		button_start.setVisible(true);

		button_rank = new JButton(new ImageIcon("img/button_rank.png"));
		button_rank.setBounds(530, 349, 180, 50);
		button_rank.addActionListener(new MyListener());
		button_rank.setBorderPainted(false);
		panel1.add(button_rank);
		button_rank.setVisible(true);

		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(1000, 640);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}

	private class MyListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == button_start) {
				GameFrame gf = new GameFrame();
				frame.setVisible(false);
				// (new MyThread()).start();
			} else if (e.getSource() == button_rank) {
				try {
					Rank rank = new Rank();
					rank.invisible();
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		}
	}
}