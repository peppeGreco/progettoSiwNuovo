package model;

import java.util.Set;

public class ServiziAutorizzazioniPagamento {

	private Long idServizioAutorizzazionePagamento;
	private String nome;
	
	private Set<Prenotazione> prenotazioni;
	
	public ServiziAutorizzazioniPagamento() {}
	
	public Long getIdServizioAutorizzazionePagamento() {
		return idServizioAutorizzazionePagamento;
	}
	public void setIdServizioAutorizzazionePagamento(Long idServizioAutorizzazionePagamento) {
		this.idServizioAutorizzazionePagamento = idServizioAutorizzazionePagamento;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Set<Prenotazione> getPrenotazioni() {
		return prenotazioni;
	}
	public void setPrenotazioni(Set<Prenotazione> prenotazioni) {
		this.prenotazioni = prenotazioni;
	}
	
}
