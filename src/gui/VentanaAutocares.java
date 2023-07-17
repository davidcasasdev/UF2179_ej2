package gui;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpinnerNumberModel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import clases.Autocar;
import net.miginfocom.swing.MigLayout;
import javax.swing.JScrollPane;

public class VentanaAutocares extends JFrame {

	private JPanel contentPane;
	private JTextField txtMatricula;
	private JTextField txtMarca;
	private JTextField txtModelo;
	private JTextField txtKms;
	
	private ArrayList<Autocar> listaAutocares;
	private JSpinner spinner;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaAutocares frame = new VentanaAutocares();
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
	public VentanaAutocares() {
		listaAutocares=new ArrayList<Autocar>();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(new MigLayout("", "[grow][][grow][][grow]", "[][][][][][grow]"));
		
		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		panel_1.setBackground(new Color(0, 255, 255));
		contentPane.add(panel_1, "cell 0 0 5 1,grow");
		
		JLabel lblNewLabel_5 = new JLabel("Gestión autocares");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel = new JLabel("Matrícula:");
		contentPane.add(lblNewLabel, "cell 1 1,alignx trailing");
		
		txtMatricula = new JTextField();
		contentPane.add(txtMatricula, "cell 2 1,growx");
		txtMatricula.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Marca:");
		contentPane.add(lblNewLabel_1, "cell 1 2,alignx trailing");
		
		txtMarca = new JTextField();
		contentPane.add(txtMarca, "cell 2 2,growx");
		txtMarca.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("Modelo:");
		contentPane.add(lblNewLabel_3, "cell 3 2,alignx trailing");
		
		txtModelo = new JTextField();
		contentPane.add(txtModelo, "cell 4 2,growx");
		txtModelo.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Kilómetros:");
		contentPane.add(lblNewLabel_2, "cell 1 3,alignx trailing");
		
		txtKms = new JTextField();
		contentPane.add(txtKms, "cell 2 3,growx");
		txtKms.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("Plazas:");
		contentPane.add(lblNewLabel_4, "cell 3 3");
		
		spinner = new JSpinner();
		spinner.setModel(new SpinnerNumberModel(30, 1, 80, 1));
		contentPane.add(spinner, "cell 4 3");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, "cell 0 4 5 1,grow");
		
		JButton btnNewButton = new JButton("Insertar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Autocar a= recogerDatos();
				if (a!=null)
					insertarAutocar(a);
			}
		});
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("MostrarDatos");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mostrarDatos();
			}
		});
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, "cell 0 5 5 1,grow");
		
		textArea = new JTextArea();
		scrollPane.setViewportView(textArea);
		textArea.setEditable(false);
	}

	protected void mostrarDatos() {
		textArea.setText("");
		for (Autocar autocar : listaAutocares) {
			textArea.setText(textArea.getText()+autocar+"\n");
			textArea.setText(textArea.getText()+"-----------------\n");
		}
		
	}

	protected Autocar recogerDatos() {
		try {
			
			String matricula = txtMatricula.getText();
			String marca = txtMarca.getText();
			String modelo = txtModelo.getText();
			int km = Integer.parseInt(txtKms.getText());
			int plazas = (Integer)spinner.getValue();
			
			if (matricula == null || matricula.isBlank() ||
					modelo == null || modelo.isBlank() ||
					marca == null || marca.isBlank() ) {
				
				JOptionPane.showMessageDialog(contentPane, 
						"Debe rellenar los campos de modelo, marca y matrícula", 
						"Error en los datos", 
						JOptionPane.ERROR_MESSAGE);
				return null;
			}
			Autocar ac= new Autocar(matricula, marca, modelo, km, plazas);
			
			return ac;
		} catch(NumberFormatException e) {
			JOptionPane.showMessageDialog(contentPane, 
					"Debe introducir un número correcto en Kilómetros", 
					"Error en los datos", 
					JOptionPane.ERROR_MESSAGE);
			return null;
		}
	}

	protected void insertarAutocar(Autocar a) {
		if (listaAutocares.contains(a)) {
			JOptionPane.showMessageDialog(contentPane, 
					"El autocar con matrícula "+a.getMatricula()+ " ya existe.", 
					"Error en los datos", 
					JOptionPane.ERROR_MESSAGE);
			return;
		}
		this.listaAutocares.add(a);
	}

	protected JTextArea getTextArea() {
		return textArea;
	}
}
