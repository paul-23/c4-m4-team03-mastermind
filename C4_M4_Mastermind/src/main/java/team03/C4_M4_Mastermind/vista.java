package team03.C4_M4_Mastermind;

import java.awt.Color;

import java.awt.Desktop;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.TitledBorder;

import team03.C4_M4_Mastermind.models.Colores;

import javax.swing.border.EtchedBorder;
import javax.swing.JMenuBar;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JMenu;
import java.awt.Toolkit;
import java.awt.Rectangle;
import javax.swing.SwingConstants;

public class vista extends JFrame {

	// Variables globales (las usamos en todas las partes del proyecto)
	private static final long serialVersionUID = 1L;

	private JPanel panel, panel_1, contentPane1, panelColores, panelSolucion;
	private JButton btnColor, btnSolucion, btnNewButton, btnAciertosBN, comp;
	private JLabel lblNumeroIntento;
	private JCheckBoxMenuItem chckbxmntmMostrarSolucion;
	private JMenuItem mntmAyuda, mntmInformacion;
	private JButton[] btnSelecionados = new JButton[4];
	private Color[] arrayDificultad, arraySolucion;
	private Color[] arrCol;
	private final ArrayList<JButton> botones = new ArrayList<>();
	private int partidasJugadas, intentosVista, numColores, numIntentos = 0, altura = 119, intentosLabel = 0;
	private JButton btnNewGame;
	private JLabel lblNewLabel, lblNewLabel_1, lblNewLabel_2, lblNewLabel_3, lblNewLabel_4;
	private JButton[] btnColoresDisponibles;
	private Colores datosCompartidos;
	private CambioColores cm;

