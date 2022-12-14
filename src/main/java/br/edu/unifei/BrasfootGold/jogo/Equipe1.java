package br.edu.unifei.BrasfootGold.jogo;

import java.io.Serializable;
import javax.persistence.*;

import br.edu.unifei.BrasfootGold.base.Clube;
import lombok.Data;

public class Equipe1 extends Equipe<Equipe1>{
	public Equipe1(Clube clube) {
		super(clube);
	}

	public void jogar(Equipe eq) {
		this.chamarJogo(this, eq);
	}
}
