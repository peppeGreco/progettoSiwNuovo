package service;

import dao.PrenotazioneDao;
import dao.persistence.DAOFactory;
import model.Prenotazione;

public class PrenotazioneServiceImpl implements PrenotazioneService {

	
	private PrenotazioneDao prenotazioneDao;
	
	
	public PrenotazioneServiceImpl() {

	
		DAOFactory factory = DAOFactory.getDAOFactory(DAOFactory.MYSQL);
		this.prenotazioneDao = factory.getPrenotazioneDao();
	}
	
	
	@Override
	public boolean create(Prenotazione prenotazione) {
		return prenotazioneDao.create(prenotazione);
	}

	@Override
	public boolean update(Prenotazione prenotazione) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean delete(Long idPrenotazione) {
		// TODO Auto-generated method stub
		return false;
	}

}
