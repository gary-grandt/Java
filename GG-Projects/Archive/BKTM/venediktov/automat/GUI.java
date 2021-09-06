package BKTM.venediktov.automat;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {
	//--- Variables ---
	Logic logic;

	JFrame automat_JFrame;
	JTextField warenAusgabe_text;
	JTextField warenAusgabe_textField;
	JTextField rueckgeld_text;
	JTextField rueckgeld_textField;
	private JTextField headLine_text;
	JTextField display_textField;
	private JTextField display_text;
	private JTextField auswahl_text;
	private JPanel payIn_top_panel;
	private JTextField txtEinzahlen;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.automat_JFrame.setVisible(true);
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
		logic = new Logic();
		logic.getParent(this);
		logic.fillUp();
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		automat_JFrame = new JFrame();
		automat_JFrame.setResizable(false);
		automat_JFrame.setTitle("Automat");
		automat_JFrame.setBackground(Color.DARK_GRAY);
		automat_JFrame.getContentPane().setBackground(Color.DARK_GRAY);
		
		JPanel top_panel = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) top_panel.getLayout();
		flowLayout_1.setVgap(16);
		flowLayout_1.setHgap(20);
		top_panel.setBackground(Color.DARK_GRAY);
		automat_JFrame.getContentPane().add(top_panel, BorderLayout.NORTH);
		
		JSplitPane top_splitPane = new JSplitPane();
		top_splitPane.setEnabled(false);
		top_splitPane.setForeground(Color.DARK_GRAY);
		top_splitPane.setBackground(Color.DARK_GRAY);
		top_panel.add(top_splitPane);
		
		JPanel headLine_panel = new JPanel();
		headLine_panel.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout_4 = (FlowLayout) headLine_panel.getLayout();
		flowLayout_4.setVgap(7);
		flowLayout_4.setHgap(8);
		headLine_panel.setForeground(Color.DARK_GRAY);
		top_splitPane.setLeftComponent(headLine_panel);
		
		headLine_text = new JTextField();
		headLine_text.setEditable(false);
		headLine_text.setForeground(Color.WHITE);
		headLine_text.setBackground(Color.DARK_GRAY);
		headLine_text.setHorizontalAlignment(SwingConstants.CENTER);
		headLine_text.setText("Bastler's Automat");
		headLine_panel.add(headLine_text);
		headLine_text.setColumns(12);
		
		JPanel resetControl_panel = new JPanel();
		resetControl_panel.setBackground(Color.ORANGE);
		top_splitPane.setRightComponent(resetControl_panel);
		
		JButton reset_Button = new JButton("Reset");
		reset_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.reset();
			}
		});
		reset_Button.setFont(new Font("Georgia", Font.PLAIN, 11));
		reset_Button.setForeground(Color.RED);
		reset_Button.setBackground(Color.DARK_GRAY);
		resetControl_panel.add(reset_Button);
		
		JButton control_Button = new JButton("C");
		control_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.control();
			}
		});
		control_Button.setForeground(Color.RED);
		control_Button.setBackground(Color.DARK_GRAY);
		resetControl_panel.add(control_Button);
		
		JPanel display_panel = new JPanel();
		top_panel.add(display_panel);
		
		display_text = new JTextField();
		display_text.setEditable(false);
		display_text.setHorizontalAlignment(SwingConstants.CENTER);
		display_text.setText("Eingezahlt : ");
		display_text.setForeground(Color.WHITE);
		display_text.setBackground(Color.DARK_GRAY);
		display_panel.add(display_text);
		display_text.setColumns(8);
		
		display_textField = new JTextField();
		display_textField.setEditable(false);
		display_textField.setHorizontalAlignment(SwingConstants.LEFT);
		display_textField.setForeground(Color.BLACK);
		display_textField.setBackground(Color.LIGHT_GRAY);
		display_panel.add(display_textField);
		display_textField.setColumns(24);
		
		JPanel porduct_panel = new JPanel();
		automat_JFrame.getContentPane().add(porduct_panel, BorderLayout.CENTER);
		porduct_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel productRow_panel_1 = new JPanel();
		productRow_panel_1.setBorder(null);
		productRow_panel_1.setBackground(Color.DARK_GRAY);
		FlowLayout fl_productRow_panel_1 = (FlowLayout) productRow_panel_1.getLayout();
		fl_productRow_panel_1.setVgap(8);
		fl_productRow_panel_1.setHgap(16);
		porduct_panel.add(productRow_panel_1, BorderLayout.NORTH);
		
		JSplitPane product_1_splitPane = new JSplitPane();
		product_1_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_1_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_1.add(product_1_splitPane);
		
		JLabel product_1_label = new JLabel("");
		product_1_label.setIcon(new ImageIcon("C:\\Images\\p1_Arduino-UNO.png"));
		product_1_splitPane.setLeftComponent(product_1_label);
		
		JButton product_1_button = new JButton("A. UNO - 6,45");
		product_1_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(1);
			}
		});
		product_1_button.setBackground(Color.LIGHT_GRAY);
		product_1_splitPane.setRightComponent(product_1_button);
		
		JSplitPane product_2_splitPane = new JSplitPane();
		product_2_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_2_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_1.add(product_2_splitPane);
		
		JLabel product_2_label = new JLabel("");
		product_2_label.setIcon(new ImageIcon("C:\\Images\\p2_Arduino-YUN.png"));
		product_2_splitPane.setLeftComponent(product_2_label);
		
		JButton product_2_button = new JButton("A. YUN - 23,35");
		product_2_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(2);
			}
		});
		product_2_button.setBackground(Color.LIGHT_GRAY);
		product_2_splitPane.setRightComponent(product_2_button);
		
		JSplitPane product_3_splitPane = new JSplitPane();
		productRow_panel_1.add(product_3_splitPane);
		product_3_splitPane.setBackground(Color.DARK_GRAY);
		product_3_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JLabel product_3_label = new JLabel("");
		product_3_label.setIcon(new ImageIcon("C:\\Images\\p3_Arduino-NANO.png"));
		product_3_splitPane.setLeftComponent(product_3_label);
		
		JButton product_3_button = new JButton("A. NONO - 1,45");
		product_3_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(3);
			}
		});
		product_3_button.setBackground(Color.LIGHT_GRAY);
		product_3_splitPane.setRightComponent(product_3_button);
		
		JPanel productRow_panel_2 = new JPanel();
		productRow_panel_2.setBackground(Color.DARK_GRAY);
		FlowLayout fl_productRow_panel_2 = (FlowLayout) productRow_panel_2.getLayout();
		fl_productRow_panel_2.setVgap(8);
		fl_productRow_panel_2.setHgap(16);
		porduct_panel.add(productRow_panel_2, BorderLayout.CENTER);
		
		JSplitPane product_4_splitPane = new JSplitPane();
		productRow_panel_2.add(product_4_splitPane);
		product_4_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JLabel product_4_label = new JLabel("");
		product_4_label.setIcon(new ImageIcon("C:\\Images\\p4_ESP-01.png"));
		product_4_splitPane.setLeftComponent(product_4_label);
		
		JButton product_4_button = new JButton("ESP-01 - 1,00");
		product_4_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(4);
			}
		});
		product_4_button.setBackground(Color.LIGHT_GRAY);
		product_4_splitPane.setRightComponent(product_4_button);
		
		JSplitPane product_5_splitPane = new JSplitPane();
		productRow_panel_2.add(product_5_splitPane);
		product_5_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		
		JLabel product_5_label = new JLabel("");
		product_5_label.setIcon(new ImageIcon("C:\\Images\\p5_ESP-2866.png"));
		product_5_splitPane.setLeftComponent(product_5_label);
		
		JButton product_5_button = new JButton("ESP-8266-4,45");
		product_5_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(5);
			}
		});
		product_5_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		product_5_button.setBackground(Color.LIGHT_GRAY);
		product_5_splitPane.setRightComponent(product_5_button);
		
		JSplitPane product_6_splitPane = new JSplitPane();
		product_6_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_6_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_2.add(product_6_splitPane);
		
		JLabel product_6_label = new JLabel("");
		product_6_label.setIcon(new ImageIcon("C:\\Images\\p6_D1-MINI.png"));
		product_6_splitPane.setLeftComponent(product_6_label);
		
		JButton product_6_button = new JButton("D1-MINI - 2,20");
		product_6_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(6);
			}
		});
		product_6_button.setBackground(Color.LIGHT_GRAY);
		product_6_splitPane.setRightComponent(product_6_button);
		
		JPanel productRow_panel_3 = new JPanel();
		productRow_panel_3.setBackground(Color.DARK_GRAY);
		FlowLayout fl_productRow_panel_3 = (FlowLayout) productRow_panel_3.getLayout();
		fl_productRow_panel_3.setVgap(8);
		fl_productRow_panel_3.setHgap(16);
		porduct_panel.add(productRow_panel_3, BorderLayout.SOUTH);
		
		JSplitPane product_7_splitPane = new JSplitPane();
		product_7_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_7_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_3.add(product_7_splitPane);
		
		JLabel product_7_label = new JLabel("");
		product_7_label.setIcon(new ImageIcon("C:\\Images\\p7_Kabel.png"));
		product_7_splitPane.setLeftComponent(product_7_label);
		
		JButton product_7_button = new JButton("Kabel - 3,45");
		product_7_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(7);
			}
		});
		product_7_button.setBackground(Color.LIGHT_GRAY);
		product_7_splitPane.setRightComponent(product_7_button);
		
		JSplitPane product_8_splitPane = new JSplitPane();
		product_8_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_8_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_3.add(product_8_splitPane);
		
		JLabel product_8_label = new JLabel("");
		product_8_label.setIcon(new ImageIcon("C:\\Images\\p8_L\u00F6tzinn.png"));
		product_8_splitPane.setLeftComponent(product_8_label);
		
		JButton product_8_button = new JButton("L\u00F6tzinn - 5,55");
		product_8_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(8);
			}
		});
		product_8_button.setBackground(Color.LIGHT_GRAY);
		product_8_splitPane.setRightComponent(product_8_button);
		
		JSplitPane product_9_splitPane = new JSplitPane();
		product_9_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		product_9_splitPane.setBackground(Color.DARK_GRAY);
		productRow_panel_3.add(product_9_splitPane);
		
		JLabel product_9_label = new JLabel("");
		product_9_label.setIcon(new ImageIcon("C:\\Images\\p9_Bridge.png"));
		product_9_splitPane.setLeftComponent(product_9_label);
		
		JButton product_9_button = new JButton("Conector-0,65");
		product_9_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(9);
			}
		});
		product_9_button.setBackground(Color.LIGHT_GRAY);
		product_9_splitPane.setRightComponent(product_9_button);
		
		JPanel left_panel = new JPanel();
		FlowLayout flowLayout_2 = (FlowLayout) left_panel.getLayout();
		flowLayout_2.setHgap(8);
		flowLayout_2.setVgap(32);
		left_panel.setBackground(Color.DARK_GRAY);
		automat_JFrame.getContentPane().add(left_panel, BorderLayout.EAST);
		
		JSplitPane left_splitPane = new JSplitPane();
		left_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		left_panel.add(left_splitPane);
		
		JSplitPane payInOut_splitPane = new JSplitPane();
		payInOut_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		left_splitPane.setLeftComponent(payInOut_splitPane);
		
		payIn_top_panel = new JPanel();
		FlowLayout flowLayout_7 = (FlowLayout) payIn_top_panel.getLayout();
		flowLayout_7.setHgap(3);
		flowLayout_7.setVgap(8);
		payIn_top_panel.setBackground(Color.DARK_GRAY);
		payInOut_splitPane.setLeftComponent(payIn_top_panel);
		
		JSplitPane PyIn_splitPane = new JSplitPane();
		PyIn_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		PyIn_splitPane.setBackground(Color.DARK_GRAY);
		payIn_top_panel.add(PyIn_splitPane);
		
		JPanel payIn_buttons_panel = new JPanel();
		payIn_buttons_panel.setBackground(Color.DARK_GRAY);
		PyIn_splitPane.setRightComponent(payIn_buttons_panel);
		payIn_buttons_panel.setLayout(new BorderLayout(0, 0));
		
		JPanel payIn_cts_panel = new JPanel();
		FlowLayout flowLayout_8 = (FlowLayout) payIn_cts_panel.getLayout();
		flowLayout_8.setHgap(3);
		payIn_cts_panel.setBackground(Color.DARK_GRAY);
		payIn_buttons_panel.add(payIn_cts_panel, BorderLayout.NORTH);
		
		JButton payIn_ct_5_button = new JButton("  5  ct  ");
		payIn_ct_5_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(1);
			}
		});
		payIn_ct_5_button.setForeground(Color.BLACK);
		payIn_ct_5_button.setBackground(Color.GRAY);
		payIn_cts_panel.add(payIn_ct_5_button);
		
		JButton payIn_ct_10_button = new JButton("  10 ct  ");
		payIn_ct_10_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(2);
			}
		});
		payIn_ct_10_button.setForeground(Color.BLACK);
		payIn_ct_10_button.setBackground(Color.GRAY);
		payIn_cts_panel.add(payIn_ct_10_button);
		
		JButton payIn_ct_20_button = new JButton("  20 ct  ");
		payIn_ct_20_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(3);
			}
		});
		payIn_ct_20_button.setForeground(Color.BLACK);
		payIn_ct_20_button.setBackground(Color.GRAY);
		payIn_cts_panel.add(payIn_ct_20_button);
		
		JPanel payIn_euros_panel = new JPanel();
		FlowLayout flowLayout_9 = (FlowLayout) payIn_euros_panel.getLayout();
		flowLayout_9.setHgap(3);
		payIn_euros_panel.setBackground(Color.DARK_GRAY);
		payIn_buttons_panel.add(payIn_euros_panel, BorderLayout.CENTER);
		
		JButton payIn_ct_50_button = new JButton("  ct 50  ");
		payIn_ct_50_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(4);
			}
		});
		payIn_ct_50_button.setForeground(Color.BLACK);
		payIn_ct_50_button.setBackground(Color.GRAY);
		payIn_euros_panel.add(payIn_ct_50_button);
		
		JButton payIn_euro_1_button = new JButton(" 1 Euro");
		payIn_euro_1_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(5);
			}
		});
		payIn_euro_1_button.setForeground(Color.BLACK);
		payIn_euro_1_button.setBackground(Color.GRAY);
		payIn_euros_panel.add(payIn_euro_1_button);
		
		JButton payIn_euro_2_button = new JButton(" 2 Euro");
		payIn_euro_2_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(6);
			}
		});
		payIn_euro_2_button.setForeground(Color.BLACK);
		payIn_euro_2_button.setBackground(Color.GRAY);
		payIn_euros_panel.add(payIn_euro_2_button);
		
		JPanel payIn_bills_panel = new JPanel();
		FlowLayout flowLayout_10 = (FlowLayout) payIn_bills_panel.getLayout();
		flowLayout_10.setHgap(3);
		payIn_buttons_panel.add(payIn_bills_panel, BorderLayout.SOUTH);
		payIn_bills_panel.setBackground(Color.DARK_GRAY);
		
		JButton payIn_euro_5_button = new JButton(" 5 Euro");
		payIn_euro_5_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(7);
			}
		});
		payIn_euro_5_button.setForeground(Color.BLACK);
		payIn_euro_5_button.setBackground(Color.GRAY);
		payIn_bills_panel.add(payIn_euro_5_button);
		
		JButton payIn_euro_10_button = new JButton("10 Euro");
		payIn_euro_10_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(8);
			}
		});
		payIn_euro_10_button.setForeground(Color.BLACK);
		payIn_euro_10_button.setBackground(Color.GRAY);
		payIn_bills_panel.add(payIn_euro_10_button);
		
		JButton payIn_euro_20_button = new JButton("20 Euro");
		payIn_euro_20_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payIn(9);
			}
		});
		payIn_euro_20_button.setForeground(Color.BLACK);
		payIn_euro_20_button.setBackground(Color.GRAY);
		payIn_bills_panel.add(payIn_euro_20_button);
		
		txtEinzahlen = new JTextField();
		txtEinzahlen.setText("Einzahlen : ");
		txtEinzahlen.setHorizontalAlignment(SwingConstants.CENTER);
		txtEinzahlen.setForeground(Color.WHITE);
		txtEinzahlen.setEditable(false);
		txtEinzahlen.setColumns(10);
		txtEinzahlen.setBackground(Color.DARK_GRAY);
		PyIn_splitPane.setLeftComponent(txtEinzahlen);
		
		JPanel payOut_panel = new JPanel();
		FlowLayout flowLayout_11 = (FlowLayout) payOut_panel.getLayout();
		flowLayout_11.setVgap(8);
		flowLayout_11.setHgap(8);
		payOut_panel.setForeground(Color.DARK_GRAY);
		payOut_panel.setBackground(Color.DARK_GRAY);
		payInOut_splitPane.setRightComponent(payOut_panel);
		
		JButton payOut_button = new JButton("Auszahlen");
		payOut_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.payOut();
			}
		});
		payOut_button.setForeground(Color.BLACK);
		payOut_button.setBackground(Color.GRAY);
		payOut_panel.add(payOut_button);
		
		JSplitPane auswahl_splitPane = new JSplitPane();
		auswahl_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		left_splitPane.setRightComponent(auswahl_splitPane);
		
		auswahl_text = new JTextField();
		auswahl_text.setEditable(false);
		auswahl_text.setForeground(Color.WHITE);
		auswahl_text.setHorizontalAlignment(SwingConstants.CENTER);
		auswahl_text.setText("Auswahl : ");
		auswahl_text.setBackground(Color.DARK_GRAY);
		auswahl_splitPane.setLeftComponent(auswahl_text);
		auswahl_text.setColumns(10);
		
		JPanel auswahl_panel = new JPanel();
		auswahl_panel.setBackground(Color.DARK_GRAY);
		auswahl_splitPane.setRightComponent(auswahl_panel);
		auswahl_panel.setLayout(new BorderLayout(0, 0));

		JPanel auswahl_123_panle = new JPanel();
		auswahl_123_panle.setBackground(Color.DARK_GRAY);
		FlowLayout fl_auswahl_123_panle = (FlowLayout) auswahl_123_panle.getLayout();
		fl_auswahl_123_panle.setVgap(8);
		auswahl_panel.add(auswahl_123_panle, BorderLayout.NORTH);
		
		JButton auswahl_1_Button = new JButton(" 1 ");
		auswahl_1_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(1);
			}
		});
		auswahl_1_Button.setForeground(Color.BLACK);
		auswahl_1_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_123_panle.add(auswahl_1_Button);
		
		JButton auswahl_2_Button = new JButton(" 2 ");
		auswahl_2_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(2);
			}
		});
		auswahl_2_Button.setForeground(Color.BLACK);
		auswahl_2_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_123_panle.add(auswahl_2_Button);
		
		JButton auswahl_3_Button = new JButton(" 3 ");
		auswahl_3_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(3);
			}
		});
		auswahl_3_Button.setForeground(Color.BLACK);
		auswahl_3_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_123_panle.add(auswahl_3_Button);
		
		JPanel auswahl_456_pane = new JPanel();
		auswahl_456_pane.setBackground(Color.DARK_GRAY);
		FlowLayout flowLayout = (FlowLayout) auswahl_456_pane.getLayout();
		flowLayout.setVgap(8);
		auswahl_panel.add(auswahl_456_pane, BorderLayout.CENTER);
		
		JButton auswahl_4_Button = new JButton(" 4 ");
		auswahl_4_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(4);
			}
		});
		auswahl_4_Button.setForeground(Color.BLACK);
		auswahl_4_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_456_pane.add(auswahl_4_Button);
		
		JButton auswahl_5_Button = new JButton(" 5 ");
		auswahl_5_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(5);
			}
		});
		auswahl_5_Button.setForeground(Color.BLACK);
		auswahl_5_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_456_pane.add(auswahl_5_Button);
		
		JButton auswahl_6_Button = new JButton(" 6 ");
		auswahl_6_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(6);
			}
		});
		auswahl_6_Button.setForeground(Color.BLACK);
		auswahl_6_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_456_pane.add(auswahl_6_Button);
		
		JPanel auswahl_789_panel = new JPanel();
		auswahl_789_panel.setBackground(Color.DARK_GRAY);
		FlowLayout fl_auswahl_789_panel = (FlowLayout) auswahl_789_panel.getLayout();
		fl_auswahl_789_panel.setVgap(8);
		auswahl_panel.add(auswahl_789_panel, BorderLayout.SOUTH);
		
		JButton auswahl_7_Button = new JButton(" 7 ");
		auswahl_7_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(7);
			}
		});
		auswahl_7_Button.setForeground(Color.BLACK);
		auswahl_7_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_789_panel.add(auswahl_7_Button);
		
		JButton auswahl_8_Button = new JButton(" 8 ");
		auswahl_8_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(8);
			}
		});
		auswahl_8_Button.setForeground(Color.BLACK);
		auswahl_8_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_789_panel.add(auswahl_8_Button);
		
		JButton auswahl_9_Button = new JButton(" 9 ");
		auswahl_9_Button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				logic.buyProduct(9);
			}
		});
		auswahl_9_Button.setForeground(Color.BLACK);
		auswahl_9_Button.setBackground(Color.LIGHT_GRAY);
		auswahl_789_panel.add(auswahl_9_Button);
		
		
		JPanel bottom_panel = new JPanel();
		FlowLayout flowLayout_bottom = (FlowLayout) bottom_panel.getLayout();
		flowLayout_bottom.setVgap(0);
		flowLayout_bottom.setHgap(88);
		bottom_panel.setBackground(Color.DARK_GRAY);
		automat_JFrame.getContentPane().add(bottom_panel, BorderLayout.SOUTH);
		
		JPanel warenAusgabe_panel = new JPanel();
		FlowLayout flowLayout_3 = (FlowLayout) warenAusgabe_panel.getLayout();
		flowLayout_3.setHgap(8);
		warenAusgabe_panel.setBackground(Color.DARK_GRAY);
		bottom_panel.add(warenAusgabe_panel);
		
		JSplitPane warenAusgabe_splitPane = new JSplitPane();
		warenAusgabe_splitPane.setBackground(Color.DARK_GRAY);
		warenAusgabe_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		warenAusgabe_panel.add(warenAusgabe_splitPane);
		
		JPanel warenAusgabe_text_panel = new JPanel();
		warenAusgabe_text_panel.setBackground(Color.DARK_GRAY);
		warenAusgabe_splitPane.setLeftComponent(warenAusgabe_text_panel);
		
		warenAusgabe_text = new JTextField();
		warenAusgabe_text.setHorizontalAlignment(SwingConstants.CENTER);
		warenAusgabe_text.setEditable(false);
		warenAusgabe_text_panel.add(warenAusgabe_text);
		warenAusgabe_text.setBackground(Color.DARK_GRAY);
		warenAusgabe_text.setForeground(Color.LIGHT_GRAY);
		warenAusgabe_text.setText("Warenausgabe : ");
		warenAusgabe_text.setColumns(16);
		
		JPanel warenAusgabe_textField_panel = new JPanel();
		warenAusgabe_textField_panel.setBackground(Color.DARK_GRAY);
		FlowLayout fl_warenAusgabe_textField_panel = (FlowLayout) warenAusgabe_textField_panel.getLayout();
		fl_warenAusgabe_textField_panel.setHgap(8);
		fl_warenAusgabe_textField_panel.setVgap(8);
		warenAusgabe_splitPane.setRightComponent(warenAusgabe_textField_panel);
		
		warenAusgabe_textField = new JTextField();
		warenAusgabe_textField_panel.add(warenAusgabe_textField);
		warenAusgabe_textField.setBackground(Color.LIGHT_GRAY);
		warenAusgabe_textField.setColumns(23);
		
		JPanel rueckgeld_panel = new JPanel();
		rueckgeld_panel.setBackground(Color.DARK_GRAY);
		bottom_panel.add(rueckgeld_panel);
		
		JSplitPane rueckgeld_splitPane = new JSplitPane();
		rueckgeld_splitPane.setBackground(Color.DARK_GRAY);
		rueckgeld_splitPane.setOrientation(JSplitPane.VERTICAL_SPLIT);
		rueckgeld_panel.add(rueckgeld_splitPane);
		
		JPanel rueckgeld_text_panel = new JPanel();
		FlowLayout flowLayout_6 = (FlowLayout) rueckgeld_text_panel.getLayout();
		flowLayout_6.setVgap(8);
		flowLayout_6.setHgap(8);
		rueckgeld_text_panel.setBackground(Color.DARK_GRAY);
		rueckgeld_text_panel.setForeground(Color.DARK_GRAY);
		rueckgeld_splitPane.setLeftComponent(rueckgeld_text_panel);
		
		rueckgeld_text = new JTextField();
		rueckgeld_text.setEditable(false);
		rueckgeld_text_panel.add(rueckgeld_text);
		rueckgeld_text.setForeground(Color.LIGHT_GRAY);
		rueckgeld_text.setHorizontalAlignment(SwingConstants.CENTER);
		rueckgeld_text.setBackground(Color.DARK_GRAY);
		rueckgeld_text.setText("R\u00FCckgeld : ");
		rueckgeld_text.setColumns(16);
		
		JPanel rueckgeld_textField_panel = new JPanel();
		FlowLayout flowLayout_5 = (FlowLayout) rueckgeld_textField_panel.getLayout();
		flowLayout_5.setVgap(8);
		flowLayout_5.setHgap(8);
		rueckgeld_textField_panel.setBackground(Color.DARK_GRAY);
		rueckgeld_splitPane.setRightComponent(rueckgeld_textField_panel);
		
		rueckgeld_textField = new JTextField();
		rueckgeld_textField.setBackground(Color.LIGHT_GRAY);
		rueckgeld_textField_panel.add(rueckgeld_textField);
		rueckgeld_textField.setColumns(16);
		
		JButton btnNewButton = new JButton("C");
		btnNewButton.setBackground(Color.DARK_GRAY);
		bottom_panel.add(btnNewButton);
		automat_JFrame.setBounds(100, 100, 720, 720);
		automat_JFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	//----------------
	//--- Methods ---
	//----------------
	
	// Display Eingabe
	public void display(String input) {
		display_textField.setText(input);
	}
	
	//Display Ausgabe 
	public void display_ausgabe(String input) {
		warenAusgabe_textField.setText(input);
	}
	
	//Display Rueckgeld
	public void display_rueckgeld(String input) {
		rueckgeld_textField.setText(input);
	}

	
}






























