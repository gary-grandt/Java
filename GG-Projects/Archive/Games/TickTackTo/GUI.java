package Games.TickTackTo;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;



public class GUI {

	private JFrame frame;
	private JTextField winner_txt;
	private JTextField player_1_txt;
	private JTextField player_2_txt;

	// Vairalbes
	private Logic logic;

	private String player1_path;
	private String player2_path;
	private String player3_path;
	private String player4_path;

	private String kreuz = "/bktm/venediktov/images/TikTakTo_Kreuz.png";
	private String kreis = "/bktm/venediktov/images/TikTakTo_Kreis.png";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
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
	public GUI() {
		initialize();
		logic = new Logic(this);
		player1_path = kreuz;
		player2_path = kreis;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBackground(Color.DARK_GRAY);
		frame.getContentPane().setBackground(Color.DARK_GRAY);

		JPanel top_panel = new JPanel();
		top_panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(top_panel, BorderLayout.NORTH);

		player_1_txt = new JTextField();
		player_1_txt.setEditable(false);
		player_1_txt.setText("Player 1:");
		top_panel.add(player_1_txt);
		player_1_txt.setColumns(5);

		JButton player_1_button = new JButton("");
		player_1_button.setForeground(Color.DARK_GRAY);
		player_1_button.setBackground(Color.DARK_GRAY);
		player_1_button
				.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_Kreuz.png")));
		top_panel.add(player_1_button);

		player_2_txt = new JTextField();
		player_2_txt.setText("Player 2:");
		player_2_txt.setEditable(false);
		top_panel.add(player_2_txt);
		player_2_txt.setColumns(5);

		JButton player_2_button = new JButton("");
		player_2_button.setForeground(Color.DARK_GRAY);
		player_2_button.setBackground(Color.DARK_GRAY);
		player_2_button
				.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_Kreis.png")));
		top_panel.add(player_2_button);

		JPanel bottom_panel = new JPanel();
		bottom_panel.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(bottom_panel, BorderLayout.SOUTH);

		winner_txt = new JTextField();
		bottom_panel.add(winner_txt);
		winner_txt.setColumns(10);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.DARK_GRAY);
		frame.getContentPane().add(panel_2, BorderLayout.CENTER);
		GridBagLayout gbl_panel_2 = new GridBagLayout();
		gbl_panel_2.columnWidths = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.rowHeights = new int[] { 0, 0, 0, 0 };
		gbl_panel_2.columnWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		gbl_panel_2.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };
		panel_2.setLayout(gbl_panel_2);

		JButton button_1_1 = new JButton("");
		button_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(0, 0, button_1_1);
			}
		});
		button_1_1.setForeground(Color.DARK_GRAY);
		button_1_1.setBackground(Color.DARK_GRAY);
		button_1_1.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		GridBagConstraints gbc_button_1_1 = new GridBagConstraints();
		gbc_button_1_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_1_1.gridx = 0;
		gbc_button_1_1.gridy = 0;
		panel_2.add(button_1_1, gbc_button_1_1);

		JButton button_1_2 = new JButton("");
		button_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(1, 0, button_1_2);
			}
		});
		button_1_2.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_1_2.setForeground(Color.DARK_GRAY);
		button_1_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_1_2 = new GridBagConstraints();
		gbc_button_1_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_1_2.gridx = 1;
		gbc_button_1_2.gridy = 0;
		panel_2.add(button_1_2, gbc_button_1_2);

		JButton button_1_3 = new JButton("");
		button_1_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(2, 0, button_1_3);
			}
		});
		button_1_3.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_1_3.setForeground(Color.DARK_GRAY);
		button_1_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_1_3 = new GridBagConstraints();
		gbc_button_1_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_1_3.gridx = 2;
		gbc_button_1_3.gridy = 0;
		panel_2.add(button_1_3, gbc_button_1_3);

		JButton button_2_1 = new JButton("");
		button_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(0, 1, button_2_1);
			}
		});
		button_2_1.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_2_1.setForeground(Color.DARK_GRAY);
		button_2_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_2_1 = new GridBagConstraints();
		gbc_button_2_1.insets = new Insets(0, 0, 5, 5);
		gbc_button_2_1.gridx = 0;
		gbc_button_2_1.gridy = 1;
		panel_2.add(button_2_1, gbc_button_2_1);

		JButton button_2_2 = new JButton("");
		button_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(1, 1, button_2_2);
			}
		});
		button_2_2.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_2_2.setForeground(Color.DARK_GRAY);
		button_2_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_2_2 = new GridBagConstraints();
		gbc_button_2_2.insets = new Insets(0, 0, 5, 5);
		gbc_button_2_2.gridx = 1;
		gbc_button_2_2.gridy = 1;
		panel_2.add(button_2_2, gbc_button_2_2);

		JButton button_2_3 = new JButton("");
		button_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(2, 1, button_2_3);
			}
		});
		button_2_3.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_2_3.setForeground(Color.DARK_GRAY);
		button_2_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_2_3 = new GridBagConstraints();
		gbc_button_2_3.insets = new Insets(0, 0, 5, 0);
		gbc_button_2_3.gridx = 2;
		gbc_button_2_3.gridy = 1;
		panel_2.add(button_2_3, gbc_button_2_3);

		JButton button_3_1 = new JButton("");
		button_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(0, 2, button_3_1);
			}
		});
		button_3_1.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_3_1.setForeground(Color.DARK_GRAY);
		button_3_1.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_3_1 = new GridBagConstraints();
		gbc_button_3_1.insets = new Insets(0, 0, 0, 5);
		gbc_button_3_1.gridx = 0;
		gbc_button_3_1.gridy = 2;
		panel_2.add(button_3_1, gbc_button_3_1);

		JButton button_3_2 = new JButton("");
		button_3_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(1, 2, button_3_2);
			}
		});
		button_3_2.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_3_2.setForeground(Color.DARK_GRAY);
		button_3_2.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_3_2 = new GridBagConstraints();
		gbc_button_3_2.insets = new Insets(0, 0, 0, 5);
		gbc_button_3_2.gridx = 1;
		gbc_button_3_2.gridy = 2;
		panel_2.add(button_3_2, gbc_button_3_2);

		JButton button_3_3 = new JButton("");
		button_3_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				buttonClick(2, 2, button_3_3);
			}
		});
		button_3_3.setIcon(new ImageIcon(GUI.class.getResource("/bktm/venediktov/images/TikTakTo_blank.png")));
		button_3_3.setForeground(Color.DARK_GRAY);
		button_3_3.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_button_3_3 = new GridBagConstraints();
		gbc_button_3_3.gridx = 2;
		gbc_button_3_3.gridy = 2;
		panel_2.add(button_3_3, gbc_button_3_3);
		frame.setBounds(100, 100, 341, 392);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	// Methodes

	private void buttonClick(int xButton, int yButton, JButton button) {
		// Butten Press
		switch (logic.buttonPress(xButton, yButton)) {
		case 0: ;
			break;
		case 1: button.setIcon(new ImageIcon(GUI.class.getResource(player1_path)));			;
			break;
		case 2: button.setIcon(new ImageIcon(GUI.class.getResource(player2_path)));
			break;
		default: System.out.println("Error : Logic. ActivePlayer");
			break;
		}
		// CheckWin
		if (logic.checkWin()) {
			String print = "Player : " + logic.getActivePlayer() + ", Wins!";
			print(print);
		} else {
			logic.turn();
		}
	}
	
	private void print(String print) {
		winner_txt.setText(print);
	}

	public String getPlayer3_path() {
		return player3_path;
	}

	public void setPlayer3_path(String player3_path) {
		this.player3_path = player3_path;
	}

	public String getPlayer4_path() {
		return player4_path;
	}

	public void setPlayer4_path(String player4_path) {
		this.player4_path = player4_path;
	}

}
