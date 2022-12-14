package br.edu.unifei.BrasfootGold.jogo;

import java.io.Serializable;
import javax.persistence.*;

import br.edu.unifei.BrasfootGold.base.Clube;
import lombok.Data;

public class Equipe2 extends Equipe<Equipe2> implements Serializable{
	private long id;
	public Equipe2(Clube clube) {
		super(clube);
	}

	public void jogar(Equipe eq) {
		this.chamarJogo(this, eq);
	}
}
