package br.edu.unifei.BrasfootGold.base;

import java.io.Serializable;
import javax.persistence.*;

import br.edu.unifei.BrasfootGold.jogo.*;
import lombok.Data;

@Data
@Entity
public class Juiz extends Pessoa implements Serializable{
	private static final long serialVersionUID = 3187654833861622878L;
	@Id @GeneratedValue private long id;
	private Boolean fifa;
	@OneToOne private Resultado partida;
}
