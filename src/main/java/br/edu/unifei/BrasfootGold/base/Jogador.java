package br.edu.unifei.BrasfootGold.base;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Jogador extends Pessoa implements Serializable{
	private static final long serialVersionUID = -1657769188301656509L;
	@Id @GeneratedValue private long id;
	private int habilidade;
	@Enumerated(EnumType.STRING) private PosicaoEnum posicao;
	@ManyToOne private Clube clube;
	public Jogador() {}
	public Jogador(Pessoa p) {
		setNome(p.getNome());
		setIdade(p.getIdade());
	}
}
