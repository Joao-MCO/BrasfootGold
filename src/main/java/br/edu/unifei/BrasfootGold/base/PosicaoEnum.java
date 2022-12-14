package br.edu.unifei.BrasfootGold.base;

public enum PosicaoEnum {
	GOLEIRO("GOL"), DEFENSOR("DEF"), MEIOCAMPISTA("MC"), ATACANTE("ATA");
	private String sigla;
	
	PosicaoEnum(String sigla){
		this.sigla = sigla;
	}
	
	public String getSigla() {
		return sigla;
	}
}
