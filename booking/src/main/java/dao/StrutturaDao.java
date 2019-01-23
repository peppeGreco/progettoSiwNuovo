package dao;

import model.Struttura;

public interface StrutturaDao {

	public boolean create(Struttura struttura);
	public boolean update(Struttura struttura);
	public boolean delete(Long idStruttura);
}
