package team03.C4_M4_Mastermind;

import java.awt.Color;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class vista extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public vista(int intentos, int colores) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 564, 323);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JButton btn1 = new JButton("");
		btn1.setBounds(27, 25, 89, 23);
		contentPane.add(btn1);

		JButton btn2 = new JButton("");
		btn2.setBounds(126, 25, 89, 23);
		contentPane.add(btn2);

		JButton btn3 = new JButton("");
		btn3.setBounds(225, 25, 89, 23);
		contentPane.add(btn3);

		JButton btn4 = new JButton("");
		btn4.setBounds(335, 25, 89, 23);
		contentPane.add(btn4);
		
		setVisible(true);

		Color array[] = new Color[colores];
		Color[] arrCol = { Color.RED, Color.pink, Color.yellow, Color.green, Color.black, Color.gray,
				Color.blue, Color.orange, Color.magenta, Color.cyan };
		JButton[] btnSelecionados = { btn1, btn2, btn3, btn4 };

		for (int i = 0; i < colores; i++) {
			int randomNumber = (int) Math.round(Math.random() * 9);
			Color colorselecc = arrCol[randomNumber];
			array[i] = colorselecc;
		}
		
		for (int i = 0; i < btnSelecionados.length; i++) {
			btnSelecionados[i].setBackground(array[i]);
		}
	}
}
