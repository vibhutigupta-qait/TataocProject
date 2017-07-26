import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcConnectivity {
	static private Connection connection;
	   private static java.sql.Statement statement;
	   private static ResultSet rs;
	   private static ResultSet rs2;
	   private static String name;
	   private static String passkey;
	   public int id1;
	   public int id2;
	   
	   TatocTestAdvance obj = new TatocTestAdvance();
	    public static String getName() {
		return name;
	   }

	public static void setName(String name) {
		JdbcConnectivity.name = name;
	}

	public static String getPasskey() {
		return passkey;
	}

	public static void setPasskey(String passkey) {
		JdbcConnectivity.passkey = passkey;
	}

		public void setup(){
		String UrL="jdbc:mysql://10.0.1.86:3306/tatoc";
		String username = "tatocuser";
		String password ="tatoc01";
		
		
		
         try {
             Class.forName("com.mysql.jdbc.Driver");
             System.out.println("Connecting to Database...");
             connection = DriverManager.getConnection(UrL, username, password);
             if (connection != null) {
                 System.out.println("Connected to the Database...");
             }
         } catch (SQLException ex) {
            ex.printStackTrace();
         }
         catch (ClassNotFoundException ex) {
            ex.printStackTrace();
         }
 }
	
	   public void querystatements(){
		   try{
		String query = "select * from identity";
		String query1 = "select * from credentials";
		statement = connection.createStatement();
		rs=statement.executeQuery(query);
		
		while(rs.next()){
			String symbol = rs.getString("symbol");
			System.out.println(symbol);
			if(symbol.equalsIgnoreCase(TatocTestAdvance.getDisplay())){
				id1 = rs.getInt("id");
				System.out.println(id1);
				//break;
			}
		}
				
			rs2=statement.executeQuery(query1);
			while(rs2.next()){
				id2 = rs2.getInt("id");
				System.out.println(id2);
				if(id2==id1){
					name = rs2.getString("name");
					System.out.println(name);
					passkey= rs2.getString("passkey");
					System.out.println(passkey);
				}
			}
			
		
		   }

		   catch(SQLException ex){
			   ex.printStackTrace();
		   }
		   

	   }
	public void close() {
		// TODO Auto-generated method stub
		 if (connection != null) {
             try {
                 System.out.println("Closing Database Connection...");
                 connection.close();
             } catch (SQLException ex) {
                 ex.printStackTrace();
             }
         }
   }
		
	}
	   
	