	public vista(int intentos, int colores, Colores dtCompartidos) {
		datosCompartidos = dtCompartidos;
		numColores = colores;
		partidasJugadas = datosCompartidos.getPartidas();
		intentosVista = intentos;
		arrCol = datosCompartidos.getArrCol();
		setResizable(false);
		arrayDificultad = new Color[colores];
		arraySolucion = new Color[4];
		setIconImage(Toolkit.getDefaultToolkit()
				.getImage(vista.class.getResource("/team03/C4_M4_Mastermind/assets/iconoG.png")));
		setTitle("MasterMind"); // Ponemos el título de la ventana de la aplicación
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 858, 772);
		contentPane1 = new JPanel();
		contentPane1.setBackground(new Color(215, 242, 255));
		contentPane1.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane1);
		contentPane1.setLayout(null);

		// ----------- PANEL BOTONES SOLUCION -----------

		panelSolucion = new JPanel();
		panelSolucion.setBackground(new Color(215, 242, 255));
		panelSolucion.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Combinaci\u00F3n secreta", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelSolucion.setBounds(559, 332, 252, 68);
		contentPane1.add(panelSolucion);
		panelSolucion.setLayout(null);
		panelSolucion.setVisible(false);

		// ----------- BOTONES SOLUCION -----------

		int distanciaBotonesSolucion = 10;
		for (int i = 0; i < 4; i++) {
			btnSolucion = new JButton("");
			btnSolucion.setBounds(distanciaBotonesSolucion, 23, 30, 30);
			panelSolucion.add(btnSolucion);
			btnSolucion.setEnabled(false);
			distanciaBotonesSolucion = distanciaBotonesSolucion + 40;
			btnSelecionados[i] = btnSolucion;
		}

		// ----------- BOTONES NUEVA PARTIDA -----------

		btnNewGame = new JButton("Nueva partida");
		btnNewGame.setForeground(new Color(0, 102, 153));
		btnNewGame.setFont(new Font("Tahoma", Font.BOLD, 23));
		btnNewGame.setBackground(new Color(255, 255, 255));
		btnNewGame.setBounds(559, 119, 252, 43);
		contentPane1.add(btnNewGame);
		btnNewGame.addActionListener(nuevaPartida);

		// ----------- LABELS -----------

		lblNewLabel = new JLabel("MASTERMIND");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Arial Black", Font.BOLD, 40));
		lblNewLabel.setForeground(new Color(0, 102, 153));
		lblNewLabel.setBounds(30, 42, 781, 60);
		contentPane1.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("Nivel actual");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_1.setBounds(559, 548, 252, 43);
		contentPane1.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_2.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_2.setBounds(559, 587, 252, 43);
		contentPane1.add(lblNewLabel_2);
		labelDificultad(intentos);

		lblNewLabel_3 = new JLabel("Intentos");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Arial", Font.PLAIN, 22));
		lblNewLabel_3.setBounds(735, 628, 76, 43);
		contentPane1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("" + intentos);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setFont(new Font("Arial", Font.BOLD, 22));
		lblNewLabel_4.setBounds(689, 628, 35, 43);
		contentPane1.add(lblNewLabel_4);

		// ----------- MENU BAR -----------

		JMenuBar menuBar = new JMenuBar();
		menuBar.setFont(new Font("Arial", Font.PLAIN, 19));
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setBounds(0, 0, 1026, 31);
		contentPane1.add(menuBar);

		JMenu mnOpciones = new JMenu("Archivo");
		mnOpciones.setFont(new Font("Arial", Font.PLAIN, 19));
		menuBar.add(mnOpciones);

		JMenuItem mntmNuevaPartida = new JMenuItem("Nueva partida");
		mntmNuevaPartida.setFont(new Font("Arial", Font.PLAIN, 19));
		mnOpciones.add(mntmNuevaPartida);
		mntmNuevaPartida.addActionListener(nuevaPartida);

		JMenuItem mntmNewMenuItem = new JMenuItem("Cambiar colores");
		mntmNewMenuItem.setFont(new Font("Arial", Font.PLAIN, 19));
		mnOpciones.add(mntmNewMenuItem);
		mntmNewMenuItem.addActionListener(cambiarColores);
		mntmNewMenuItem.setVisible(false);
		if (partidasJugadas >= 1) {
			mntmNewMenuItem.setVisible(true);
		}

		JMenuItem mntmSalir = new JMenuItem("Salir");
		mntmSalir.setFont(new Font("Arial", Font.PLAIN, 19));
		mnOpciones.add(mntmSalir);
		mntmSalir.addActionListener(salir);

		JMenu mnAbout = new JMenu("Ayuda");
		mnAbout.setFont(new Font("Arial", Font.PLAIN, 19));
		menuBar.add(mnAbout);

		chckbxmntmMostrarSolucion = new JCheckBoxMenuItem("Mostrar Solución");
		chckbxmntmMostrarSolucion.setFont(new Font("Arial", Font.PLAIN, 19));
		mnAbout.add(chckbxmntmMostrarSolucion);
		chckbxmntmMostrarSolucion.setSelected(false);
		chckbxmntmMostrarSolucion.addActionListener(mostrarSolucion);

		mntmAyuda = new JMenuItem("Instrucciones");
		mntmAyuda.setFont(new Font("Arial", Font.PLAIN, 19));
		mnAbout.add(mntmAyuda);

		mntmAyuda.addActionListener(mostrarAyuda);

		mntmInformacion = new JMenuItem("Información");
		mntmInformacion.setFont(new Font("Arial", Font.PLAIN, 19));
		mnAbout.add(mntmInformacion);
		mntmInformacion.addActionListener(mostrarInformacion);

		comp = new JButton("Comprobar");
		comp.setForeground(new Color(255, 255, 255));
		comp.setFont(new Font("Tahoma", Font.BOLD, 23));
		comp.setBackground(new Color(0, 102, 153));
		comp.setBounds(559, 173, 252, 43);
		contentPane1.add(comp);
		comp.setFocusPainted(false);

		setVisible(true);
		crear(botones, arrayDificultad);

		comp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				comprobar(intentosVista);
			}
		});

		escogerColores(arrayDificultad, colores);

	}

	public void ocultarVentana() {
		this.setVisible(false);
	}
	
	// ----------- CAMBIAR COLROES -----------
	
	ActionListener cambiarColores = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			abrirVentanaCambioColores();
		}
	};
	
	public void abrirVentanaCambioColores() {
		cm = new CambioColores(intentosVista, numColores, datosCompartidos, this);
		cm.setVisible(true);
	}

	// ----------- GENERAR COLORES POR DEFECTO O ESCOJIDOS -----------

	public void escogerColores(Color[] arrayDificultad, int colores) {

		// ----------- PANEL BOTONES COLORES DISPONIBELS -----------

		panelColores = new JPanel();
		panelColores.setBackground(new Color(215, 242, 255));
		panelColores.setLayout(null);
		panelColores.setBorder(new TitledBorder(
				new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)),
				"Colores disponibles", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panelColores.setBounds(559, 242, 252, 68);
		contentPane1.add(panelColores);

		ArrayList<Integer> numbers = new ArrayList<Integer>();
		arrCol = datosCompartidos.getArrCol();

		// ----------- BOTONES COLORES DISPONIBELS -----------

		btnColoresDisponibles = new JButton[colores];
		int distanciaBotonesColor = 10;
		for (int i = 0; i < colores; i++) {
			btnColor = new JButton("");
			btnColor.setBounds(distanciaBotonesColor, 23, 30, 30);
			panelColores.add(btnColor);
			btnColor.setVisible(false);
			btnColor.setEnabled(false);
			btnColoresDisponibles[i] = btnColor;
			distanciaBotonesColor = distanciaBotonesColor + 40;
		}

		// Generamos los colores únicos según la dificultad escojida

		if (datosCompartidos.getArrCol().length < colores) {
			CambioColores cm = new CambioColores(intentosVista, numColores, datosCompartidos, this);
			cm.setVisible(true);
			arrayDificultad = new Color[numColores];
			setVisible(false);
		} else {
			int num = 0;
			while (numbers.size() < colores) {
				int randomNumber = (int) Math.round(Math.random() * (datosCompartidos.getArrCol().length - 1));
				if (!numbers.contains(randomNumber)) {
					numbers.add(randomNumber);
					arrayDificultad[num] = arrCol[randomNumber];
					btnColoresDisponibles[num].setBackground(arrayDificultad[num]);
					btnColoresDisponibles[num].setVisible(true);
					num++;
				}
			}
		}
		generarCombinacionSecreta();
	}

	public void generarCombinacionSecreta() {
		// Generaamos los colores escojidos por le ordenador como solucion
		// (puede contener dos valores iguales)
		for (int i = 0; i < arraySolucion.length; i++) {
			int randomNumber = (int) Math.round(Math.random() * (arraySolucion.length - 1));
			Color colorSelec = arrayDificultad[randomNumber];
			arraySolucion[i] = colorSelec;

			// Asignamos los colores a los botones
			btnSelecionados[i].setBackground(arraySolucion[i]);
		}
	}

	// ----------- MOSTRAR LABEL SEGÚN NIVEL ESCOJIDO (color y texto) -----------

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

	// ------ Clic derecho avanzar, izquierdo retrocedes - seleccion de colores ---

	JButton jBtnSeleccionColores;
	Map<JButton, Integer> posicionesArrayColores = new HashMap<>();

	MouseAdapter cambiar = new MouseAdapter() {
		@Override
		public void mouseClicked(MouseEvent e) {
			jBtnSeleccionColores = (JButton) e.getSource();
			if (jBtnSeleccionColores.isEnabled()) {
				int index = posicionesArrayColores.getOrDefault(jBtnSeleccionColores, 0);
				if (e.getButton() == MouseEvent.BUTTON1) {
					jBtnSeleccionColores.setBackground(arrayDificultad[index]);
					index = (index + 1) % arrayDificultad.length;
					posicionesArrayColores.put(jBtnSeleccionColores, index);
				} else if (e.getButton() == MouseEvent.BUTTON3) {
					index = (index + arrayDificultad.length - 1) % arrayDificultad.length;
					jBtnSeleccionColores.setBackground(arrayDificultad[index]);
					posicionesArrayColores.put(jBtnSeleccionColores, index);
				}
			}
		}
	};

	// ----------- BOTÓN INICIAR NUEVA PARTIDA -----------

	ActionListener nuevaPartida = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			JLabel label = new JLabel("<html><h1>¿Iniciar nueva partida?</h1></html>");
			label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
			ImageIcon icon = new ImageIcon(getClass().getResource("/team03/C4_M4_Mastermind/assets/icono.png"));

			int input = JOptionPane.showConfirmDialog(contentPane1, label, "Nueva partida", JOptionPane.YES_NO_OPTION,
					JOptionPane.QUESTION_MESSAGE, icon);
			switch (input) {
			case 0:
				setVisible(false);
				datosCompartidos.setPartidas(datosCompartidos.getPartidas() + 1);
				new DificultdadUsuario(datosCompartidos);
				break;
			}
		}
	};

	// ----------- BOTÓN SALIR APLICACIÓN -----------

	ActionListener salir = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	// ----------- MÉTODO COMPROBAR COLORES -----------

	public void comprobar(int intentos) {
		// Comprobamos que el usuario haya seleccionado todos los colores
		if (!botones.get(botones.size() - 4).getBackground().equals(Color.WHITE)
				&& !botones.get(botones.size() - 3).getBackground().equals(Color.WHITE)
				&& !botones.get(botones.size() - 2).getBackground().equals(Color.WHITE)
				&& !botones.get(botones.size() - 1).getBackground().equals(Color.WHITE)) {
			// Si estan todos seleccionados comprobamos coincidencias
			numIntentos++;
			if (intentos > numIntentos) {
				// Comprobamos si todos coinciden con la combinación secreta
				if (botones.get(botones.size() - 4).getBackground().equals(arraySolucion[0])
						&& botones.get(botones.size() - 3).getBackground().equals(arraySolucion[1])
						&& botones.get(botones.size() - 2).getBackground().equals(arraySolucion[2])
						&& botones.get(botones.size() - 1).getBackground().equals(arraySolucion[3])) {
					// En caso afirmativo mosrtar mensaje de felicitaciones

					ImageIcon iconWin = new ImageIcon(
							new ImageIcon(getClass().getResource("/team03/C4_M4_Mastermind/assets/victoria.png"))
									.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT));
					JLabel label = new JLabel("<html><h1>¡Felicidades, has ganado!</h1></html>"); // Imagen de victoria
					label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
					JOptionPane.showMessageDialog(contentPane1, label, "¡Victoria!", JOptionPane.INFORMATION_MESSAGE,
							iconWin);
					disableButtons();
				} else {
					// Si no coinciden todos comprobamos los que si y contamos blanco o negro
					// Negro: Color y posicion correcta
					// Blanco: Color correcto, posición incorrecta

					JButton[] buttonAux1 = new JButton[4];
					int arrayPos = 4;
					for (int i = 0; i < 4; i++) {
						buttonAux1[i] = botones.get(botones.size() - arrayPos);
						arrayPos = arrayPos - 1;
					}
					int negros = 0;
					int blancos = 0;
					boolean[] encontradosSecretos = new boolean[buttonAux1.length];
					boolean[] encontradosCombinacion = new boolean[buttonAux1.length];

					for (int i = 0; i < buttonAux1.length; i++) {
						if (btnSelecionados[i].getBackground().equals(buttonAux1[i].getBackground())) {
							negros++;
							encontradosSecretos[i] = true;
							encontradosCombinacion[i] = true;
						}
					}

					for (int i = 0; i < btnSelecionados.length; i++) {
						if (!encontradosCombinacion[i]) {
							for (int j = 0; j < btnSelecionados.length; j++) {
								if (!encontradosSecretos[j]
										&& buttonAux1[i].getBackground().equals(btnSelecionados[j].getBackground())) {
									blancos++;
									encontradosSecretos[j] = true;
									encontradosCombinacion[i] = true;
									break;
								}
							}
						}
					}

					disableButtons();
					mostrarPosicionesCorrectas(negros, blancos);
					altura = altura + 55;
					crear(botones, arrayDificultad);
				}
			} else {
				// Si superamos los intentos hemos perdido y mostramos un mensaje
				disableButtons();
				ImageIcon iconPerdido = new ImageIcon(
						new ImageIcon(getClass().getResource("/team03/C4_M4_Mastermind/assets/perdido.png")).getImage()
								.getScaledInstance(100, 100, Image.SCALE_DEFAULT)); // Imagen de partida perdida
				JLabel label = new JLabel("<html><h1>¡Has perdido! Número de intentos superado</h1></html>");
				label.setFont(new Font("Arial", Font.BOLD, 20)); // Cambiamos la fuente y tamaño del texto
				JOptionPane.showMessageDialog(contentPane1, label, "¡Has perdido!", JOptionPane.INFORMATION_MESSAGE,
						iconPerdido);
			}
		}
	}

	// ----------- VER SOLUCIÓN EN PANTALLA CHECKBOX MENUBAR -----------

	ActionListener mostrarSolucion = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			if (chckbxmntmMostrarSolucion.isSelected()) {
				panelSolucion.setVisible(true);
			} else {
				panelSolucion.setVisible(false);
			}
		}
	};

	// ----------- MENSAJE INFORMACIÓN MENUBAR -----------

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

	// ----------- BOTÓN AYUDA MANUBAR -----------

	// Abir página web de wikipedia con información de Mastermind
	ActionListener mostrarAyuda = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			try {
				Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Mastermind_(board_game)"));

			} catch (IOException | URISyntaxException e1) {
				e1.printStackTrace();
			}
		}
	};

	// ----------- MÉTODO CREAR LOS BOTONES ESCOGER COLOR -----------

	private void crear(ArrayList<JButton> botones, Color[] arrCol) {

		intentosLabel++;

		panel = new JPanel();
		panel.setBackground(new Color(215, 242, 255));
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

		int margen = 59;
		for (int i = 0; i < 4; i++) {
			btnNewButton = new JButton();
			panel.add(btnNewButton);
			btnNewButton.setBackground(Color.white);
			botones.add(btnNewButton);
			btnNewButton.addMouseListener(cambiar);
			btnNewButton.setBounds(new Rectangle(margen, 7, 40, 40));
			margen = margen + 57;
		}

		super.update(this.getGraphics());

	}

	// ----------- POSICION CORRECTA COMPROBACIÓN (BLANCOS / NEGROS) -----------

	// Mostrar por pantalla puntos blancos y negros según aciertos
	private void mostrarPosicionesCorrectas(int negros, int blancos) {
		int horizontal = 12;
		panel_1 = new JPanel();
		panel_1.setBounds(321, altura, 182, 54);
		contentPane1.add(panel_1);
		panel_1.setBackground(new Color(215, 242, 255));
		panel_1.setLayout(null);
		panel_1.setVisible(true);

		for (int i = 0; i < negros; i++) {
			btnAciertosBN = new JButton();
			btnAciertosBN.setEnabled(false);
			btnAciertosBN.setBounds(horizontal, 12, 30, 30);
			panel_1.add(btnAciertosBN);
			btnAciertosBN.setBackground(Color.black);
			horizontal = horizontal + 42;
		}

		for (int i = 0; i < blancos; i++) {
			btnAciertosBN = new JButton();
			btnAciertosBN.setEnabled(false);
			btnAciertosBN.setBounds(horizontal, 12, 30, 30);
			panel_1.add(btnAciertosBN);
			btnAciertosBN.setBackground(Color.white);
			horizontal = horizontal + 42;
		}
	}

	// ----------- DESACTIVAR BOTONES -----------

	// Método para desactivar los botones que ya no podemos pulsar
	private void disableButtons() {
		botones.get(botones.size() - 4).setEnabled(false);
		botones.get(botones.size() - 3).setEnabled(false);
		botones.get(botones.size() - 2).setEnabled(false);
		botones.get(botones.size() - 1).setEnabled(false);
	}
}
