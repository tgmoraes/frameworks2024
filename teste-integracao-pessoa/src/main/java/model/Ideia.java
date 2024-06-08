package model;

import java.util.ArrayList;
import java.util.List;

public class Ideia {
	private Integer id;
	private String descricao;
	private Pessoa autor;
	private List<Pessoa> envolvidos;
	
	public Ideia(String descricao, Pessoa autor) {
		this.autor = autor;
		this.descricao = descricao;
		this.id =null;
		this.envolvidos = new ArrayList<Pessoa>();
	}
	public Ideia(Integer id, String descricao, Pessoa autor) {
		this(descricao, autor);
		id = id;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Pessoa getAutor() {
		return autor;
	}
	public void setAutor(Pessoa autor) {
		this.autor = autor;
	}
	public List<Pessoa> getEnvolvidos() {
		return envolvidos;
	}
	public Pessoa getEnvolvido(int pos) {
		return envolvidos.get(pos);
	}
	
	public void addEnvolvido(Pessoa envolvido) {
		this.envolvidos.add(envolvido);
	}
}
