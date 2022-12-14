package br.edu.unifei.BrasfootGold.jogo;

import java.io.IOException;
import java.util.Random;
import java.io.Serializable;
import javax.persistence.*;

import br.edu.unifei.BrasfootGold.base.Jogador;
import br.edu.unifei.BrasfootGold.base.Juiz;
import br.edu.unifei.BrasfootGold.base.PosicaoEnum;
import lombok.Data;

public class Partida extends PartidaAbstrata{
	private Equipe1 mandante;
	private Equipe2 visitante;
	private Juiz juiz;
	
	@Override
	public void jogo(Equipe eq1, Equipe eq2) {
		Random r = new Random();
		mandante = (Equipe1) eq1;
		visitante = (Equipe2) eq2;
		Double dAD = mandante.getHabilidadeAtaque()/visitante.getHabilidadeDefesa();
		Double dDA = visitante.getHabilidadeAtaque()/mandante.getHabilidadeDefesa();
		dAD *= 9;
		dDA *= 9;
		int difAD, difDA;
		difAD = (int) Math.floor(dAD);
		difDA = (int) Math.floor(dDA);
		while(this.getTempo() > 0){
			int key = acao(r);
			this.setTempo(getTempo()-20);
			if(this.getTempo() == 10){
				if(getGolsMandante() < getGolsVisitante()){
					difAD += 3;
					difDA -= 1;
				}else if(getGolsMandante() == getGolsVisitante()){
					difAD += 2;
					difAD += 2;
				}else{
					difDA += 2;
				}
			}
			if(key < 20 && key > 20-difAD) {
				setGolsMandante(getGolsMandante() + 1);
			}else if(key==20) {
				setGolsMandante(getGolsMandante() + 2);
			}else if(key > 1 && key < difDA) {
				setGolsVisitante(getGolsVisitante() + 1);
			}else if(key == 1) {
				setGolsVisitante(getGolsVisitante() + 2);
			}
			System.out.println();
		}
		System.out.println("90'");
		mandante.setSaldoGols(getGolsMandante() - getGolsVisitante());
		visitante.setSaldoGols(getGolsVisitante() - getGolsMandante());
		if(getGolsMandante() > getGolsVisitante()) {
			mandante.setPontuacao(mandante.getPontuacao() + 3);
		}else if(getGolsMandante() == getGolsVisitante()) {
			mandante.setPontuacao(mandante.getPontuacao() + 1);
			visitante.setPontuacao(visitante.getPontuacao() + 1);
		}else {
			visitante.setPontuacao(visitante.getPontuacao() + 3);			
		}
	}
	
	private int acao(Random r) {
		return (r.nextInt(20)+1);
	}
}
