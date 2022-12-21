package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.BrasfootGold.base.Clube;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ResultadoJogo extends JFrame {

	private JPanel contentPane;
	public ResultadoJogo(Clube mandante, Clube visitante, int golsMandante, int golsVisitante) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 667, 427);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("NOVA PARTIDA");
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 32));
		lblTitulo.setBounds(229, 10, 188, 85);
		contentPane.add(lblTitulo);
		
		JLabel lblMandante = new JLabel("MANDANTE");
		lblMandante.setHorizontalAlignment(SwingConstants.CENTER);
		lblMandante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMandante.setBounds(87, 141, 153, 13);
		lblMandante.setText(mandante.getNome());
		contentPane.add(lblMandante);
		
		JLabel lblVisitante = new JLabel("VISITANTE");
		lblVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVisitante.setBounds(371, 141, 153, 13);
		lblVisitante.setText(visitante.getNome());
		contentPane.add(lblVisitante);
		
		JLabel lblGolsMandante = new JLabel("0");
		lblGolsMandante.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsMandante.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblGolsMandante.setBounds(87, 185, 153, 123);
		lblGolsMandante.setText("" + golsMandante);
		contentPane.add(lblGolsMandante);
		
		JLabel lblGolsVisitante = new JLabel("0");
		lblGolsVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblGolsVisitante.setFont(new Font("Tahoma", Font.PLAIN, 99));
		lblGolsVisitante.setBounds(371, 185, 153, 123);
		lblGolsVisitante.setText("" + golsVisitante);
		contentPane.add(lblGolsVisitante);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Gadugi", Font.PLAIN, 32));
		lblX.setBounds(305, 227, 24, 43);
		contentPane.add(lblX);
		
		JLabel lblJuiz = new JLabel("Juiz");
		lblJuiz.setHorizontalAlignment(SwingConstants.CENTER);
		lblJuiz.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblJuiz.setBounds(229, 82, 188, 13);
		contentPane.add(lblJuiz);
		
		JButton btnNewButton = new JButton("OK");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBounds(263, 347, 99, 21);
		contentPane.add(btnNewButton);
	}
}
