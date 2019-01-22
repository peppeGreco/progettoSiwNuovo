package service;

import model.Utente;

public interface UtenteService {
	
	public Utente login(String email, String password);
	public boolean registra(Utente utente);
	public boolean update(Utente utente);
	public boolean delete(Long idUtente);

}
