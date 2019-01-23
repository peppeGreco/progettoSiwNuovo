package model;

import java.util.Set;

public class Struttura {

	private Long idStruttura;
	private String nome;
	private String citta;
	
	private Set<Camera> camere;
	
	private UtenteStruttura utenteStruttura;
	
	public Struttura() {}

	public Long getIdStruttura() {
		return idStruttura;
	}

	public void setIdStruttura(Long idStruttura) {
		this.idStruttura = idStruttura;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitta() {
		return citta;
	}

	public void setCitta(String citta) {
		this.citta = citta;
	}

	public Set<Camera> getCamere() {
		return camere;
	}

	public void setCamere(Set<Camera> camere) {
		this.camere = camere;
	}

	public UtenteStruttura getUtenteStruttura() {
		return utenteStruttura;
	}

	public void setUtenteStruttura(UtenteStruttura utenteStruttura) {
		this.utenteStruttura = utenteStruttura;
	}
}
