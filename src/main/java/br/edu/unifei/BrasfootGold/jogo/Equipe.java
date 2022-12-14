package br.edu.unifei.BrasfootGold.jogo;

import br.edu.unifei.BrasfootGold.base.*;

public class Equipe<T extends Equipe<T>>{
	private Double habilidadeDefesa;
	private Double habilidadeAtaque;
	private int posicao;
	private Partida partida;
	private Clube clube;
	private int saldoGols = 0;
	private int pontuacao = 0;
	
	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}

	public Equipe(Clube clube) {
		habilidadeDefesa = 0.0;
		habilidadeAtaque = 0.0;
		this.clube = clube;
		for(Jogador j : clube.getJogadores()) {
			if(j.getPosicao() != PosicaoEnum.ATACANTE) {
				if(j.getPosicao() == PosicaoEnum.MEIOCAMPISTA) {
					if(clube.getTecnico().getEsquema().getMentalidade() == MentalidadeEnum.DEFENSIVA){ 
						habilidadeDefesa += 0.75*j.getHabilidade();
						habilidadeAtaque += 0.25*j.getHabilidade();
					}else if(clube.getTecnico().getEsquema().getMentalidade() == MentalidadeEnum.BALANCEADA) {
						habilidadeDefesa += 0.5*j.getHabilidade();
						habilidadeAtaque += 0.5*j.getHabilidade();
					}else {
						habilidadeDefesa += 0.25*j.getHabilidade();
						habilidadeAtaque += 0.75*j.getHabilidade();
					}
				}else {
					habilidadeDefesa += (double) j.getHabilidade();
				}
			}else{
				habilidadeAtaque += (double) j.getHabilidade();
			}
		}
		habilidadeAtaque *= 4;
		habilidadeDefesa *= 4;
		habilidadeAtaque /= 11;
		habilidadeDefesa /= 11;
		
	}
	
	public Double getHabilidadeDefesa() {
		return habilidadeDefesa;
	}

	public Double getHabilidadeAtaque() {
		return habilidadeAtaque;
	}

	public int getPosicao() {
		return posicao;
	}

	public void setPosicao(int posicao) {
		this.posicao = posicao;
	}

	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
	}

	public Clube getClube() {
		return clube;
	}

	public void setClube(Clube clube) {
		this.clube = clube;
	}

	public int getSaldoGols() {
		return saldoGols;
	}

	public void setSaldoGols(int saldoGols) {
		this.saldoGols = saldoGols;
	}
	
	protected void chamarJogo(Equipe eq1, Equipe eq2) {
		partida.jogo(eq1, eq2);
	}
}
