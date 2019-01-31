package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import dao.UtenteDao;
import model.Utente;

public class UtenteDaoJDBC implements UtenteDao {

	private DataSource dataSource;
	
	public UtenteDaoJDBC(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	public Utente login(String email, String password) {
		
		Connection connection = this.dataSource.getConnection();
		try {
			PreparedStatement statement;
			String query = "select * from utente where email = ? and password = ?";
			statement = connection.prepareStatement(query);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet result = statement.executeQuery();
			
			Utente utente = new Utente();
			if(result.next())
			{
				utente.setEmail(email);
				utente.setPassword(password);
				utente.setIdUtente(result.getLong("idUtente"));
				return utente;
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

	public boolean registra(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {
			Long id = IdBroker.getId(connection, "utente");
			utente.setIdUtente(id); 			
			String insert = "INSERT INTO utente(email, cartaDiCredito, nome, cognome, numeroTelefono, password, nazionalità, regione, comune, via, civico, dataNascita, idUtente) values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
			PreparedStatement statement = connection.prepareStatement(insert);
			
			statement.setString(1, utente.getEmail());
			statement.setInt(2, utente.getCartaDiCredito());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setInt(5, utente.getNumeroTelefono());
			statement.setString(6, utente.getPassword());
			statement.setString(7, utente.getNazionalita());
			statement.setString(8, utente.getRegione());
			statement.setString(9, utente.getComune());
			statement.setString(10, utente.getVia());
			statement.setString(11, utente.getCivico());
			long secs = utente.getDataNascita().getTime();
			statement.setDate(12, new java.sql.Date(secs));
			statement.setLong(13, utente.getIdUtente());

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
	public boolean update(Utente utente) {
		Connection connection = this.dataSource.getConnection();
		try {			
			String update = "UPDATE utente " + 
					"SET email = ?, cartaDiCredito = ?, nome = ?, cognome = ?, numeroTelefono = ?, password = ?, nazionalità = ?, regione = ?, comune = ?, via = ?, civico = ?, dataNascita = ? " + 
					"WHERE idUtente = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			statement.setString(1, utente.getEmail());
			statement.setInt(2, utente.getCartaDiCredito());
			statement.setString(3, utente.getNome());
			statement.setString(4, utente.getCognome());
			statement.setInt(5, utente.getNumeroTelefono());
			statement.setString(6, utente.getPassword());
			statement.setString(7, utente.getNazionalita());
			statement.setString(8, utente.getRegione());
			statement.setString(9, utente.getComune());
			statement.setString(10, utente.getVia());
			statement.setString(11, utente.getCivico());
			long secs = utente.getDataNascita().getTime();
			statement.setDate(12, new java.sql.Date(secs));
			statement.setLong(13, utente.getIdUtente());

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
	public boolean delete(Long idUtente) {
		Connection connection = this.dataSource.getConnection();
		
		try {			
			String update = "DELETE FROM utente WHERE idUtente = ?";
			PreparedStatement statement = connection.prepareStatement(update);
			
			
			statement.setLong(1, idUtente);

			if(statement.executeUpdate() == 1) IdBroker.decID(connection, "utente");
			

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
