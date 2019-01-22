package service;

import dao.UtenteStrutturaDao;
import dao.persistence.DAOFactory;
import model.UtenteStruttura;

public class UtenteStrutturaServiceImpl implements UtenteStrutturaService {

	private UtenteStrutturaDao utenteStrutturaDao;
	
	public UtenteStrutturaServiceImpl() {

		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.utenteStrutturaDao = factory.getUtenteStrutturaDao();
	}
	
	@Override
	public UtenteStruttura login(String email, String password) {
		return utenteStrutturaDao.login(email, password);
	}

	@Override
	public boolean registra(UtenteStruttura utenteStruttura) {
		return utenteStrutturaDao.registra(utenteStruttura);
	}

	@Override
	public boolean update(UtenteStruttura utenteStruttura) {
		return utenteStrutturaDao.update(utenteStruttura);
	}

	@Override
	public boolean delete(Long idUtenteStruttura) {
		return utenteStrutturaDao.delete(idUtenteStruttura);
	}

}
