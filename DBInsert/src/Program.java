
import java.sql.*;
import java.util.Scanner;

public class Program {

	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_STRING = 
			"jdbc:mysql://localhost/web?user=root&password=demo";
	
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING))
		{
			System.out.println(conn.getTransactionIsolation());
			Scanner sc = new Scanner(System.in);
			System.out.print("Название: ");
			String title = sc.nextLine();
			
			
			System.out.print("Длительность: ");
			int length = sc.nextInt();
			
			if (sc.hasNextLine()) sc.nextLine();
			System.out.print("Описание: ");
			String desc= sc.nextLine();
			
			// ACID transaction
			//conn.setTransactionIsolation(Connection.TRANSACTION_READ_COMMITTED);
			conn.setAutoCommit(false);
			
			
			try
			{
				String sql = 
					"INSERT INTO courses (title, length, description) VALUES (?,?,?)";
				PreparedStatement cmd = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
				cmd.setString(1, title);
				cmd.setInt(2, length);
				cmd.setString(3, desc);
				
				if (cmd.executeUpdate() == 1) {
					ResultSet keys = cmd.getGeneratedKeys();
					keys.next();
					int id = keys.getInt(1);
					
					System.out.printf("Курс добавлен. ID: %d\n", id);
					
					conn.commit();
				}
			}
			catch(Exception ex)
			{
				conn.rollback();
			}
			
			
		}//conn.close();

	}

}
