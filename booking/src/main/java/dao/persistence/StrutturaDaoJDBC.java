package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dao.StrutturaDao;
import model.Struttura;

public class StrutturaDaoJDBC implements StrutturaDao {
	
	
	private DataSource dataSource;
	
	public StrutturaDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public boolean create(Struttura struttura) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection,"struttura");
			struttura.setIdStruttura(id); 			
			String insert = "INSERT INTO struttura(nome , citta, idStruttura , UtenteStruttura_idUtenteStruttura) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, struttura.getNome());
			statement.setString(2, struttura.getCitta());
			statement.setLong(3, struttura.getIdStruttura());
			statement.setLong(4, struttura.getUtenteStruttura().getIdUtenteStruttura());
			
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
	public boolean update(Struttura struttura) {

		Connection connection = this.dataSource.getConnection();
		try {			
			String update = "UPDATE struttura " + 
					"SET nome = ? , citta = ? " + 
					"WHERE idStruttura = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, struttura.getNome());
			statement.setString(2, struttura.getCitta());
			statement.setLong(3, struttura.getIdStruttura());

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
	public boolean delete(Long idStruttura) {
		Connection connection = this.dataSource.getConnection();
		
		try {			
			String delete = "DELETE FROM struttura WHERE idStruttura = ? ";
			PreparedStatement statement = connection.prepareStatement(delete);
			
			
			statement.setLong(1, idStruttura);

			if(statement.executeUpdate() == 1) IdBroker.decID(connection, "struttura");
						

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
