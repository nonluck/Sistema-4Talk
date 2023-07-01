package model;

import java.util.ArrayList;

public class Participante {

	private String nome;
	private ArrayList<Mensagem> enviadas = new ArrayList<>();
	private ArrayList<Mensagem> recebidas = new ArrayList<>();

	public Participante(String nome) {
		this.nome = nome.strip();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome.strip();
	}

	public ArrayList<Mensagem> getRecebidas() {
		return recebidas;
	}

	public void adicionarRecebida(Mensagem m) {
		this.recebidas.add(this.recebidas.size(), m);
	}

	public void removerRecebida(Mensagem m) {
		this.recebidas.remove(m);
	}

	public Mensagem localizarRecebida(int id) {
		for (Mensagem msg : this.recebidas) {
			if (msg.getId() == id) {
				return msg;
			}
		}
		return null;
	}

	public ArrayList<Mensagem> getEnviadas() {
		return enviadas;
	}

	public boolean adicionarEnviada(Mensagem mensagem) {
		return this.enviadas.add(mensagem);

	}

	public boolean removerEnviada(Mensagem mensagem) {
		return this.enviadas.remove(mensagem);
	}

	public Mensagem localizarEnviada(int id) {
		for (Mensagem msg : this.enviadas) {
			if (msg.getId() == id) {
				return msg;
			}
		}
		return null;
	}

	public boolean equals(Participante p) {
		return (this.getNome().equals(p.getNome()));
	}

}
