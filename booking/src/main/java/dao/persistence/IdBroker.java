package dao.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
                                              
public class IdBroker {

	private static final String query = "SELECT ffzg_zs_nextval(?) AS id";
	private static final String query1 = "SELECT decId(?) AS id";

	public static Long getId(Connection connection, String name) {
		Long id = null;  
		try {
			PreparedStatement statement = connection.prepareStatement(query);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			result.next();
			id = (long) result.getInt("id");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
	
	public static Long decID(Connection connection, String name) {
		Long id = null;
		try {
			PreparedStatement statement = connection.prepareStatement(query1);
			statement.setString(1, name);
			ResultSet result = statement.executeQuery();
			result.next();
			id = (long) result.getInt("id");
		} catch (SQLException e) {
			throw new PersistenceException(e.getMessage());
		}
		return id;
	}
	
	public static void main(String[] args) {
		
		DataSource dataSource = new DataSource("jdbc:mysql://localhost:3306/dbprog?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "Universita.93");
		Connection connection = dataSource.getConnection();
		
		System.out.println(IdBroker.getId(connection,"camera"));
		
	}
	
}
