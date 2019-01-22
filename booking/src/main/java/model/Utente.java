package model;

import java.util.Date;
import java.util.Set;

public class Utente {

	private Long idUtente;
	private String nome;
	private String cognome;
	private String email;
	private String password;
	private String nazionalita; 
	private String regione;
	private String comune;
	private String via;
	private String civico;
	private Integer cartaDiCredito;
	private Integer numeroTelefono;
	private Date dataNascita;
	
	private Set<Prenotazione> prenotazioni;
	
	public Utente() {}

	public Long getIdUtente() {
		return idUtente;
	}

	public void setIdUtente(Long idUtente) {
		this.idUtente = idUtente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
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

	public String getNazionalita() {
		return nazionalita;
	}

	public void setNazionalita(String nazionalita) {
		this.nazionalita = nazionalita;
	}

	public String getRegione() {
		return regione;
	}

	public void setRegione(String regione) {
		this.regione = regione;
	}

	public String getComune() {
		return comune;
	}

	public void setComune(String comune) {
		this.comune = comune;
	}

	public String getVia() {
		return via;
	}

	public void setVia(String via) {
		this.via = via;
	}

	public String getCivico() {
		return civico;
	}

	public void setCivico(String civico) {
		this.civico = civico;
	}

	public Integer getCartaDiCredito() {
		return cartaDiCredito;
	}

	public void setCartaDiCredito(Integer cartaDiCredito) {
		this.cartaDiCredito = cartaDiCredito;
	}

	public Integer getNumeroTelefono() {
		return numeroTelefono;
	}

	public void setNumeroTelefono(Integer numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}

	public Date getDataNascita() {
		return dataNascita;
	}

	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}

	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}

	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
	@Override
	public String toString() {
		return "Utente [idUtente=" + idUtente + ", nome=" + nome + ", cognome=" + cognome + ", email=" + email
				+ ", password=" + password + ", nazionalita=" + nazionalita + ", regione=" + regione + ", comune="
				+ comune + ", via=" + via + ", civico=" + civico + ", cartaDiCredito=" + cartaDiCredito
				+ ", numeroTelefono=" + numeroTelefono + ", dataNascita=" + dataNascita + "]";
	}
	
}
