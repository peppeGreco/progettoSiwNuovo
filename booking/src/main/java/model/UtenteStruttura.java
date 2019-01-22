package model;

import java.util.Set;

public class UtenteStruttura {

	private Long idUtenteStruttura;
	private String email;
	private String password;
	private Integer numeroTelefono;
	
	private Set<Struttura> strutture;
	
	public UtenteStruttura() {}

	public Long getIdUtenteStruttura() {
		return idUtenteStruttura;
	}

	public void setIdUtenteStruttura(Long idUtenteStruttura) {
		this.idUtenteStruttura = idUtenteStruttura;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Set<Struttura> getStrutture() {
		return strutture;
	}

	public void setStrutture(Set<Struttura> strutture) {
		this.strutture = strutture;
	}
	
	@Override
	public String toString() {
		return "UtenteStruttura [idUtenteStruttura=" + idUtenteStruttura + ", email=" + email + ", password=" + password
				+ ", numeroTelefono=" + numeroTelefono + "]";
	}
	
}
