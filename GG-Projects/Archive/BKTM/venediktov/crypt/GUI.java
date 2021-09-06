package BKTM.venediktov.crypt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.Color;
import java.awt.GridBagLayout;
import javax.swing.JPanel;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import javax.swing.JButton;
import javax.swing.JSpinner;
import javax.swing.SpinnerListModel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class GUI {

	private JFrame frmCryptGui;
	private JTextField key_text;
	private JTextField key_textField;
	private Crypt crypt;
	private int choosen = -1;
	private JTextField input_textField;
	private JTextField output_textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GUI window = new GUI();
					window.frmCryptGui.setVisible(true);
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
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		//For EnDeCryption
		crypt = new Crypt();
		
		frmCryptGui = new JFrame();
		frmCryptGui.getContentPane().setBackground(Color.DARK_GRAY);
		frmCryptGui.setBackground(Color.DARK_GRAY);
		frmCryptGui.setTitle("Crypt GUI");
		frmCryptGui.setBounds(100, 100, 640, 320);
		frmCryptGui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{1.0, 1.0, 1.0, Double.MIN_VALUE};
		frmCryptGui.getContentPane().setLayout(gridBagLayout);
		
		JPanel enCrypt_panel = new JPanel();
		enCrypt_panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_enCrypt_panel = new GridBagConstraints();
		gbc_enCrypt_panel.fill = GridBagConstraints.BOTH;
		gbc_enCrypt_panel.insets = new Insets(0, 0, 5, 0);
		gbc_enCrypt_panel.gridx = 0;
		gbc_enCrypt_panel.gridy = 0;
		frmCryptGui.getContentPane().add(enCrypt_panel, gbc_enCrypt_panel);
		GridBagLayout gbl_enCrypt_panel = new GridBagLayout();
		gbl_enCrypt_panel.columnWidths = new int[]{0, 0};
		gbl_enCrypt_panel.rowHeights = new int[]{0, 0, 0};
		gbl_enCrypt_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_enCrypt_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		enCrypt_panel.setLayout(gbl_enCrypt_panel);
		
		JButton enCrypt_button = new JButton("Verschl\u00FCsseln");
		enCrypt_button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		enCrypt_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String buffer = input_textField.getText();
				String key = key_textField.getText();
				switch(choosen) {
				case 1: buffer = crypt.ceaser_encrypt(buffer);
					break;
				case 2: buffer = crypt.rotX_encrypt(buffer, Integer.parseInt(key));
					break;
				case 3: buffer = crypt.rotX_ASCI_encrypt(buffer, Integer.parseInt(key));
					break;
				case 4: buffer = crypt.vigenre_encrypt(buffer, key);
					break;
				case 5: buffer = crypt.vigenre_ASCI_encrypt(buffer, key);
					break;
				default: display("Please choose an Crypt-Algo!");
				}
				output_textField.setText(buffer);
			}
		});
		GridBagConstraints gbc_enCrypt_button = new GridBagConstraints();
		gbc_enCrypt_button.insets = new Insets(0, 0, 5, 0);
		gbc_enCrypt_button.gridx = 0;
		gbc_enCrypt_button.gridy = 0;
		enCrypt_panel.add(enCrypt_button, gbc_enCrypt_button);
		
		input_textField = new JTextField();
		GridBagConstraints gbc_input_textField = new GridBagConstraints();
		gbc_input_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_input_textField.gridx = 0;
		gbc_input_textField.gridy = 1;
		enCrypt_panel.add(input_textField, gbc_input_textField);
		input_textField.setColumns(64);
		
		JPanel key_panel = new JPanel();
		FlowLayout fl_key_panel = (FlowLayout) key_panel.getLayout();
		fl_key_panel.setVgap(0);
		fl_key_panel.setHgap(8);
		key_panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_key_panel = new GridBagConstraints();
		gbc_key_panel.insets = new Insets(0, 0, 5, 0);
		gbc_key_panel.fill = GridBagConstraints.HORIZONTAL;
		gbc_key_panel.gridx = 0;
		gbc_key_panel.gridy = 1;
		frmCryptGui.getContentPane().add(key_panel, gbc_key_panel);
		
		JSpinner algo_spinner = new JSpinner();
		algo_spinner.addChangeListener(new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				String buffer = (String)algo_spinner.getValue();
				switch(buffer) {
				case "Ceaser": choosen = 1;
					break;
				case "RotX": choosen = 2;
					break;
				case "RotXASCI": choosen = 3;
					break;
				case "Vigenere": choosen = 4;
					break;
				case "VigenereASCI": choosen = 5;
					break;
				default : choosen = -1;;
				}
			}
		});
		algo_spinner.setModel(new SpinnerListModel(new String[] {"ChosseTheAlgorithmus", "Ceaser", "RotX", "RotXASCI", "Vigenere", "VigenereASCI"}));
		key_panel.add(algo_spinner);
		
		key_text = new JTextField();
		key_text.setEditable(false);
		key_text.setHorizontalAlignment(SwingConstants.CENTER);
		key_text.setForeground(Color.YELLOW);
		key_text.setBackground(Color.DARK_GRAY);
		key_text.setText("KEY:");
		key_panel.add(key_text);
		key_text.setColumns(4);
		
		key_textField = new JTextField();
		key_panel.add(key_textField);
		key_textField.setColumns(32);
		
		JPanel deCrypt_panel = new JPanel();
		deCrypt_panel.setBackground(Color.DARK_GRAY);
		GridBagConstraints gbc_deCrypt_panel = new GridBagConstraints();
		gbc_deCrypt_panel.fill = GridBagConstraints.BOTH;
		gbc_deCrypt_panel.gridx = 0;
		gbc_deCrypt_panel.gridy = 2;
		frmCryptGui.getContentPane().add(deCrypt_panel, gbc_deCrypt_panel);
		GridBagLayout gbl_deCrypt_panel = new GridBagLayout();
		gbl_deCrypt_panel.columnWidths = new int[]{0, 0};
		gbl_deCrypt_panel.rowHeights = new int[]{0, 0, 0};
		gbl_deCrypt_panel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_deCrypt_panel.rowWeights = new double[]{0.0, 1.0, Double.MIN_VALUE};
		deCrypt_panel.setLayout(gbl_deCrypt_panel);
		
		JButton deCrypt_button = new JButton("Entschl\u00FCsseln");
		deCrypt_button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String buffer = input_textField.getText();
				String key = key_textField.getText();
				switch(choosen) {
				case 1: buffer = crypt.ceaser_decrypt(buffer);
					break;
				case 2: buffer = crypt.rotX_decrypt(buffer, Integer.parseInt(key));
					break;
				case 3: buffer = crypt.rotX_ASCI_decrypt(buffer, Integer.parseInt(key));
					break;
				case 4: buffer = crypt.vigenre_decrypt(buffer, key);
					break;
				case 5: buffer = crypt.vigenre_ASCI_decrypt(buffer, key);
					break;
				default: display("Please choose an Crypt-Algo!");
				}
				output_textField.setText(buffer);
			}
		});
		GridBagConstraints gbc_deCrypt_button = new GridBagConstraints();
		gbc_deCrypt_button.insets = new Insets(0, 0, 5, 0);
		gbc_deCrypt_button.gridx = 0;
		gbc_deCrypt_button.gridy = 0;
		deCrypt_panel.add(deCrypt_button, gbc_deCrypt_button);
		
		output_textField = new JTextField();
		GridBagConstraints gbc_output_textField = new GridBagConstraints();
		gbc_output_textField.fill = GridBagConstraints.HORIZONTAL;
		gbc_output_textField.gridx = 0;
		gbc_output_textField.gridy = 1;
		deCrypt_panel.add(output_textField, gbc_output_textField);
		output_textField.setColumns(64);
	}
	
	private void display(String display) {
		key_textField.setText(display);
	}
	
}
