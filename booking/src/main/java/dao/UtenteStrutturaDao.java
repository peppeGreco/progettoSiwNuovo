package dao;

import model.UtenteStruttura;

public interface UtenteStrutturaDao {

	public UtenteStruttura login(String email, String password);
	public boolean registra(UtenteStruttura utenteStruttura);
	public boolean update(UtenteStruttura utenteStruttura);
	public boolean delete(Long idUtenteStruttura);
}
