package team03.C4_M4_Mastermind;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.Toolkit;

public class DificultdadUsuario extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	public int intentos = 10;
	public int colores = 4;
	private ButtonGroup bgroup;
	private JRadioButton rdbtnPrincipiante, rdbtnMedio, rdbtnAvanzado;
	private JButton btnAceptar, btnCancelar;

	/**
	 * Create the frame.
	 */
	public DificultdadUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DificultdadUsuario.class.getResource("/imagenes/icono.png")));
		setTitle("Seleccionar nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 415, 468);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("Selecciona la dificultad");
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(75, 28, 251, 59);
		contentPane.add(lblNewLabel);

		// --------------------------- RADIO BUTTONS ---------------------------

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(102, 123, 197, 108);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		rdbtnPrincipiante = new JRadioButton("Principiante");
		rdbtnPrincipiante.setSelected(true);
		rdbtnPrincipiante.setBounds(25, 0, 147, 34);
		panel_1.add(rdbtnPrincipiante);
		rdbtnPrincipiante.setFont(new Font("Arial", Font.PLAIN, 20));

		rdbtnMedio = new JRadioButton("Medio");
		rdbtnMedio.setBounds(25, 37, 147, 34);
		panel_1.add(rdbtnMedio);
		rdbtnMedio.setFont(new Font("Arial", Font.PLAIN, 20));

		rdbtnAvanzado = new JRadioButton("Avanzado");
		rdbtnAvanzado.setBounds(25, 74, 147, 34);
		panel_1.add(rdbtnAvanzado);
		rdbtnAvanzado.setFont(new Font("Arial", Font.PLAIN, 20));

		bgroup = new ButtonGroup();
		bgroup.add(rdbtnPrincipiante);
		bgroup.add(rdbtnMedio);
		bgroup.add(rdbtnAvanzado);

		// --------------------------- BUTTONS ---------------------------

		JPanel panel = new JPanel();
		panel.setBounds(57, 314, 286, 34);
		contentPane.add(panel);
		panel.setLayout(null);

		btnAceptar = new JButton("Aceptar");
		btnAceptar.setBounds(0, 0, 138, 34);
		panel.add(btnAceptar);
		btnAceptar.setFont(new Font("Arial", Font.PLAIN, 19));

		btnAceptar.addActionListener(accept);

		btnCancelar = new JButton("Cancelar");
		btnCancelar.setBounds(148, 0, 138, 34);
		panel.add(btnCancelar);
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 19));

		btnCancelar.addActionListener(cancelar);

		setVisible(true);
		
	}

	// --------------------------- BUTTON HACER CLIC ---------------------------

	ActionListener accept = new ActionListener() {
		public void actionPerformed(ActionEvent e) {

			JRadioButton[] btnDificultad = { rdbtnPrincipiante, rdbtnMedio, rdbtnAvanzado };
			String seleccionado;

			// Recorremos el array en y mostramos el SO seleccionado
			for (int i = 0; i < btnDificultad.length; i++) {
				if (btnDificultad[i].isSelected()) {
					seleccionado = btnDificultad[i].getText();
					switch (seleccionado) {
					case "Principiante":
						intentos = 10;
						colores = 4;
						break;
					case "Medio":
						intentos = 8;
						colores = 5;
						break;
					case "Avanzado":
						intentos = 6;
						colores = 6;
						break;
					default:
						intentos = 10;
						colores = 4;
						break;
					}
				}
			}
			
			new vista(intentos, colores);
			setVisible(false);
		}
	};

	ActionListener cancelar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			intentos = 10;
			colores = 4;
			new vista(intentos, colores);
			setVisible(false);
		}
	};
}
