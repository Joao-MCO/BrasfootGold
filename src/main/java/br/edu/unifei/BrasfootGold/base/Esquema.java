package br.edu.unifei.BrasfootGold.base;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity
public class Esquema implements Serializable{
	private static final long serialVersionUID = -2772658939804489264L;
	@Id private String nomeclatura;
	private int defensores;
	private int meioCampistas;
	private int atacantes;
	@Enumerated(EnumType.STRING) private MentalidadeEnum mentalidade;
	@OneToMany List<Tecnico> tecnicos = new ArrayList<Tecnico>();
	
	public Esquema() {
		this.nomeclatura = "4-4-2";
		this.defensores = 4;
		this.meioCampistas = 4;
		this.atacantes = 4;
		this.mentalidade = MentalidadeEnum.BALANCEADA;
	}
	
	public Esquema(String nomeclatura) {
		String[] aux = nomeclatura.split("-");
		int d = Integer.parseInt(aux[0]);
		int m = Integer.parseInt(aux[1]);
		int a = Integer.parseInt(aux[2]);
		this.mentalidade = MentalidadeEnum.BALANCEADA;
		if(d+m+a == 10) {
			this.defensores = d;
			this.meioCampistas = m;
			this.atacantes = a;
			this.nomeclatura = nomeclatura;
		}else {
			System.out.println("Numero irregular de jogadores");
		}
	}
	
	public void setNomeclatura(String nomeclatura) {
		String[] aux = nomeclatura.split("-");
		int d = Integer.parseInt(aux[0]);
		int m = Integer.parseInt(aux[1]);
		int a = Integer.parseInt(aux[2]);
		if(d+m+a == 10) {
			this.defensores = d;
			this.meioCampistas = m;
			this.atacantes = a;
			this.nomeclatura = nomeclatura;
		}else {
			System.out.println("Numero irregular de jogadores");
		}
	}
}
