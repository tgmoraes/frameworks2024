package model;
import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoas")
public class Pessoa {
	@Column(name="nome", nullable= false, unique=true, length=200) 
	private String nome;
	
	@Id
    @GeneratedValue
	private Integer id;
	
	private LocalDate dataNascimento;

	public Pessoa() {
		
	}
	public Pessoa(String nome, LocalDate dataNascimento) {
		super();
		this.nome = nome;
		this.id = null;
		this.dataNascimento = dataNascimento;
	}
	public Pessoa(int id, String nome, LocalDate dataNascimento) {
		this(nome, dataNascimento);
		this.id = id;
	}
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public LocalDate getDataNascimento() {
		return dataNascimento;
	}
	public void setDataNascimento(LocalDate dataNascimento) {
		this.dataNascimento = dataNascimento;
	}
	
	@Override
	public String toString() {
		return this.id+" - nome: " + this.nome + " - dataNasc:" + this.dataNascimento.toString();  
	}
}
