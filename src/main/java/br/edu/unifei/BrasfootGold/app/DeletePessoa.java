package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.edu.unifei.BrasfootGold.base.*;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class DeletePessoa extends JFrame {
	private EntityManagerFactory emf = Persistence.createEntityManagerFactory("futebolPU");
	private EntityManager em = emf.createEntityManager();
	private Tecnico t;
	private Jogador j;
	private ButtonGroup bg = new ButtonGroup();

	private JPanel contentPane;
	private JTextField textFieldNome;
	private JTextField textFormacao;
	private JTextField textPosicao;
	public DeletePessoa(){
		em.getTransaction().begin();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 312, 415);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("DELETAR");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(87, 10, 108, 30);
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
		rdbtnJogador.setEnabled(false);
		
		final JRadioButton rdbtnTecnico = new JRadioButton("Tecnico");
		rdbtnTecnico.setBounds(163, 100, 78, 21);
		contentPane.add(rdbtnTecnico);
		bg.add(rdbtnTecnico);
		rdbtnTecnico.setEnabled(false);
		
		JLabel lblFormacao = new JLabel("FORMACAO:");
		lblFormacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacao.setBounds(10, 158, 78, 13);
		contentPane.add(lblFormacao);
		
		JLabel lblPosicao = new JLabel("POSICAO:");
		lblPosicao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPosicao.setBounds(10, 203, 78, 13);
		contentPane.add(lblPosicao);
		
		JLabel lblHabilidade = new JLabel("HABILIDADE:");
		lblHabilidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHabilidade.setBounds(10, 258, 78, 13);
		contentPane.add(lblHabilidade);
		
		final JSpinner spinnerHabilidade = new JSpinner();
		spinnerHabilidade.setBounds(86, 256, 47, 15);
		spinnerHabilidade.setEnabled(false);
		contentPane.add(spinnerHabilidade);
		
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
		btnPesquisa.setFont(new Font("Tahoma", Font.PLAIN, 10));
		btnPesquisa.setBounds(255, 58, 20, 19);
		contentPane.add(btnPesquisa);
		
		textFormacao = new JTextField();
		textFormacao.setEnabled(false);
		textFormacao.setEditable(false);
		textFormacao.setColumns(10);
		textFormacao.setBounds(87, 156, 154, 19);
		contentPane.add(textFormacao);
		
		textPosicao = new JTextField();
		textPosicao.setEditable(false);
		textPosicao.setEnabled(false);
		textPosicao.setColumns(10);
		textPosicao.setBounds(87, 201, 154, 19);
		contentPane.add(textPosicao);
		
		btnPesquisa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pessoa pessoa = new Pessoa();
				pessoa.setNome(textFieldNome.getText());
				if(em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult().getClass() == Tecnico.class) {
					t = (Tecnico) em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult();
					rdbtnTecnico.setSelected(true);
					textFormacao.setText(t.getEsquema().getNomeclatura());
					textPosicao.setText(null);
					spinnerHabilidade.setValue(0);
					spinnerIdade.setValue(t.getIdade());
					rdbtnJogador.setSelected(false);
				}else {
					j = (Jogador) em.createQuery("select p from Pessoa p where p.nome = '" + pessoa.getNome() + "'").getSingleResult();
					rdbtnJogador.setSelected(true);
					textPosicao.setText(j.getPosicao().getSigla());
					spinnerHabilidade.setValue(j.getHabilidade());
					spinnerIdade.setValue(j.getIdade());
					rdbtnTecnico.setSelected(false);
					textFormacao.setText(null);
				}
				
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(rdbtnTecnico.isSelected()) {
					em.remove(t);
				}else {
					em.remove(j);
				}
				em.getTransaction().commit();
				setVisible(false);
				em.close();
				emf.close();
			}
		});
	}
}
