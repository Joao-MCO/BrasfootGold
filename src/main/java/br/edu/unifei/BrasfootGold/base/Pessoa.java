package br.edu.unifei.BrasfootGold.base;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data
@Entity
public class Pessoa{
	@Id @GeneratedValue private long id;
	private String nome;
	private int idade;
}
