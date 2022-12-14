package br.edu.unifei.BrasfootGold.app;

import java.awt.EventQueue;
import br.edu.unifei.BrasfootGold.base.*;
import br.edu.unifei.BrasfootGold.jogo.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.FlowLayout;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JInternalFrame;

public class MainMenu extends JFrame {
	private static ArrayList<Clube> clubes = new ArrayList<Clube>();
	private static ArrayList<Tecnico> tecnicos = new ArrayList<Tecnico>();
	private static ArrayList<Jogador> jogadoresGalo = new ArrayList<Jogador>();
	private static ArrayList<Jogador> jogadoresFlamengo = new ArrayList<Jogador>();
	private static ArrayList<Jogador> jogadoresPalmeiras = new ArrayList<Jogador>();
	private static ArrayList<Jogador> todos = new ArrayList<Jogador>();
	private static ArrayList<Juiz> juizes = new ArrayList<Juiz>();
	private static ArrayList<Esquema> esquemas = new ArrayList<Esquema>();
	private static  Clube c = new Clube();
	private static Tecnico t = new Tecnico();
	private static Jogador j = new Jogador();
	private static Juiz ju = new Juiz();
	private static Random r = new Random();
	private JPanel contentPane;
	
	
	private static void gerencia(Clube c, Tecnico t) {
		c.setTecnico(t);
		t.setClube(c);
		clubes.add(c);
		tecnicos.add(t);
	}
	private static void inicializa() {		
		//Adicao de Esquema
		esquemas.clear();
		esquemas.add(new Esquema("4-4-2"));
		esquemas.add(new Esquema("4-3-3"));
		esquemas.add(new Esquema("4-5-1"));
		esquemas.add(new Esquema("5-3-2"));
		esquemas.add(new Esquema("5-4-1"));
		esquemas.add(new Esquema("5-2-3"));
		esquemas.add(new Esquema("3-5-2"));
		esquemas.add(new Esquema("3-6-1"));
		esquemas.add(new Esquema("3-4-3"));
		
		//Adi????o dos 20 times e 20 t??cnicos da S??rie A
		t.setEsquema(esquemas.get(0));
		t.setNome("Wagner Mancini");
		c.setNome("Am??rica-MG");
		gerencia(c, t);
		
		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Felip??o");
		c.setNome("Athletico");
		gerencia(c, t);
		
		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Eduardo Coudet");
		c.setNome("Atl??tico-MG");
		gerencia(c, t);
		
		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Renato Paiva");
		c.setNome("Bahia");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Luis Castro");
		c.setNome("Botafogo");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Fernando L??zaro");
		c.setNome("Corinthians");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Ant??nio Oliveira");
		c.setNome("Coritiba");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Paulo Pezzolano");
		c.setNome("Cruzeiro");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Ivo Vieira");
		c.setNome("Cuiab??");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Vitor Pereira");
		c.setNome("Flamengo");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Fernando Diniz");
		c.setNome("Fluminense");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Vojvoda");
		c.setNome("Fortaleza");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Jair Ventura");
		c.setNome("Goi??s");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Renato Ga??cho");
		c.setNome("Gr??mio");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Mano Menezes");
		c.setNome("Internacional");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Pedro Caixinha");
		c.setNome("Red Bull Bragantino");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Abel Ferreira");
		c.setNome("Palmeiras");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Rog??rio Ceni");
		c.setNome("S??o Paulo");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Odair Hellmann");
		c.setNome("Santos");
		gerencia(c, t);

		c = new Clube();
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Maur??cio Barbieri");
		c.setNome("Vasco da Gama");
		gerencia(c, t);
		
		//Adi????o dos T??cnicos sem clube
		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Tite");
		t.setClube(null);
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Cuca");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Celso Roth");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Vanderlei Luxemburgo");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Alberto Valentim");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("F??bio Carille");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Ney Franco");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Dorival Jr");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Lisca Doido");
		tecnicos.add(t);

		t = new Tecnico();
		t.setEsquema(esquemas.get(0));
		t.setNome("Givanildo de Oliveira");
		tecnicos.add(t);
		
		//Adi????o dos Jogadores mais importantes
		//Galo
		j.setClube(clubes.get(2));
		j.setNome("Everson");
		j.setPosicao(PosicaoEnum.GOLEIRO);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Mariano");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(45)+55);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Jemerson");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(35)+65);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Bruno Fuchs");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Guilherme Arana");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Allan");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Jair");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Zaracho");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Eduardo Vargas");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Hulk");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(15)+85);
		jogadoresGalo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(2));
		j.setNome("Paulinho");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresGalo.add(j);
		todos.add(j);
		
		clubes.get(2).setJogadores(jogadoresGalo);
		clubes.get(2).getTecnico().setEsquema(esquemas.get(1));
		clubes.get(2).getTecnico().getEsquema().setMentalidade(MentalidadeEnum.OFENSIVA);
		
		//Flamengo
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Santos");
		j.setPosicao(PosicaoEnum.GOLEIRO);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresFlamengo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Mateusinho");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(35)+65);
		jogadoresFlamengo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("David Luiz");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresFlamengo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Leo Pereira");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresFlamengo.add(j);
		todos.add(j);

		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Filipe Luis");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Jo??o Gomes");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Thiago Maia");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Everton Ribeiro");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Giorgian De Arrascaeta");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(15)+85);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Gabigol");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(15)+85);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(9));
		j.setNome("Bruno Henrique");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresFlamengo.add(j);
		todos.add(j);
		
		clubes.get(9).setJogadores(jogadoresFlamengo);
		clubes.get(9).getTecnico().getEsquema().setMentalidade(MentalidadeEnum.OFENSIVA);
		
		//Palmeiras
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Weverton");
		j.setPosicao(PosicaoEnum.GOLEIRO);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Marcos Rocha");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Gustavo Gomez");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Murilo");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Piquerez");
		j.setPosicao(PosicaoEnum.DEFENSOR);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Danilo");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Z?? Rafael");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Bruno Tabata");
		j.setPosicao(PosicaoEnum.MEIOCAMPISTA);
		j.setHabilidade(r.nextInt(30)+70);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Dudu");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(20)+80);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Rony");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		j = new Jogador();
		j.setClube(clubes.get(16));
		j.setNome("Endrick");
		j.setPosicao(PosicaoEnum.ATACANTE);
		j.setHabilidade(r.nextInt(25)+75);
		jogadoresPalmeiras.add(j);
		todos.add(j);
		
		clubes.get(16).setJogadores(jogadoresPalmeiras);
		clubes.get(16).getTecnico().setEsquema(esquemas.get(1));
		
		//Adi????o dos ??rbitros
		ju.setNome("Wilton Pereira Sampaio");
		juizes.add(ju);
		
		ju = new Juiz();
		ju.setNome("S??vio Pereira Sampaio");
		juizes.add(ju);
		
		ju = new Juiz();
		ju.setNome("Raphael Claus");
		juizes.add(ju);
		
		ju = new Juiz();
		ju.setNome("Anderson Daronco");
		juizes.add(ju);
		
		ju = new Juiz();
		ju.setNome("Rafael Toschi Marques");
		juizes.add(ju);
		
		ju = new Juiz();
		ju.setNome("Leandro Pedro Vuaden");
		juizes.add(ju);
	}
	private static void adicionaBanco() {
		EntityManagerFactory emf= Persistence.createEntityManagerFactory("futebolPU");
		EntityManager em=emf.createEntityManager();
		em.getTransaction().begin();
		for(Clube cl : clubes) {
			System.out.println(cl.getNome());
			em.persist(cl);
		}
		for(Esquema esq : esquemas) {
			System.out.println(esq.getNomeclatura());
			em.persist(esq);
		}
		for(Tecnico te : tecnicos) {
			System.out.println(te.getNome());
			em.persist(te);
		}
		for(Juiz juiz : juizes) {
			System.out.println(juiz.getNome());
			em.persist(juiz);
		}
		for(Jogador jo : todos) {
			System.out.println(jo.getNome());
			em.persist(jo);
		}
		em.getTransaction().commit();
		em.close();
		emf.close();
	}
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					//inicializa();
					//adicionaBanco();
					MainMenu frame = new MainMenu();
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
	public MainMenu() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(204, 204, 204));
		contentPane.setBackground(new Color(204, 204, 204));
		contentPane.setBorder(new LineBorder(new Color(204, 204, 204), 10));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTituloB = new JLabel("GOLD");
		lblTituloB.setForeground(new Color(255, 204, 0));
		lblTituloB.setBackground(new Color(255, 204, 0));
		lblTituloB.setBounds(388, 42, 254, 91);
		lblTituloB.setFont(new Font("Source Sans Pro Black", Font.BOLD | Font.ITALIC, 99));
		contentPane.add(lblTituloB);
		
		JLabel lblAdicionar = new JLabel("ADICIONAR");
		lblAdicionar.setForeground(new Color(0, 102, 51));
		lblAdicionar.setHorizontalAlignment(SwingConstants.CENTER);
		lblAdicionar.setFont(new Font("Source Serif Pro", Font.BOLD, 18));
		lblAdicionar.setBounds(73, 237, 112, 29);
		contentPane.add(lblAdicionar);
		
		JButton btnAddClube = new JButton("Clube");
		btnAddClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddClube subAddClube = new AddClube();
				subAddClube.setVisible(true);
			}
		});
		btnAddClube.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddClube.setBounds(73, 286, 112, 21);
		contentPane.add(btnAddClube);
		
		
		JButton btnAddPessoa = new JButton("Pessoa");
		btnAddPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnAddPessoa.setBounds(73, 348, 112, 21);
		contentPane.add(btnAddPessoa);
		
		btnAddPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPessoa subFrameAdd = new AddPessoa();
				subFrameAdd.setVisible(true);
			}
		});
		
		JLabel lblEditar = new JLabel("EDITAR");
		lblEditar.setHorizontalAlignment(SwingConstants.CENTER);
		lblEditar.setForeground(new Color(255, 255, 0));
		lblEditar.setFont(new Font("Source Serif Pro", Font.BOLD, 18));
		lblEditar.setBounds(312, 237, 112, 29);
		contentPane.add(lblEditar);
		
		JButton btnEdtClube = new JButton("Clube");
		btnEdtClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Tela n??o desenvolvida ainda! :(", "Warning",
				        JOptionPane.WARNING_MESSAGE);
			}
		});
		btnEdtClube.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdtClube.setBounds(312, 286, 112, 21);
		contentPane.add(btnEdtClube);
		
		JButton btnEdtPessoa = new JButton("Pessoa");
		btnEdtPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnEdtPessoa.setBounds(312, 348, 112, 21);
		contentPane.add(btnEdtPessoa);
		
		btnEdtPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EditPessoa subFrameEdt = new EditPessoa();
				subFrameEdt.setVisible(true);
			}
		});
		
		JLabel lblRemover = new JLabel("REMOVER");
		lblRemover.setHorizontalAlignment(SwingConstants.CENTER);
		lblRemover.setForeground(new Color(255, 0, 0));
		lblRemover.setFont(new Font("Source Serif Pro", Font.BOLD, 18));
		lblRemover.setBounds(546, 237, 112, 29);
		contentPane.add(lblRemover);
		
		JButton btnRmvClube = new JButton("Clube");
		btnRmvClube.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(new JFrame(), "Tela n??o desenvolvida ainda! :(", "Warning",
				        JOptionPane.WARNING_MESSAGE);
			}
		});
		btnRmvClube.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRmvClube.setBounds(546, 286, 112, 21);
		contentPane.add(btnRmvClube);
		
		JButton btnRmvPessoa = new JButton("Pessoa");
		btnRmvPessoa.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeletePessoa subFrameDlt = new DeletePessoa();
				subFrameDlt.setVisible(true);
			}
		});
		btnRmvPessoa.setFont(new Font("Tahoma", Font.PLAIN, 12));
		btnRmvPessoa.setBounds(546, 348, 112, 21);
		contentPane.add(btnRmvPessoa);
		
		
		JLabel lblNewLabel = new JLabel("BRASFOOT");
		lblNewLabel.setFont(new Font("Yu Gothic", Font.BOLD, 52));
		lblNewLabel.setForeground(new Color(0, 102, 51));
		lblNewLabel.setBounds(95, 74, 299, 91);
		contentPane.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(204, 204, 51));
		panel.setBounds(31, 210, 194, 197);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(204, 204, 51));
		panel_1.setBounds(268, 210, 194, 197);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(204, 204, 51));
		panel_2.setBounds(505, 210, 194, 197);
		contentPane.add(panel_2);
		
		JButton btnSair = new JButton("Sair");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnSair.setBackground(new Color(255, 204, 204));
		btnSair.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnSair.setBounds(31, 504, 194, 36);
		contentPane.add(btnSair);
		
		JButton btnVerPartida = new JButton("??ltimas Partida");
		btnVerPartida.setForeground(new Color(0, 0, 0));
		btnVerPartida.setBackground(new Color(255, 255, 153));
		btnVerPartida.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnVerPartida.setBounds(268, 504, 194, 36);
		contentPane.add(btnVerPartida);
		
		JButton btnJogar = new JButton("Jogar Partida");
		btnJogar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JogarPartida subFramePartida = new JogarPartida();
				subFramePartida.setVisible(true);
			}
		});
		btnJogar.setForeground(new Color(0, 0, 0));
		btnJogar.setBackground(new Color(153, 255, 153));
		btnJogar.setFont(new Font("Tahoma", Font.PLAIN, 21));
		btnJogar.setBounds(505, 504, 194, 36);
		contentPane.add(btnJogar);
		
	}
}
