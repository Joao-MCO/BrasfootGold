package br.edu.unifei.BrasfootGold.base;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import lombok.Data;

@Entity
@Data
public class Clube implements Serializable{
	private static final long serialVersionUID = 8625540003830618496L;
	@Id @GeneratedValue private long id;
	private String nome;
	@OneToOne private Tecnico tecnico;
	@OneToMany private List<Jogador> jogadores = new ArrayList<Jogador>();
}
