package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.PrenotazioneDao;
import model.Camera;
import model.Prenotazione;
import service.CameraService;
import service.CameraServiceImpl;

public class PrenotazioneDaoJDBC implements PrenotazioneDao {

	private DataSource dataSource;
	
	
	public PrenotazioneDaoJDBC(DataSource dataSource) {

		this.dataSource = dataSource;
	
	}
	
	
	@Override
	public boolean create(Prenotazione prenotazione) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection,"prenotazione");
			prenotazione.setIdPrenotazione(id); 			
			String insert = "INSERT INTO prenotazione(idPrenotazione,dataCheckIn,dataCheckOut,Utente_idUtente,scadenzaModifica,ServiziAutorizzazioniPagamento_idServiziAutorizzazioniPagamento,totale) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setLong(1, prenotazione.getIdPrenotazione());
			
			long secs =prenotazione.getCheckIn().getTime();
			statement.setDate(2, new java.sql.Date(secs));
			
			secs =prenotazione.getCheckOut().getTime();
			statement.setDate(3, new java.sql.Date(secs));
			
			statement.setLong(4, prenotazione.getUtente().getIdUtente());
			
			statement.setBoolean(5, prenotazione.getScadenzaModifica());
			
			statement.setLong(6, prenotazione.getServizioAutorizzazioniPagamento().getIdServizioAutorizzazionePagamento());
			statement.setDouble(7, prenotazione.getTotale());
			
			statement.executeUpdate();
			
		
			

		} catch (SQLException e) {
			if (connection != null) {
				try {
					connection.rollback();
				} catch(SQLException excep) {
					throw new PersistenceException(e.getMessage());
				}
			}
			return false;
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}
		
		return true;
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
