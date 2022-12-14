package br.edu.unifei.BrasfootGold.jogo;

public abstract class PartidaAbstrata {
	private static int tempo = 90;
	private int golsMandante = 0;
	private int golsVisitante = 0;
	
	public int getTempo() {
		return tempo;
	}

	public void setTempo(int tempo) {
		this.tempo = tempo;
	}

	public int getGolsMandante() {
		return golsMandante;
	}

	public void setGolsMandante(int golsMandante) {
		this.golsMandante = golsMandante;
	}

	public int getGolsVisitante() {
		return golsVisitante;
	}

	public void setGolsVisitante(int golsVisitante) {
		this.golsVisitante = golsVisitante;
	}
	public abstract void jogo(Equipe eq1, Equipe eq2);
}
