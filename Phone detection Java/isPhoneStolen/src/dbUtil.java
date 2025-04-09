
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;



public class dbUtil {
        public void addInfo(phoneInfo phoneinfo) {
           

            String SQL = "INSERT INTO stolenPhoneInfo (deviceId, deviceName, deviceType, ownerId, firstName, secondName) VALUES (?, ?, ?, ?, ?, ?)";

            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbURL = "jdbc:mysql://127.0.0.1:3306/phono";
                Connection dbConnect = DriverManager.getConnection(dbURL, "root", "000000");
                PreparedStatement sqlStm = dbConnect.prepareStatement(SQL); 
                sqlStm.setString(1, phoneinfo.getDeviceId());
                sqlStm.setString(2, phoneinfo.getDeviceName());
                sqlStm.setString(3, phoneinfo.getDeviceType());
                sqlStm.setString(4, phoneinfo.getOwnerId());
                sqlStm.setString(5, phoneinfo.getFirstName());
                sqlStm.setString(6, phoneinfo.getLastName());

                int rowsInserted = sqlStm.executeUpdate();
                if (rowsInserted > 0) {
                    System.out.println("A new user was inserted successfully!");
                } else {
                    System.out.println("Failed to insert the user.");
                }
            }
            catch(ClassNotFoundException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Class not found, check the JAR");
            }
            catch(SQLException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SQL id Bad!!"+ ex.getMessage());
            } 

        }



        public String [] searchInfo(String idOfDevice){
            String SQL = "SELECT * FROM stolenPhoneInfo WHERE deviceId = ?";
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbURL = "jdbc:mysql://127.0.0.1:3306/phono";
                Connection dbConnect = DriverManager.getConnection(dbURL, "root", "000000");
                PreparedStatement sqlStm = dbConnect.prepareStatement(SQL); 
                sqlStm.setString(1, idOfDevice); 
                ResultSet rs = sqlStm.executeQuery();

                if(rs.next()){
                    String deviceId = rs.getString("deviceId");
                    String deviceName = rs.getString("deviceName");
                    String deviceType = rs.getString("deviceType");
                    String ownerId = rs.getString("ownerId");
                    String firstName = rs.getString("firstName");
                    String secondName = rs.getString("secondName");

                    System.out.println("Device ID: " + deviceId);
                    System.out.println("Device Name: " + deviceName);
                    System.out.println("Device Type: " + deviceType);
                    System.out.println("Owner ID: " + ownerId);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Second Name: " + secondName);

                    String[] array = {firstName,ownerId,deviceType,deviceName};
                    return array;                              

                    
                } else {
                    System.out.println("No record found with the given device ID. Hence device not stolen.");
                    return null;
                    
                }
            }
            catch(ClassNotFoundException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Class not found, check the JAR");
            }
            catch(SQLException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SQL id Bad!!"+ ex.getMessage());
            }
            return null;
            

        }

        public void markFound(String devicesId){
            String SQL = "SELECT * FROM stolenPhoneInfo WHERE deviceId = ?";
            String SQL1 = "DELETE FROM stolenPhoneInfo WHERE deviceId = ?";
            
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
                String dbURL = "jdbc:mysql://127.0.0.1:3306/phono";
                Connection dbConnect = DriverManager.getConnection(dbURL, "root", "000000");
                PreparedStatement sqlStm = dbConnect.prepareStatement(SQL); 
                sqlStm.setString(1, devicesId); 
                ResultSet rs = sqlStm.executeQuery();

                if(rs.next()){
                    String deviceId = rs.getString("deviceId");
                    String deviceName = rs.getString("deviceName");
                    String deviceType = rs.getString("deviceType");
                    String ownerId = rs.getString("ownerId");
                    String firstName = rs.getString("firstName");
                    String secondName = rs.getString("secondName");

                    System.out.println("Device ID: " + deviceId);
                    System.out.println("Device Name: " + deviceName);
                    System.out.println("Device Type: " + deviceType);
                    System.out.println("Owner ID: " + ownerId);
                    System.out.println("First Name: " + firstName);
                    System.out.println("Second Name: " + secondName);

                    PreparedStatement sqlStm1 = dbConnect.prepareStatement(SQL1);
                    sqlStm1.setString(1, devicesId);
                    int rowsDeleted = sqlStm1.executeUpdate();
                    if (rowsDeleted > 0) {
                        System.out.println("Device marked as found and record deleted successfully!");
                    } else {
                        System.out.println("Failed to delete the record.");
                    }

                    
                } else {
                    System.out.println("No record found with the given device ID. Hence device not stolen.");
                }
            }
            catch(ClassNotFoundException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Class not found, check the JAR");
            }
            catch(SQLException ex){
                Logger.getLogger(App.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("SQL id Bad!!"+ ex.getMessage());
            }
            
        }

  

}
