
import java.sql.*;
import java.util.Scanner;

public class Program {

	public static final String DRIVER_NAME = "com.mysql.jdbc.Driver";
	public static final String CONNECTION_STRING = 
			"jdbc:mysql://localhost/web?user=root&password=demo";
	
	public static void main(String[] args) 
			throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_NAME);
		
		// ' and 
		
		try(Connection conn = DriverManager.getConnection(CONNECTION_STRING))
		{
			//CallableStatement sp = conn.prepareCall("call countCourses(?)");
			// IN params
			// sp.set...
			//sp.setStr
			
			//sp.execute();
			
			// OUT params
			//int count = sp.getInt(1);
			//System.out.printf("Всего курсов: %d\n", count);
			
			
			Scanner sc = new Scanner(System.in);
			System.out.print("Поиск: ");
			
			String search = sc.nextLine();
			
			// BAD : SQL injection
			Statement cmd = conn.createStatement();
			String sql = "SELECT title, length FROM courses WHERE title LIKE '%"+
					search
					+"%' ORDER BY title";
			ResultSet result = cmd.executeQuery(sql);
			//String sql = 
				//"SELECT title, length FROM courses WHERE title LIKE ? ORDER BY title";
			//PreparedStatement cmd = conn.prepareStatement(sql);
			//cmd.setString(1, "%"+search+"%");
			// cmd.setInt(2, x);
			
			//ResultSet result = cmd.executeQuery();
			
			
			while (result.next())
			{
				String title = result.getString("title");
				int length = result.getInt("length");
				if (!result.wasNull())
					System.out.printf("%-32s : %d\n", title, length);
				else
					System.out.printf("%-32s\n", title);
			}
			result.close();
			
			
		}//conn.close();

	}

}
