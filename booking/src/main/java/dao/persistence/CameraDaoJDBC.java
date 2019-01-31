package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.CameraDao;
import model.Camera;

public class CameraDaoJDBC implements CameraDao {

	private DataSource dataSource;
	
	public CameraDaoJDBC(DataSource dataSource) {

		this.dataSource=dataSource;
	}
	
	
	@Override
	public boolean create(Camera camera) {

		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection,"camera");
			camera.setNumeroCamera(id); 			
			String insert = "INSERT INTO camera(numeroCamera , numeriPostiLetto , occupata,Struttura_idStruttura, prezzo , numeroSingole , numeroMatrimoniali) values (?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setLong(1, camera.getNumeroCamera());
			statement.setInt(2, camera.getNumeriPostiLetto());
			statement.setBoolean(3, camera.getOccupata());
			statement.setLong(4, camera.getStruttura().getIdStruttura());
			statement.setDouble(5, camera.getPrezzo());
			statement.setInt(6, camera.getNumeroSingoli());
			statement.setInt(7,camera.getNumeroMatrimoniali());

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
	public boolean update(Camera camera) {
		
		Connection connection = this.dataSource.getConnection();
		try {			
			String update = "UPDATE camera " + 
					"SET  numeriPostiLetto = ? , occupata = ? , prezzo = ? , numeroSingole = ? , numeroMatrimoniali = ? , Prenotazione_idPrenotazione = ? " + 
					"WHERE numeroCamera = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setInt(1, camera.getNumeriPostiLetto());
			statement.setBoolean(2, camera.getOccupata());
			statement.setDouble(3, camera.getPrezzo());
			statement.setInt(4, camera.getNumeroSingoli());
			statement.setInt(5,camera.getNumeroMatrimoniali());
			if(camera.getPrenotazione()!=null) {
				statement.setLong(6,camera.getPrenotazione().getIdPrenotazione());
			}
			
			statement.setLong(7, camera.getNumeroCamera());
			

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
	public boolean delete(Long numeroCamera) {


Connection connection = this.dataSource.getConnection();
		
		try {			
			String update = "DELETE FROM camera WHERE numeroCamera = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			
			statement.setLong(1, numeroCamera);

			if(statement.executeUpdate() == 1) IdBroker.decID(connection, "camera");
			

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
	
	

}
