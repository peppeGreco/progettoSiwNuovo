package model;

public class Camera {
	
	private Long numeroCamera;
	private Integer numeriPostiLetto;
	private Boolean occupata;
	private Double prezzo;
	
	private Prenotazione prenotazione;
	private Struttura struttura;
	

	public Camera() {}
	
	
	public Long getNumeroCamera() {
		return numeroCamera;
	}
	public void setNumeroCamera(Long numeroCamera) {
		this.numeroCamera = numeroCamera;
	}
	public Integer getNumeriPostiLetto() {
		return numeriPostiLetto;
	}
	public void setNumeriPostiLetto(Integer numeriPostiLetto) {
		this.numeriPostiLetto = numeriPostiLetto;
	}
	public Boolean getOccupata() {
		return occupata;
	}
	public void setOccupata(Boolean occupata) {
		this.occupata = occupata;
	}

	public Double getPrezzo() {
		return prezzo;
	}

	public void setPrezzo(Double prezzo) {
		this.prezzo = prezzo;
	}
	
	public Prenotazione getPrenotazione() {
		return prenotazione;
	}


	public void setPrenotazione(Prenotazione prenotazione) {
		this.prenotazione = prenotazione;
	}

	public Struttura getStruttura() {
		return struttura;
	}

	public void setStruttura(Struttura struttura) {
		this.struttura = struttura;
	}
}
