package service;

import model.Struttura;

public interface StrutturaService {

	public boolean create(Struttura struttura);
	public boolean update(Struttura struttura);
	public boolean delete(Long idStruttura);
}
