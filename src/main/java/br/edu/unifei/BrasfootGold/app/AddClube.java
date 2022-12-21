package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

import br.edu.unifei.BrasfootGold.base.Clube;
import br.edu.unifei.BrasfootGold.base.Esquema;
import br.edu.unifei.BrasfootGold.base.Jogador;
import br.edu.unifei.BrasfootGold.base.Pessoa;
import br.edu.unifei.BrasfootGold.base.PosicaoEnum;
import br.edu.unifei.BrasfootGold.base.Tecnico;

import javax.swing.JLabel;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.JTextArea;
import javax.swing.JTable;

public class AddClube extends JFrame {
	private EntityManagerFactory emf =
			Persistence.createEntityManagerFactory("futebolPU");
	private EntityManager em = emf.createEntityManager();
	private JTextField textFieldClube;
	private JPanel contentPane;
	private JTextField textFieldEsquema;
	private int numJog = 0; 
	protected Clube novoClube = new Clube();
	
	private final int getEndereco(String nome, List<Pessoa> pessoasLivres) {
		int i = 0;
		for(Pessoa t : pessoasLivres) {
			if(t.getNome() == nome) {
				break;
			}
			i++;
		}
		return i;
	}
	public AddClube() {
		em.getTransaction().begin();
		JTextField textPosicaoJog;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTitulo = new JLabel("ADICIONAR");
		lblTitulo.setFont(new Font("Tahoma", Font.PLAIN, 24));
		lblTitulo.setBounds(316, 10, 133, 30);
		contentPane.add(lblTitulo);
		
		JLabel lblNome = new JLabel("NOME:");
		lblNome.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome.setBounds(33, 60, 44, 13);
		contentPane.add(lblNome);
		
		JLabel lblTecnico = new JLabel("TECNICO:");
		lblTecnico.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTecnico.setBounds(33, 191, 78, 13);
		contentPane.add(lblTecnico);
		
		textFieldClube = new JTextField();
		textFieldClube.setBounds(135, 58, 177, 19);
		contentPane.add(textFieldClube);
		textFieldClube.setColumns(10);
		
		JLabel lblFormacao = new JLabel("FORMACAO:");
		lblFormacao.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblFormacao.setBounds(33, 338, 78, 13);
		contentPane.add(lblFormacao);
		
		JButton btnCancelar = new JButton("CANCELAR");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnCancelar.setBounds(33, 423, 123, 30);
		contentPane.add(btnCancelar);
		
		final JButton btnConfirmar = new JButton("CONFIRMAR");
		btnConfirmar.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnConfirmar.setBounds(326, 423, 123, 30);
		contentPane.add(btnConfirmar);
		btnConfirmar.setEnabled(false);
		
		final JComboBox comboBoxTecnico = new JComboBox();
		comboBoxTecnico.setEditable(true);
		comboBoxTecnico.setBounds(135, 188, 177, 21);
		contentPane.add(comboBoxTecnico);
		final List<Pessoa> agentesLivres = em.createQuery("select p from Pessoa p where p.clube is null").getResultList();
		final ArrayList<Tecnico> tecnicosLivres = new ArrayList<Tecnico>();
		for(Pessoa t : agentesLivres) {
			if(t.getClass() == Tecnico.class) {
				tecnicosLivres.add((Tecnico) t);
				comboBoxTecnico.addItem(t.getNome());
			}
		}
		
		final ArrayList<Jogador> jogadoresLivres = new ArrayList<Jogador>();
		
		for(Pessoa j : agentesLivres) {
			if(j.getClass() == Jogador.class) {
				jogadoresLivres.add((Jogador) j);
			}
		}
		
		textFieldEsquema = new JTextField();
		textFieldEsquema.setEditable(false);
		textFieldEsquema.setColumns(10);
		textFieldEsquema.setBounds(135, 336, 177, 19);
		contentPane.add(textFieldEsquema);
		textFieldEsquema.setText(tecnicosLivres.get(getEndereco(comboBoxTecnico.getSelectedItem().toString(), agentesLivres)).getEsquema().getNomeclatura());
		
		final JButton btnAddJogador = new JButton("Adicionar");		
		btnAddJogador.setBounds(481, 378, 231, 21);
		contentPane.add(btnAddJogador);
		
		JSpinner spinnerHabilidadeJog = new JSpinner();
		spinnerHabilidadeJog.setEnabled(false);
		spinnerHabilidadeJog.setBounds(674, 60, 38, 20);
		contentPane.add(spinnerHabilidadeJog);
		
		JSpinner spinnerHabilidadeJog_1 = new JSpinner();
		spinnerHabilidadeJog_1.setEnabled(false);
		spinnerHabilidadeJog_1.setBounds(674, 89, 38, 20);
		contentPane.add(spinnerHabilidadeJog_1);
		
		JSpinner spinnerHabilidadeJog_2 = new JSpinner();
		spinnerHabilidadeJog_2.setEnabled(false);
		spinnerHabilidadeJog_2.setBounds(674, 118, 38, 20);
		contentPane.add(spinnerHabilidadeJog_2);
		
		JSpinner spinnerHabilidadeJog_3 = new JSpinner();
		spinnerHabilidadeJog_3.setEnabled(false);
		spinnerHabilidadeJog_3.setBounds(674, 147, 38, 20);
		contentPane.add(spinnerHabilidadeJog_3);
		
		JSpinner spinnerHabilidadeJog_4 = new JSpinner();
		spinnerHabilidadeJog_4.setEnabled(false);
		spinnerHabilidadeJog_4.setBounds(674, 176, 38, 20);
		contentPane.add(spinnerHabilidadeJog_4);
		
		JSpinner spinnerHabilidadeJog_5 = new JSpinner();
		spinnerHabilidadeJog_5.setEnabled(false);
		spinnerHabilidadeJog_5.setBounds(674, 205, 38, 20);
		contentPane.add(spinnerHabilidadeJog_5);
		
		JSpinner spinnerHabilidadeJog_6 = new JSpinner();
		spinnerHabilidadeJog_6.setEnabled(false);
		spinnerHabilidadeJog_6.setBounds(674, 234, 38, 20);
		contentPane.add(spinnerHabilidadeJog_6);
		
		JSpinner spinnerHabilidadeJog_7 = new JSpinner();
		spinnerHabilidadeJog_7.setEnabled(false);
		spinnerHabilidadeJog_7.setBounds(674, 263, 38, 20);
		contentPane.add(spinnerHabilidadeJog_7);
		
		JSpinner spinnerHabilidadeJog_8 = new JSpinner();
		spinnerHabilidadeJog_8.setEnabled(false);
		spinnerHabilidadeJog_8.setBounds(674, 292, 38, 20);
		contentPane.add(spinnerHabilidadeJog_8);
		
		JSpinner spinnerHabilidadeJog_9 = new JSpinner();
		spinnerHabilidadeJog_9.setEnabled(false);
		spinnerHabilidadeJog_9.setBounds(674, 321, 38, 20);
		contentPane.add(spinnerHabilidadeJog_9);
		
		JSpinner spinnerHabilidadeJog_10 = new JSpinner();
		spinnerHabilidadeJog_10.setEnabled(false);
		spinnerHabilidadeJog_10.setBounds(674, 348, 38, 20);
		contentPane.add(spinnerHabilidadeJog_10);
		
		final ArrayList<JSpinner> habilidades = new ArrayList<JSpinner>();
		habilidades.add(spinnerHabilidadeJog);
		habilidades.add(spinnerHabilidadeJog_1);
		habilidades.add(spinnerHabilidadeJog_2);
		habilidades.add(spinnerHabilidadeJog_3);
		habilidades.add(spinnerHabilidadeJog_4);
		habilidades.add(spinnerHabilidadeJog_5);
		habilidades.add(spinnerHabilidadeJog_6);
		habilidades.add(spinnerHabilidadeJog_7);
		habilidades.add(spinnerHabilidadeJog_8);
		habilidades.add(spinnerHabilidadeJog_9);
		habilidades.add(spinnerHabilidadeJog_10);
		
		textPosicaoJog = new JTextField();
		textPosicaoJog.setEditable(false);
		textPosicaoJog.setColumns(10);
		textPosicaoJog.setBounds(614, 60, 50, 19);
		contentPane.add(textPosicaoJog);
		
		
		JTextField textPosicaoJog_1 = new JTextField();
		textPosicaoJog_1.setEditable(false);
		textPosicaoJog_1.setColumns(10);
		textPosicaoJog_1.setBounds(614, 89, 50, 19);
		contentPane.add(textPosicaoJog_1);
		
		JTextField textPosicaoJog_2= new JTextField();
		textPosicaoJog_2.setEditable(false);
		textPosicaoJog_2.setColumns(10);
		textPosicaoJog_2.setBounds(614, 118, 50, 19);
		contentPane.add(textPosicaoJog_2);
		
		JTextField textPosicaoJog_3= new JTextField();
		textPosicaoJog_3.setEditable(false);
		textPosicaoJog_3.setColumns(10);
		textPosicaoJog_3.setBounds(614, 147, 50, 19);
		contentPane.add(textPosicaoJog_3);
		
		JTextField textPosicaoJog_4= new JTextField();
		textPosicaoJog_4.setEditable(false);
		textPosicaoJog_4.setColumns(10);
		textPosicaoJog_4.setBounds(614, 176, 50, 19);
		contentPane.add(textPosicaoJog_4);
		
		JTextField textPosicaoJog_5= new JTextField();
		textPosicaoJog_5.setEditable(false);
		textPosicaoJog_5.setColumns(10);
		textPosicaoJog_5.setBounds(614, 205, 50, 19);
		contentPane.add(textPosicaoJog_5);
		
		JTextField textPosicaoJog_6= new JTextField();
		textPosicaoJog_6.setEditable(false);
		textPosicaoJog_6.setColumns(10);
		textPosicaoJog_6.setBounds(614, 234, 50, 19);
		contentPane.add(textPosicaoJog_6);
		
		JTextField textPosicaoJog_7= new JTextField();
		textPosicaoJog_7.setEditable(false);
		textPosicaoJog_7.setColumns(10);
		textPosicaoJog_7.setBounds(614, 263, 50, 19);
		contentPane.add(textPosicaoJog_7);
		
		JTextField textPosicaoJog_8= new JTextField();
		textPosicaoJog_8.setEditable(false);
		textPosicaoJog_8.setColumns(10);
		textPosicaoJog_8.setBounds(614, 292, 50, 19);
		contentPane.add(textPosicaoJog_8);
		
		JTextField textPosicaoJog_9= new JTextField();
		textPosicaoJog_9.setEditable(false);
		textPosicaoJog_9.setColumns(10);
		textPosicaoJog_9.setBounds(614, 321, 50, 19);
		contentPane.add(textPosicaoJog_9);
		
		JTextField textPosicaoJog_10= new JTextField();
		textPosicaoJog_10.setEditable(false);
		textPosicaoJog_10.setColumns(10);
		textPosicaoJog_10.setBounds(614, 350, 50, 19);
		contentPane.add(textPosicaoJog_10);
		
		final ArrayList<JTextField> posicao = new ArrayList<JTextField>();
		posicao.add(textPosicaoJog);
		posicao.add(textPosicaoJog_1);
		posicao.add(textPosicaoJog_2);
		posicao.add(textPosicaoJog_3);
		posicao.add(textPosicaoJog_4);
		posicao.add(textPosicaoJog_5);
		posicao.add(textPosicaoJog_6);
		posicao.add(textPosicaoJog_7);
		posicao.add(textPosicaoJog_8);
		posicao.add(textPosicaoJog_9);
		posicao.add(textPosicaoJog_10);
		
		JLabel lblNome_2 = new JLabel("NOME");
		lblNome_2.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNome_2.setBounds(532, 37, 44, 13);
		contentPane.add(lblNome_2);
		
		JLabel lblPos = new JLabel("POS");
		lblPos.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPos.setBounds(626, 37, 32, 13);
		contentPane.add(lblPos);
		
		JLabel lblHabilidade = new JLabel("HAB");
		lblHabilidade.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblHabilidade.setBounds(680, 37, 32, 13);
		contentPane.add(lblHabilidade);
		
		final JLabel lblTotJog = new JLabel("TOTAL JOGADORES: 0");
		lblTotJog.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblTotJog.setBounds(481, 434, 231, 13);
		contentPane.add(lblTotJog);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setEditable(true);
		comboBox.setBounds(481, 59, 123, 21);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(481, 88, 123, 21);
		contentPane.add(comboBox_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setBounds(481, 117, 123, 21);
		contentPane.add(comboBox_2);
		
		JComboBox comboBox_3 = new JComboBox();
		comboBox_3.setBounds(481, 146, 123, 21);
		contentPane.add(comboBox_3);
		
		JComboBox comboBox_4 = new JComboBox();
		comboBox_4.setBounds(481, 175, 123, 21);
		contentPane.add(comboBox_4);
		
		JComboBox comboBox_5 = new JComboBox();
		comboBox_5.setBounds(481, 204, 123, 21);
		contentPane.add(comboBox_5);
		
		JComboBox comboBox_6 = new JComboBox();
		comboBox_6.setBounds(481, 233, 123, 21);
		contentPane.add(comboBox_6);
		
		JComboBox comboBox_7 = new JComboBox();
		comboBox_7.setBounds(481, 262, 123, 21);
		contentPane.add(comboBox_7);
		
		JComboBox comboBox_8 = new JComboBox();
		comboBox_8.setBounds(481, 291, 123, 21);
		contentPane.add(comboBox_8);
		
		JComboBox comboBox_9 = new JComboBox();
		comboBox_9.setBounds(481, 320, 123, 21);
		contentPane.add(comboBox_9);
		
		JComboBox comboBox_10 = new JComboBox();
		comboBox_10.setBounds(481, 347, 123, 21);
		contentPane.add(comboBox_10);
		
		final ArrayList<JComboBox> nomes = new ArrayList<JComboBox>();
		nomes.add(comboBox);
		nomes.add(comboBox_1);
		nomes.add(comboBox_2);
		nomes.add(comboBox_3);
		nomes.add(comboBox_4);
		nomes.add(comboBox_5);
		nomes.add(comboBox_6);
		nomes.add(comboBox_7);
		nomes.add(comboBox_8);
		nomes.add(comboBox_9);
		nomes.add(comboBox_10);
		for(int i=0;i<11;i++) {
			nomes.get(i).addItem("");
			for(Jogador j : jogadoresLivres) {
					nomes.get(i).addItem(j.getNome());
			}
			nomes.get(i).addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					int i = getEndereco(nomes.get(numJog).getSelectedItem().toString(), agentesLivres);
					habilidades.get(numJog).setValue(((Jogador) agentesLivres.get(i)).getHabilidade());
					posicao.get(numJog).setText(((Jogador) agentesLivres.get(i)).getPosicao().getSigla());
				}
			});
		}
		
		
		comboBoxTecnico.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int aux = tecnicosLivres.indexOf((Tecnico) agentesLivres.get(getEndereco(comboBoxTecnico.getSelectedItem().toString(), agentesLivres)));
				textFieldEsquema.setText(tecnicosLivres.get(aux).getEsquema().getNomeclatura());
			}
		});
		
		btnAddJogador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(nomes.get(numJog).getSelectedItem() != "") {
					int i = getEndereco((String) nomes.get(numJog).getSelectedItem(), agentesLivres);
					Jogador jogador = (Jogador) agentesLivres.get(i);
					novoClube.getJogadores().add(jogador);
					nomes.get(numJog).setEditable(false);
					if(numJog<10)	nomes.get(numJog+1).setEditable(true);
					i = jogadoresLivres.indexOf((Jogador) agentesLivres.get(i));
					int aux = numJog+1;
					while(aux<11) {
						nomes.get(aux).removeItem(jogadoresLivres.get(i).getNome());
						aux++;
					}
					jogadoresLivres.remove(i);
					numJog += 1;
					if(numJog == 11) {
						btnAddJogador.setEnabled(false);
						btnConfirmar.setEnabled(true);
					}
					lblTotJog.setText("TOTAL JOGADORES:" + numJog);
				}
			}
		});
		
		btnConfirmar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				novoClube.setNome(textFieldClube.getText());
				int aux = tecnicosLivres.indexOf((Tecnico) agentesLivres.get(getEndereco(comboBoxTecnico.getSelectedItem().toString(), agentesLivres)));
				novoClube.setTecnico(tecnicosLivres.get(aux));
				em.persist(novoClube);
				novoClube.getTecnico().setClube(novoClube);
				em.merge(novoClube.getTecnico());
				for(Jogador j : novoClube.getJogadores()) {
					j.setClube(novoClube);
					em.merge(j);					
				}
				setVisible(false);
				em.getTransaction().commit();
				em.close();
				emf.close();
			}
		});
	}
}
