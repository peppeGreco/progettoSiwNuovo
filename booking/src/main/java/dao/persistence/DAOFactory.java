package dao.persistence;

import dao.CameraDao;
import dao.PrenotazioneDao;
import dao.StrutturaDao;
import dao.UtenteDao;
import dao.UtenteStrutturaDao;

public abstract class DAOFactory {

	// --- List of supported DAO types ---

	
	/**
	 * Numeric constant '1' corresponds to explicit Hsqldb choice
	 */
	public static final int MYSQL = 1;
	
	/**
	 * Numeric constant '2' corresponds to explicit Postgres choice
	 */
	public static final int POSTGRESQL = 2;
	
	
	// --- Actual factory method ---
	
	/**
	 * Depending on the input parameter
	 * this method returns one out of several possible 
	 * implementations of this factory spec 
	 */
	public static DAOFactory getDAOFactory(int whichFactory) {
		switch ( whichFactory ) {
		
		case MYSQL:
			return new MysqlDAOFactory();//new HsqldbDAOFactory();
		case POSTGRESQL:
			return null;
		default:
			return null;
		}
	}
	
	
	
	// --- Factory specification: concrete factories implementing this spec must provide this methods! ---
	
	/**
	 * Method to obtain a DATA ACCESS OBJECT
	 * for the datatype 'Utente'
	 */
	public abstract UtenteDao getUtenteDAO();
	
	public abstract UtenteStrutturaDao getUtenteStrutturaDao();
	
	public abstract StrutturaDao getStrutturaDAO();
	
	public abstract CameraDao getCameraDAO();
	
	public abstract PrenotazioneDao getPrenotazioneDao();

}
