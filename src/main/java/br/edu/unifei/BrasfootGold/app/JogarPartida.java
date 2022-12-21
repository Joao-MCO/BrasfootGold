package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.BrasfootGold.base.Clube;
import br.edu.unifei.BrasfootGold.base.Pessoa;
import br.edu.unifei.BrasfootGold.jogo.Equipe1;
import br.edu.unifei.BrasfootGold.jogo.Equipe2;
import br.edu.unifei.BrasfootGold.jogo.Partida;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.Color;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.SwingConstants;

public class JogarPartida extends JFrame {
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("futebolPU");
	private EntityManager em = emf.createEntityManager();

	private final int getEndereco(String nome, List<Clube> pessoasLivres) {
		int i = 0;
		for(Clube t : pessoasLivres) {
			if(t.getNome() == nome) {
				break;
			}
			i++;
		}
		return i;
	}
	
	private JPanel contentPane;
	public JogarPartida() {
		em.getTransaction().begin();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 560, 420);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 255, 102));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("NOVA PARTIDA");
		lblTitulo.setFont(new Font("Impact", Font.PLAIN, 32));
		lblTitulo.setBounds(190, 10, 188, 85);
		contentPane.add(lblTitulo);
		
		final List<Clube> clubes = em.createQuery("from Clube c").getResultList();
		
		final JComboBox comboBoxMandante = new JComboBox();
		comboBoxMandante.setBounds(38, 174, 153, 21);
		contentPane.add(comboBoxMandante);
		
		JLabel lblX = new JLabel("X");
		lblX.setFont(new Font("Gadugi", Font.PLAIN, 32));
		lblX.setBounds(252, 165, 24, 43);
		contentPane.add(lblX);
		
		final JComboBox comboBoxVisitante = new JComboBox();
		comboBoxVisitante.setBounds(322, 174, 153, 21);
		contentPane.add(comboBoxVisitante);
		
		for(Clube c : clubes) {
			if(c.getJogadores().size() > 0) {
				comboBoxMandante.addItem(c.getNome());
				comboBoxVisitante.addItem(c.getNome());
			}
		}
		
		JLabel lblMandante = new JLabel("MANDANTE");
		lblMandante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMandante.setHorizontalAlignment(SwingConstants.CENTER);
		lblMandante.setBounds(38, 151, 153, 13);
		contentPane.add(lblMandante);
		
		JLabel lblVisitante = new JLabel("VISITANTE");
		lblVisitante.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblVisitante.setHorizontalAlignment(SwingConstants.CENTER);
		lblVisitante.setBounds(322, 151, 153, 13);
		contentPane.add(lblVisitante);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(33, 300, 123, 30);
		contentPane.add(btnCancelar);
		
		final JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sm = comboBoxMandante.getSelectedItem().toString();
				String sv = comboBoxVisitante.getSelectedItem().toString();
				int im = getEndereco(sm, clubes);
				int iv = getEndereco(sv, clubes);
				Partida p = new Partida();
				Equipe1 mandante = new Equipe1(clubes.get(im));
				Equipe2 visitante = new Equipe2(clubes.get(iv));
				mandante.setPartida(p);
				visitante.setPartida(p);
				mandante.jogar(visitante);
				dispose();
			}
		});
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmar.setBounds(352, 300, 123, 30);
		contentPane.add(btnConfirmar);
		btnConfirmar.setEnabled(true);
	}
}
