package br.edu.unifei.BrasfootGold.base;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@EqualsAndHashCode(callSuper = false)
public class Tecnico extends Pessoa implements Serializable{
	private static final long serialVersionUID = 1L;
	@Id @GeneratedValue private long id;
	@OneToOne private Clube clube;
	@ManyToOne private Esquema esquema;
	public Tecnico() {}
	public Tecnico(Pessoa p) {
		setNome(p.getNome());
		setIdade(p.getIdade());
	}
}
