package cs259signal;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Button;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.Choice;
import java.awt.Canvas;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Label;

public class MusicBox extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;
	private JTextField textField_2;
	
	int xx,xy;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MusicBox frame = new MusicBox();
					frame.setUndecorated(true);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	// going to borrow code from a gist to move frame.
	

	/**
	 * Create the frame.
	 */
	public MusicBox() {
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 729, 476);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Square s1 = new Square(0.5f);
		Sawtooth sw = new Sawtooth();
		Triangle tr = new Triangle();
		SineWave sn = new SineWave(); 
		
		JLabel lbl_close = new JLabel("X");
		lbl_close.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				System.exit(0);
			}
		});
		lbl_close.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_close.setForeground(new Color(255, 255, 102));
		lbl_close.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lbl_close.setBounds(691, 0, 37, 27);
		contentPane.add(lbl_close);
		
		Button button = new Button("PLAY");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		button.setForeground(new Color(51, 51, 51));
		button.setBackground(new Color(255, 255, 153));
		button.setBounds(35, 350, 283, 36);
		contentPane.add(button);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.PINK);
		panel.setBounds(0, 0, 356, 501);
		contentPane.add(panel);
		panel.setLayout(null);
		
		textField_2 = new JTextField();
		textField_2.setBounds(35, 275, 283, 36);
		panel.add(textField_2);
		
		JLabel lblPassword = new JLabel("DURATION");
		lblPassword.setBounds(35, 250, 96, 14);
		panel.add(lblPassword);
		
		textField_1 = new JTextField();
		textField_1.setBounds(35, 205, 283, 36);
		panel.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEmail = new JLabel("FREQUENCY");
		lblEmail.setBounds(35, 180, 69, 14);
		panel.add(lblEmail);
		
		Choice choice = new Choice();
		choice.setBounds(35, 155, 283, 20);
		panel.add(choice);
		
		
		JLabel lblUsername = new JLabel("SIGNAL TYPE");
		lblUsername.setBounds(35, 130, 114, 14);
		panel.add(lblUsername);
		
		Label label = new Label("MUSIC BOX");
		label.setAlignment(Label.CENTER);
		label.setFont(new Font("8BIT WONDER", Font.BOLD | Font.ITALIC, 17));
		label.setBounds(35, 10, 283, 116);
		panel.add(label);
		choice.add("");
		choice.add("Triangle");
		choice.add("Square");
		choice.add("Sawtooth");
		choice.add("Sine");
		button.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					String signalType = choice.getItem(choice.getSelectedIndex());
					int pitch = Integer.parseInt(textField_1.getText());
					float duration = Float.parseFloat(textField_2.getText());
					Beep.playBeep(signalType, pitch, duration);
				} catch (Exception e1) {
					System.out.println("ERROR");
					System.exit(0);
				}
			}
		});
	}
}