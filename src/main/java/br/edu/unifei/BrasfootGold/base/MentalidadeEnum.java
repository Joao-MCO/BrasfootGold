package br.edu.unifei.BrasfootGold.base;

public enum MentalidadeEnum {
	OFENSIVA("ofensiva"),
	DEFENSIVA("defensiva"),
	BALANCEADA("balanceada");
	
	private String descricao;
	
	MentalidadeEnum(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
