package model;

import java.util.Date;
import java.util.Set;

public class Prenotazione {

	private Long idPrenotazione;
	private Date checkIn;
	private Date checkOut;
	private Boolean scadenzaModifica;
	private Double totale;
	
	private Set<Camera> camere;
	
	private Utente utente;
	private ServiziAutorizzazioniPagamento servizioAutorizzazioniPagamento;
	
	public Prenotazione() {}
	
	public Long getIdPrenotazione() {
		return idPrenotazione;
	}
	public void setIdPrenotazione(Long idPrenotazione) {
		this.idPrenotazione = idPrenotazione;
	}
	public Date getCheckIn() {
		return checkIn;
	}
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	public Date getCheckOut() {
		return checkOut;
	}
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	public Boolean getScadenzaModifica() {
		return scadenzaModifica;
	}
	public void setScadenzaModifica(Boolean scadenzaModifica) {
		this.scadenzaModifica = scadenzaModifica;
	}
	
	public Set<Camera> getCamere() {
		return camere;
	}
	public void setCamere(Set<Camera> camere) {
		this.camere = camere;
	}

	public Utente getUtente() {
		return utente;
	}

	public void setUtente(Utente utente) {
		this.utente = utente;
	}

	public ServiziAutorizzazioniPagamento getServizioAutorizzazioniPagamento() {
		return servizioAutorizzazioniPagamento;
	}

	public void setServizioAutorizzazioniPagamento(ServiziAutorizzazioniPagamento servizioAutorizzazioniPagamento) {
		this.servizioAutorizzazioniPagamento = servizioAutorizzazioniPagamento;
	}

	public Double getTotale() {
		return totale;
	}

	public void setTotale(Double totale) {
		this.totale = totale;
	}
	
}
