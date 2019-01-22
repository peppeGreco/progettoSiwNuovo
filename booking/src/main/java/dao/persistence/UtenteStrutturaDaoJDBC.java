package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UtenteStrutturaDao;
import model.UtenteStruttura;

public class UtenteStrutturaDaoJDBC implements UtenteStrutturaDao {
	
	private DataSource dataSource;
	
	public UtenteStrutturaDaoJDBC(DataSource dataSource) {
		
		this.dataSource = dataSource;
	}

	@Override
	public UtenteStruttura login(String email, String password) {
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from utentestruttura where email = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			
			UtenteStruttura utenteStruttura = new UtenteStruttura();
			if(result.next())
			{
				utenteStruttura.setEmail(email);
				utenteStruttura.setPassword(password);
				return utenteStruttura;
			}
			
			return null;
			
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				throw new PersistenceException(e.getMessage());
			}
		}	
	}

	@Override
	public boolean registra(UtenteStruttura utenteStruttura) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, "utentestruttura");
			utenteStruttura.setIdUtenteStruttura(id); 			
			String insert = "INSERT INTO utentestruttura(email, numeroTelefono, password, idUtenteStruttura) values (?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, utenteStruttura.getEmail());
			statement.setInt(2, utenteStruttura.getNumeroTelefono());
			statement.setString(3, utenteStruttura.getPassword());
			statement.setLong(4, utenteStruttura.getIdUtenteStruttura());

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
	public boolean update(UtenteStruttura utenteStruttura) {
		Connection connection = this.dataSource.getConnection();
		try {			
			String update = "UPDATE utentestruttura " + 
					"SET email = ?, numeroTelefono = ?, password = ?" + 
					"WHERE idUtenteStruttura = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, utenteStruttura.getEmail());
			statement.setInt(2, utenteStruttura.getNumeroTelefono());
			statement.setString(3, utenteStruttura.getPassword());
			statement.setLong(4, utenteStruttura.getIdUtenteStruttura());

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
	public boolean delete(Long idUtenteStruttura) {
		Connection connection = this.dataSource.getConnection();
		
		try {			
			String update = "DELETE FROM utentestruttura WHERE idUtenteStruttura = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			
			statement.setLong(1, idUtenteStruttura);

			if(statement.executeUpdate() == 1) IdBroker.decID(connection, "utentestruttura");
			

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
