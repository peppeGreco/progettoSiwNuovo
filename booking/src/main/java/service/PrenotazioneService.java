package service;

import model.Prenotazione;

public interface PrenotazioneService {

	
	public boolean create (Prenotazione prenotazione);
	public boolean update(Prenotazione prenotazione);
	public boolean delete(Long idPrenotazione);
}
