package team03.C4_M4_Mastermind;

import java.awt.Color;
import java.awt.Desktop;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JSplitPane;

public class vista extends JFrame {
	// Variables globales (las usamos en todas las partes del proyecto)
	private static final long serialVersionUID = 1L;
	private JPanel contentPane1, panelColores, panelSolucion;
	private JButton btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6;
	private JButton btn1e, btn2e, btn3e, btn4e;
	private JLabel lblNumeroIntento;
	private JPanel panel, panel_1;
	private JButton btnNewButton, btnNewButton_1, btnNewButton_2, btnNewButton_3;
	private JButton btnBN1, btnBN2, btnBN3, btnBN4;
	private JCheckBoxMenuItem chckbxmntmMostrarSolucion;
	private JMenuItem mntmAyuda, mntmInformacion;
	private JButton comp;
	private JButton[] btnSelecionados = new JButton[4];
	private Color[] arrayDificultad, arraySolucion;
	private Color[] arrCol = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray, Color.blue,
			Color.orange, Color.magenta, Color.cyan };
	private final ArrayList<JButton> botones = new ArrayList<>();
	private int intentosVista, numIntentos = 0, altura = 119, intentosLabel = 0, posicion1 = 4, posicion2 = 4;
	private JButton btnNewGame;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;

	public vista(int intentos, int colores) {
		intentosVista = intentos;
		setResizable(false);
		arrayDificultad = new Color[colores];
		arraySolucion = new Color[4];
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(vista.class.getResource("/team03/C4_M4_Mastermind/assets/icono.png")));
		setTitle("MasterMind"); // Ponemos el título de la ventana de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 772);
		contentPane1 = new JPanel();
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		// ------------------------------------------------------------------------------------

		panelSolucion = new JPanel();
		panelSolucion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Combinaci\u00F3n secreta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSolucion.setBounds(559, 332, 252, 68);
		contentPane1.add(panelSolucion);
		panelSolucion.setLayout(null);
		panelSolucion.setVisible(false);

		btn1e = new JButton("");
		btn1e.setBounds(10, 23, 30, 30);
		panelSolucion.add(btn1e);
		btn1e.setEnabled(false);

		btn2e = new JButton("");
		btn2e.setBounds(50, 23, 30, 30);
		panelSolucion.add(btn2e);
		btn2e.setEnabled(false);

		btn3e = new JButton("");
		btn3e.setBounds(90, 23, 30, 30);
		panelSolucion.add(btn3e);
		btn3e.setEnabled(false);

		btn4e = new JButton("");
		btn4e.setBounds(130, 23, 30, 30);
		panelSolucion.add(btn4e);
		btn4e.setEnabled(false);

		panelColores = new JPanel();
		panelColores.setLayout(null);
		panelColores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColores.setBounds(559, 242, 252, 68);
		contentPane1.add(panelColores);

		btnColor1 = new JButton("");
		btnColor1.setBounds(10, 23, 30, 30);
		panelColores.add(btnColor1);
		btnColor1.setVisible(false);
		btnColor1.setEnabled(false);

		btnColor2 = new JButton("");
		btnColor2.setBounds(50, 23, 30, 30);
		panelColores.add(btnColor2);
		btnColor2.setVisible(false);
		btnColor2.setEnabled(false);

		btnColor3 = new JButton("");
		btnColor3.setBounds(90, 23, 30, 30);
		panelColores.add(btnColor3);
		btnColor3.setVisible(false);
		btnColor3.setEnabled(false);

		btnColor4 = new JButton("");
		btnColor4.setBounds(130, 23, 30, 30);
		panelColores.add(btnColor4);
		btnColor4.setVisible(false);
		btnColor4.setEnabled(false);

		btnColor5 = new JButton("");
		btnColor5.setBounds(170, 23, 30, 30);
		panelColores.add(btnColor5);
		btnColor5.setVisible(false);
		btnColor5.setEnabled(false);

		btnColor6 = new JButton("");
		btnColor6.setBounds(210, 23, 30, 30);
		panelColores.add(btnColor6);
		btnColor6.setEnabled(false);
		btnColor6.setVisible(false);
		
		btnNewGame = new JButton("Nueva partida");
		btnNewGame.setForeground(new Color(0, 102, 153));
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewGame.setBackground(new Color(255, 255, 255));
		btnNewGame.setBounds(559, 119, 252, 43);
		contentPane1.add(btnNewGame);
		
		lblNewLabel = new JLabel("MASTERMIND");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 32));
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setBounds(30, 48, 781, 60);
		contentPane1.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("Nivel actual");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(559, 548, 252, 43);
		contentPane1.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_2.setBounds(559, 587, 252, 43);
		contentPane1.add(lblNewLabel_2);
		labelDificultad(intentos);
		
		lblNewLabel_3 = new JLabel("Intentos");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(735, 628, 76, 43);
		contentPane1.add(lblNewLabel_3);
		
		lblNewLabel_4 = new JLabel("" + intentos);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 20));
		lblNewLabel_4.setBounds(697, 628, 35, 43);
		contentPane1.add(lblNewLabel_4);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1026, 31);
		contentPane1.add(menuBar);

		JMenu mnOpciones = new JMenu("Opciones");
		menuBar.add(mnOpciones);

		chckbxmntmMostrarSolucion = new JCheckBoxMenuItem("Mostrar Solución");
		chckbxmntmMostrarSolucion.setSelected(false);
		mnOpciones.add(chckbxmntmMostrarSolucion);
		chckbxmntmMostrarSolucion.addActionListener(mostrarSolucion);

		JMenu mnAbout = new JMenu("Ayuda");
		menuBar.add(mnAbout);

		mntmAyuda = new JMenuItem("Ayuda");
		mnAbout.add(mntmAyuda);

		mntmAyuda.addActionListener(mostrarAyuda);

		mntmInformacion = new JMenuItem("Información");
		mnAbout.add(mntmInformacion);
		mntmInformacion.addActionListener(mostrarInformacion);

		btnSelecionados[0] = btn1e;
		btnSelecionados[1] = btn2e;
		btnSelecionados[2] = btn3e;
		btnSelecionados[3] = btn4e;

		comp = new JButton("Comprobar");
		comp.setForeground(new Color(255, 255, 255));
		comp.setFont(new Font("Tahoma", Font.BOLD, 23));
		comp.setBackground(new Color(0, 102, 153));
		comp.setBounds(559, 173, 252, 43);
		contentPane1.add(comp);

		setVisible(true);
		crear(botones, arrayDificultad);

		JButton[] btnColoresDisponibles = { btnColor1, btnColor2, btnColor3, btnColor4, btnColor5, btnColor6 };
		ArrayList<Integer> numbers = new ArrayList<Integer>();

		comp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar(intentosVista);
			}
		});

		// Generamos los colores según la dificultad escojida, con colores unicos del
		// array
		int num = 0;
		while (numbers.size() < colores) {
			int randomNumber = (int) Math.round(Math.random() * 9);
			if (!numbers.contains(randomNumber)) {
				numbers.add(randomNumber);
				arrayDificultad[num] = arrCol[randomNumber];
				btnColoresDisponibles[num].setBackground(arrayDificultad[num]);
				btnColoresDisponibles[num].setVisible(true);
				num++;
			}
		}

		// Generaamos los colores escojidos por le ordenador como solucion, puede
		// contener dos valores iguales
		for (int i = 0; i < arraySolucion.length; i++) {
			int randomNumber = (int) Math.round(Math.random() * (arraySolucion.length - 1));
			Color colorSelec = arrayDificultad[randomNumber];
			arraySolucion[i] = colorSelec;

			// Asignamos los colores a los botones
			btnSelecionados[i].setBackground(arraySolucion[i]);
		}

	}
	
	public void labelDificultad(int intentos) {
		switch (intentos) {
		case 10:
			lblNewLabel_2.setForeground(new Color(0, 102, 0));
			lblNewLabel_2.setText("Principiante");
			break;
		case 8:
			lblNewLabel_2.setForeground(new Color(215, 133, 21));
			lblNewLabel_2.setText("Intermedio");
			break;
		case 6:
			lblNewLabel_2.setForeground(new Color(165, 42, 42));
			lblNewLabel_2.setText("Avanzado");
			break;

		default:
			lblNewLabel_2.setForeground(new Color(0, 102, 0));
			lblNewLabel_2.setText("Fácil");
			break;
		}
		
	};
	
	ActionListener cambiar = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JButton jb = (JButton) e.getSource();

			int con = 0;
			for (int i = 0; i < arrayDificultad.length - 1; i++) {
				if (jb.getBackground().equals(arrayDificultad[i])) {
					con = i + 1;
				}
			}
			jb.setBackground(arrayDificultad[(con)]);

		}
	};	

	public void comprobar(int intentos) {
		numIntentos++;
		if (intentos > numIntentos) {

			if (botones.get(botones.size() - 4).getBackground().equals(arraySolucion[0])
					&& botones.get(botones.size() - 3).getBackground().equals(arraySolucion[1])
					&& botones.get(botones.size() - 2).getBackground().equals(arraySolucion[2])
					&& botones.get(botones.size() - 1).getBackground().equals(arraySolucion[3])) {
				JLabel label = new JLabel("<html><h1>¡Felicidades, has ganado!</h1></html>");
				label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
				JOptionPane.showMessageDialog(contentPane1, label);
				disableButtons();
			} else {
				ArrayList<JButton> buttonAux = new ArrayList<>();
				for (int i = 1; i <= 4; i++) {
					buttonAux.add(botones.get(botones.size() - i));
				}
				System.out.println(buttonAux);
				int[] negras = new int[4]; // Array para almacenar los colores correctos y en su posición
				int[] blancas = new int[4]; // Array para almacenar los colores correctos en posición incorrecta
				int numNegras = 0; // Contador para el número de colores correctos y en su posición
				int numBlancas = 0; // Contador número de colores correctos pero en una posición incorrecta

				// Comprobando las negras
				for (int i = 0; i < 4; i++) {
					if (buttonAux.get(i).getBackground().equals(btnSelecionados[i].getBackground())) {
						negras[numNegras] = 1; // Añadimos un "1" al array de negras
						numNegras++; // Incrementamos el contador de negras
					}
					posicion1 = posicion1 - 1;
				}

				// Comprobando las blancas
				for (int i = 0; i < 4; i++) {
					// Si el color no está en su posición correcta
					if (!buttonAux.get(i).getBackground().equals(btnSelecionados[i].getBackground())) {
						for (int j = 0; j < 4; j++) { // Buscamos si está en otra posición
							if (buttonAux.get(i).getBackground().equals(btnSelecionados[j].getBackground())
									&& negras[j] != 1 && blancas[j] != 1) {
								blancas[numBlancas] = 1; // Añadimos un "1" al array de blancas
								numBlancas++; // Incrementamos el contador de blancas
								break; // Salimos del bucle interior para no contar dos veces un mismo color
							}
						}
					}
					posicion2 = posicion2 - 1;
				}
				for (int i = 0; i < negras.length; i++) {
					System.out.println("negras: " + negras[i]);
				}
				for (int i = 0; i < blancas.length; i++) {
					System.out.println("blancas: " + blancas[i]);
				}
				System.out.println(numBlancas + "" + numNegras);
				disableButtons();
				mostrarPosicionesCorrectas();
				altura = altura + 55;
				crear(botones, arrayDificultad);
			}
		} else {
			disableButtons();
			mostrarPosicionesCorrectas();
			JLabel label = new JLabel("<html><h1>¡Has perdido! Número de intentos superado</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane1, label);
		}
	}

	ActionListener mostrarSolucion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chckbxmntmMostrarSolucion.isSelected()) {
				panelSolucion.setVisible(true);
			} else {
				panelSolucion.setVisible(false);
			}
		}
	};

	// Muestra un mensaje dentro de una alerta al pulsar el botón
	ActionListener mostrarInformacion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JLabel label = new JLabel("<html><h1>MASTER MIND</h1>"
					+ "<p>Aplicaión desarrollada por el team 03 (Alejandro, Arnau y Paul)</p>"
					+ "<p>Más información en el repositorio de git</p>"
					+ "<p style=\"color:blue\">https://github.com/paul-23/c4-m4-team03-mastermind</p>" + "</html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			JOptionPane.showMessageDialog(contentPane1, label);
		}
	};

	ActionListener mostrarAyuda = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Mastermind_(board_game)"));

			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	};


	private void crear(ArrayList<JButton> botones, Color[] arrCol) {

		intentosLabel++;

		panel = new JPanel();
		panel.setBounds(30, altura, 281, 54);
		contentPane1.add(panel);
		panel.setLayout(null);

		lblNumeroIntento = new JLabel(" ");
		lblNumeroIntento.setText("" + intentosLabel);
		panel.validate();
		lblNumeroIntento.setFont(new Font("Arial", Font.PLAIN, 23));
		lblNumeroIntento.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumeroIntento.setBounds(10, 7, 40, 40);
		panel.add(lblNumeroIntento);

		btnNewButton = new JButton();
		panel.add(btnNewButton);
		btnNewButton.setBackground(Color.white);
		botones.add(btnNewButton);
		btnNewButton.addActionListener(cambiar);

		btnNewButton_1 = new JButton();
		btnNewButton_1.setBounds(116, 7, 40, 40);
		panel.add(btnNewButton_1);
		btnNewButton_1.setBackground(Color.white);
		botones.add(btnNewButton_1);
		btnNewButton_1.addActionListener(cambiar);

		btnNewButton_2 = new JButton();
		btnNewButton_2.setBounds(173, 7, 40, 40);
		panel.add(btnNewButton_2);
		btnNewButton_2.setBackground(Color.white);
		btnNewButton_2.addActionListener(cambiar);
		botones.add(btnNewButton_2);

		btnNewButton_3 = new JButton();
		btnNewButton_3.setBounds(230, 7, 40, 40);
		panel.add(btnNewButton_3);
		btnNewButton_3.setBackground(Color.white);
		botones.add(btnNewButton_3);
		btnNewButton_3.addActionListener(cambiar);

		btnNewButton.setBounds(new Rectangle(59, 7, 40, 40));

		super.update(this.getGraphics());

	}
	
	private void mostrarPosicionesCorrectas() {
		panel_1 = new JPanel();
		panel_1.setBounds(321, altura, 182, 54);
		contentPane1.add(panel_1);
		panel_1.setLayout(null);
		panel_1.setVisible(true);

		btnBN1 = new JButton();
		btnBN1.setEnabled(false);
		btnBN1.setBounds(12, 12, 30, 30);
		panel_1.add(btnBN1);
		btnBN1.setBackground(Color.WHITE);

		btnBN2 = new JButton();
		btnBN2.setEnabled(false);
		btnBN2.setBounds(54, 12, 30, 30);
		panel_1.add(btnBN2);
		btnBN2.setBackground(Color.WHITE);

		btnBN3 = new JButton();
		btnBN3.setEnabled(false);
		btnBN3.setBounds(96, 12, 30, 30);
		panel_1.add(btnBN3);
		btnBN3.setBackground(Color.WHITE);

		btnBN4 = new JButton();
		btnBN4.setEnabled(false);
		btnBN4.setBounds(138, 12, 30, 30);
		panel_1.add(btnBN4);
		btnBN4.setBackground(Color.WHITE);
	}

	private void disableButtons() {
		botones.get(botones.size() - 4).setEnabled(false);
		botones.get(botones.size() - 3).setEnabled(false);
		botones.get(botones.size() - 2).setEnabled(false);
		botones.get(botones.size() - 1).setEnabled(false);
	}
}
