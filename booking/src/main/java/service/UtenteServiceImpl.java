package service;

import dao.UtenteDao;
import dao.persistence.DAOFactory;
import model.Utente;

public class UtenteServiceImpl implements UtenteService {

	private UtenteDao utenteDao;
	
	public UtenteServiceImpl() {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.utenteDao = factory.getUtenteDAO();
	}
	
	public Utente login(String email, String password) {
		return utenteDao.login(email, password);
	}

	public boolean registra(Utente utente) {
		return utenteDao.registra(utente);
	}

	@Override
	public boolean update(Utente utente) {
		return utenteDao.update(utente);
	}

	@Override
	public boolean delete(Long idUtente) {

		return utenteDao.delete(idUtente);
	}

}
