package model;
import java.time.LocalDate;

public class Pessoa {
	private String nome;
	private Integer id;
	private LocalDate dataNascimento;

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
