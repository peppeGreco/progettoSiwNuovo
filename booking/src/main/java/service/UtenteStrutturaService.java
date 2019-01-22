package service;

import model.UtenteStruttura;

public interface UtenteStrutturaService {

	public UtenteStruttura login(String email, String password);
	public boolean registra(UtenteStruttura utenteStruttura);
	public boolean update(UtenteStruttura utenteStruttura);
	public boolean delete(Long idUtenteStruttura);
}
