package vt09;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JSlider;
import javax.swing.JScrollPane;
import java.awt.Button;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.ImageIcon;

public class Ejemplo extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JRadioButton rdbtnMuyFeliz, rdbtnFelizASecas, rdbtnNoFeliz;
	private JLabel lblIMG_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ejemplo frame = new Ejemplo();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Ejemplo() {
		setBackground(new Color(255, 255, 255));
		setTitle("Ejemplo");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelOpciones = new JPanel();
		panelOpciones.setBounds(68, 67, 340, 36);
		contentPane.add(panelOpciones);
		
		JRadioButton rdbtnMuyFeliz = new JRadioButton("S\u00ED, soy muy feliz");
		panelOpciones.add(rdbtnMuyFeliz);
		
		JRadioButton rdbtnFelizASecas = new JRadioButton("S\u00ED, soy feliz");
		panelOpciones.add(rdbtnFelizASecas);
		
		JRadioButton rdbtnNoFeliz = new JRadioButton("No, no soy feliz");
		panelOpciones.add(rdbtnNoFeliz);
		
		JLabel lblNewLabel = new JLabel("\u00BFEres feliz?");
		lblNewLabel.setBounds(149, 26, 155, 31);
		lblNewLabel.setFont(new Font("Arial Black", Font.PLAIN, 24));
		contentPane.add(lblNewLabel);
		
		ButtonGroup bg = new ButtonGroup();
		bg.add(rdbtnNoFeliz);
		bg.add(rdbtnFelizASecas);
		bg.add(rdbtnMuyFeliz);
		
		JPanel panel = new JPanel();
		panel.setBounds(32, 145, 404, 108);
		contentPane.add(panel);
		
		lblIMG_1 = new JLabel("");
		panel.add(lblIMG_1);
		
		rdbtnMuyFeliz.addActionListener(this);
		rdbtnFelizASecas.addActionListener(this);
		rdbtnNoFeliz.addActionListener(this);
		
		

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		ImageIcon imagen = new ImageIcon();
		if(e.getSource()==rdbtnMuyFeliz) {
			imagen = new ImageIcon("src/images/logo_ilerna.png");
		}else if(e.getSource()==rdbtnFelizASecas) {
			imagen = new ImageIcon("src/images/Asusrog-logo.jpg");
		}else if(e.getSource()==rdbtnNoFeliz) {
			imagen = new ImageIcon("src/images/moodlelogo.png");
		}
		Image imagenAjustada = imagen.getImage().getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		 lblIMG_1.setIcon(new ImageIcon(imagenAjustada));
	}
}
