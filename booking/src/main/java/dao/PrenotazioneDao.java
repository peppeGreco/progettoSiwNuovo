package dao;

import model.Prenotazione;

public interface PrenotazioneDao {

	
	public boolean create (Prenotazione prenotazione);
	public boolean update(Prenotazione prenotazione);
	public boolean delete(Long idPrenotazione);
	
}
