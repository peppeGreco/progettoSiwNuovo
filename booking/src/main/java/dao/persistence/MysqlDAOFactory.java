package dao.persistence;

import dao.StrutturaDao;
import dao.UtenteDao;
import dao.UtenteStrutturaDao;

public class MysqlDAOFactory extends DAOFactory{

	private static  DataSource dataSource;
	

	static {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			//questi vanno messi in file di configurazione!!!	
			dataSource = new DataSource("jdbc:mysql://localhost:3306/dbprog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=Europe/Rome", "root", "Universita.93");
		} 
		catch (Exception e) {
			System.err.println("MysqlDAOFactory.class: failed to load MySQL JDBC driver\n"+e);
			e.printStackTrace();
		}
	}
	
	@Override
	public UtenteDao getUtenteDAO() {
		return new UtenteDaoJDBC(dataSource);
	}

	@Override
	public UtenteStrutturaDao getUtenteStrutturaDao() {
		return new UtenteStrutturaDaoJDBC(dataSource);
	}

	@Override
	public StrutturaDao getStrutturaDAO() {
		return new StrutturaDaoJDBC(dataSource);
	}

}
