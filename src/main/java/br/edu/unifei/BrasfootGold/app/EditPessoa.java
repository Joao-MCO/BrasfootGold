package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.BrasfootGold.base.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JComboBox;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JTable;

public class EditPessoa extends JFrame {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("futebolPU");
	private EntityManager em = emf.createEntityManager();
	private Tecnico t;
	private Jogador j;
	private Boolean tecJog;	
	private ButtonGroup bg = new ButtonGroup();
	Pessoa pessoa = new Pessoa();
	
	private JPanel contentPane;
	private JTextField textFieldNome;
	public EditPessoa() {
		em.getTransaction().begin();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("EDITAR");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(99, 10, 90, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(10, 60, 44, 13);
		contentPane.add(lblNome);
		
		JLabel lblTipo = new JLabel("TIPO:");
		lblTipo.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTipo.setBounds(10, 103, 44, 13);
		contentPane.add(lblTipo);
		
		textFieldNome = new JTextField();
		textFieldNome.setBounds(64, 58, 177, 19);
		contentPane.add(textFieldNome);
		textFieldNome.setColumns(10);
		
		final JRadioButton rdbtnJogador = new JRadioButton("Jogador");
		rdbtnJogador.setBounds(66, 100, 78, 21);
		contentPane.add(rdbtnJogador);
		bg.add(rdbtnJogador);
		
		final JRadioButton rdbtnTecnico = new JRadioButton("Tecnico");
		rdbtnTecnico.setBounds(163, 100, 78, 21);
		contentPane.add(rdbtnTecnico);
		bg.add(rdbtnTecnico);
		
		
		final JComboBox comboBoxFormacao = new JComboBox();
		comboBoxFormacao.setEnabled(false);
		comboBoxFormacao.setBounds(86, 155, 155, 21);
		contentPane.add(comboBoxFormacao);
		List<Esquema> esquemas = em.createQuery("select e from Esquema e").getResultList();
		for(Esquema e : esquemas) {
			comboBoxFormacao.addItem(e.getNomeclatura());
		}
		
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTecnico.isSelected()) {
					comboBoxFormacao.setEnabled(true);
				}
			}
		});
		
		JLabel lblFormacao = new JLabel("FORMACAO:");
		lblFormacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacao.setBounds(10, 158, 78, 13);
		contentPane.add(lblFormacao);
		
		JLabel lblPosicao = new JLabel("POSICAO:");
		lblPosicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosicao.setBounds(10, 203, 78, 13);
		contentPane.add(lblPosicao);
		
		final JComboBox comboBoxPosicao = new JComboBox();
		comboBoxPosicao.setEnabled(false);
		comboBoxPosicao.setBounds(86, 200, 155, 21);
		contentPane.add(comboBoxPosicao);
		comboBoxPosicao.addItem(PosicaoEnum.GOLEIRO);
		comboBoxPosicao.addItem(PosicaoEnum.DEFENSOR);
		comboBoxPosicao.addItem(PosicaoEnum.MEIOCAMPISTA);
		comboBoxPosicao.addItem(PosicaoEnum.ATACANTE);
		
		JLabel lblHabilidade = new JLabel("HABILIDADE:");
		lblHabilidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHabilidade.setBounds(10, 258, 78, 13);
		contentPane.add(lblHabilidade);
		
		final JSpinner spinnerHabilidade = new JSpinner();
		spinnerHabilidade.setBounds(86, 256, 47, 15);
		spinnerHabilidade.setEnabled(false);
		contentPane.add(spinnerHabilidade);
		
		rdbtnTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTecnico.isSelected()) {
					comboBoxFormacao.setEnabled(true);
					comboBoxPosicao.setEnabled(false);
					spinnerHabilidade.setEnabled(false);
				}
			}
		});
		
		rdbtnJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnJogador.isSelected()) {
					comboBoxFormacao.setEnabled(false);
					comboBoxPosicao.setEnabled(true);
					spinnerHabilidade.setEnabled(true);
				}
			}
		});
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(10, 328, 123, 30);
		contentPane.add(btnCancelar);
		
		JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmar.setBounds(152, 328, 123, 30);
		contentPane.add(btnConfirmar);
		
		JLabel lblIdade = new JLabel("IDADE:");
		lblIdade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblIdade.setBounds(151, 258, 44, 13);
		contentPane.add(lblIdade);
		
		final JSpinner spinnerIdade = new JSpinner();
		spinnerIdade.setEnabled(false);
		spinnerIdade.setBounds(194, 256, 47, 15);
		contentPane.add(spinnerIdade);
		
		JButton btnPesquisa = new JButton("OK");
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pessoa.setNome(textFieldNome.getText());
				if(em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult().getClass() == Tecnico.class) {
					t = (Tecnico) em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult();
					rdbtnTecnico.setSelected(true);
					comboBoxFormacao.setSelectedItem(t.getEsquema().getNomeclatura());
					comboBoxFormacao.setEnabled(true);
					comboBoxPosicao.setEnabled(false);
					spinnerHabilidade.setValue(0);
					spinnerIdade.setValue(t.getIdade());
					spinnerIdade.setEnabled(true);
					rdbtnJogador.setSelected(false);
				}else {
					j = (Jogador) em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult();
					rdbtnJogador.setSelected(true);
					comboBoxPosicao.setSelectedItem(j.getPosicao());
					spinnerHabilidade.setValue(j.getHabilidade());
					spinnerIdade.setValue(j.getIdade());
					spinnerIdade.setEnabled(true);
					rdbtnTecnico.setSelected(false);
					comboBoxFormacao.setEnabled(false);
					comboBoxPosicao.setEnabled(true);
				}
			}
		});
		btnPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPesquisa.setBounds(255, 58, 20, 19);
		contentPane.add(btnPesquisa);
		
		
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTecnico.isSelected()) {
					Esquema esq = new Esquema((String) comboBoxFormacao.getSelectedItem());
					t.setEsquema(esq);
					t.setIdade((Integer) spinnerIdade.getValue());
					t.setNome(textFieldNome.getText());
					em.merge(t);
				}else {
					j.setHabilidade((Integer) spinnerHabilidade.getValue());
					j.setIdade((Integer) spinnerIdade.getValue());
					j.setNome(textFieldNome.getText());
					j.setPosicao((PosicaoEnum) comboBoxPosicao.getSelectedItem());
					em.merge(j);
				}
				em.getTransaction().commit();
				setVisible(false);
				em.close();
				emf.close();
			}
		});
	}
}
