package br.edu.unifei.BrasfootGold.jogo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

import br.edu.unifei.BrasfootGold.base.*;
import lombok.Data;

@Data
@Entity
public class Resultado implements Serializable{
	private static final long serialVersionUID = 8675143628909850128L;
	@Id @GeneratedValue private long id;
	@OneToOne private Clube mandante;
	@OneToOne private Clube visitante;
	private int golsMandante;
	private int golsVisitante;
	@OneToOne Juiz juiz;
}
