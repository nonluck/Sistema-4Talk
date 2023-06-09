package model;

import java.util.ArrayList;

public class Individual extends Participante {
	private String senha;
	private boolean administrador;
	private ArrayList<Grupo> grupos = new ArrayList<>();

	public Individual(String nome, String senha, boolean administrador) throws Exception {
		super(nome);
		if (senha.length() == 0)
			throw new Exception("O CAMPO DE SENHA PRECISA SER PREENCHIDO");
		this.senha = senha;
		this.administrador = administrador;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) throws Exception {
		if (senha.length() == 0)
			throw new Exception("O CAMPO DE SENHA PRECISA SER PREENCHIDO");
		this.senha = senha;
	}

	public boolean getAdministrador() {
		return administrador;
	}

	public void setAdministrador(boolean valor) throws Exception {
		this.administrador = valor;
	}

	public ArrayList<Grupo> getGrupos() {
		return grupos;
	}

	public boolean adicionar(Grupo grupo) {
		if (this.grupos.indexOf(grupo) == -1) {
			this.grupos.add(grupo);
			return true;
		} else
			return false;
	}

	public boolean remover(Grupo grupo) {
		return this.grupos.remove(grupo);
	}

	public String toString() {
		String checkAdministrador = "Não é";

		if (this.administrador)
			checkAdministrador = "Sim,";

		return "Nome: " + this.getNome() + " e sua senha é \"" + this.getSenha() + "\", " + checkAdministrador
				+ " administrador." + "\n grupos=" + grupos;
	}

	public Grupo localizarGrupo(String nome) {
		for (Grupo g : this.grupos) {
			if (g.getNome().equals(nome)) {
				return g;
			}
		}
		return null;
	}

	@Override
	public boolean equals(Participante p) {
		if (!(p instanceof Individual))
			return false;

		return (this.getNome().equals(p.getNome()) &&
				this.getSenha().equals(((Individual) p).getSenha()));
	}

}
