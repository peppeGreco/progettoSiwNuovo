package model;

import java.util.Set;

public class Struttura {

	private Long idStruttuta;
	private String nome;
	private String citt�;
	
	private Set<Camera> camere;
	
	private UtenteStruttura utenteStruttura;
	
	public Struttura() {}

	public Long getIdStruttuta() {
		return idStruttuta;
	}

	public void setIdStruttuta(Long idStruttuta) {
		this.idStruttuta = idStruttuta;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCitt�() {
		return citt�;
	}

	public void setCitt�(String citt�) {
		this.citt� = citt�;
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
