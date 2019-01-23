package service;

import dao.StrutturaDao;
import dao.persistence.DAOFactory;
import model.Struttura;

public class StrutturaServiceImpl implements StrutturaService {

	private StrutturaDao strutturaDao;
	
	public StrutturaServiceImpl() {
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.strutturaDao = factory.getStrutturaDAO();
	}
	
	@Override
	public boolean create(Struttura struttura) {
		return strutturaDao.create(struttura);
	}

	@Override
	public boolean update(Struttura struttura) {
		return strutturaDao.update(struttura);
	}

	@Override
	public boolean delete(Long idStruttura) {
		return strutturaDao.delete(idStruttura);
	}

}
