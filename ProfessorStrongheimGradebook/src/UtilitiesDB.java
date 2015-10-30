import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;


public class UtilitiesDB {
	static Connection getConnection() throws SQLException {

		Connection connection = null;

		// TODO Auto-generated method stub
		try {

			String url = "jdbc:oracle:thin:system/password@localhost";
			Class.forName("oracle.jdbc.driver.OracleDriver");
			// properties for creating connection to Oracle database
			Properties props = new Properties();
			props.setProperty("user", "testuserdb");
			props.setProperty("password", "password");

			// creating connection to Oracle database using JDBC
			connection = DriverManager.getConnection(url, props);

			return connection;
		} catch (SQLException e) {
			System.err.println(e);
			return null;
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}
	
	static void closeConnection (Connection connection) throws SQLException{
		try{
			connection.close();
		}catch (SQLException e){
			System.err.println(e);
		}
	}

}
