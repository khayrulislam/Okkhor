package DataBase;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import CurrentStatus.UserStatus;
import DataObject.User;
import Utils.Util;

public class DataBaseConnection {

	final private String dbName = "okkhor.db"; 
	final private String url = "jdbc:sqlite:db_file/"+dbName;
	final private String tableName = "user";
	
	private static DataBaseConnection dbc = null;
	
	private DataBaseConnection() {}
	
	public static DataBaseConnection getDateBaseInstance() {
		
		if(dbc==null) {
			synchronized (DataBaseConnection.class) {
				if(dbc==null) dbc = new DataBaseConnection();	
			}
		}
		return dbc;
	}
	
	
    private Connection connect() {
        // SQLite connection string
        
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }
    
    public void createNewDatabase() {
   	 
      try (Connection conn = DriverManager.getConnection(url)) {
            if (conn != null) {
                DatabaseMetaData meta = conn.getMetaData();
                System.out.println("The driver name is " + meta.getDriverName());
                System.out.println("A new database has been created.");
            }
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public void createNewTable() {
       // SQL statement for creating a new table
        String sql = "CREATE TABLE IF NOT EXISTS " + tableName+ " (\n"
                + "	id integer PRIMARY KEY,\n"
                + "	username text NOT NULL,\n"
                + "	email text NOT NULL,\n"
                + "	password text NOT NULL,\n"
                + "	date text NOT NULL,\n"
                + "	time text NOT NULL\n"
                + ");";
        
        try (Connection conn = DriverManager.getConnection(url);
                Statement stmt = conn.createStatement()) {
            // create a new table
            stmt.execute(sql);
            System.out.println("Table created sucessfully.");
            System.out.println(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    
    public boolean insert(User user) {
    	
        String sql = "INSERT INTO " + tableName+ " (username,email,password,date,time) VALUES(?,?,?,?,?)";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getEmail());
            pstmt.setString(3, user.getPassword());
            pstmt.setString(4, user.getAccountCreationDate());
            pstmt.setString(5, user.getAccountCreationTime());
            pstmt.executeUpdate();
            updateUserStatus(user);
            return true;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    
    
    
    
    public boolean isEmailExist(String email) {
    	
    	String sql = "SELECT id, username, email, password, date, time FROM " + tableName+ " WHERE email=\'" + email+ "\'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
        	while(rs.next()) {
        		return true;
        	}
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    
    private void updateUserStatus(User user) {
    	
    	UserStatus us = UserStatus.getUserStausInstance();
		us.changeUserStatus(user, Util.LOGGED_IN);
		user.printUser();
    }
    
    
    public boolean isUserExist(String email,String password) {
    	
    	String sql = "SELECT id, username, email, password, date, time FROM " + tableName+ " WHERE email=\'" + email+ "\'AND password=\'" + password+ "\'";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
        	
        	while (rs.next()) {
    			User user = new User(rs.getString("username"), rs.getString("email"), rs.getString("password"), rs.getString("date"), rs.getString("time"));
    			updateUserStatus(user);
    			return true;
            }
            
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
    
    public void selectAll(){
        String sql = "SELECT id, name, points FROM " + tableName+ "";
        
        try (Connection conn = this.connect();
             Statement stmt  = conn.createStatement();
             ResultSet rs    = stmt.executeQuery(sql)){
            
            // loop through the result set
            while (rs.next()) {
                System.out.println(rs.getInt("id") +  "\t" + 
                                   rs.getString("name") + "\t" +
                                   rs.getDouble("points"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void getpointsGreaterThan(double points){
        String sql = "SELECT id, name, points "
                   + "FROM " + tableName+ " WHERE points > ?";
 
		 try (Connection conn = this.connect();
		      PreparedStatement pstmt  = conn.prepareStatement(sql)){
		     
		     // set the value
			 pstmt.setDouble(1,points);
			 //
			 ResultSet rs  = pstmt.executeQuery();
			 
			 // loop through the result set
			 while (rs.next()) {
			     System.out.println(rs.getInt("id") +  "\t" + 
			                    rs.getString("name") + "\t" +
			                    rs.getDouble("points"));
			 }
		 } catch (SQLException e) {
		     System.out.println(e.getMessage());
		 }
    }
    
    public void update(int id, String name, double points) {
        String sql = "UPDATE " + tableName+ " SET name = ? , "
                + "points = ? "
                + "WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setString(1, name);
            pstmt.setDouble(2, points);
            pstmt.setInt(3, id);
            // update 
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void delete(int id) {
        String sql = "DELETE FROM " + tableName+ " WHERE id = ?";
 
        try (Connection conn = this.connect();
                PreparedStatement pstmt = conn.prepareStatement(sql)) {
 
            // set the corresponding param
            pstmt.setInt(1, id);
            // execute the delete statement
            pstmt.executeUpdate();
 
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
	
	
}
