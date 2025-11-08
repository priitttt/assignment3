import java.sql.*;

public class main{
  public static void main(String[] args) throws SQLException {
      //url to connect to database with credentials mentioned
      String url = "jdbc:postgresql://localhost:5432/101325314_assignment3_q1";
      String user = "postgres";
      String password = "admin";
      try { // Load PostgreSQL JDBC Driver
          Class.forName("org.postgresql.Driver");
      // Connect to the database
          Connection conn = DriverManager.getConnection(url, user, password);
          databaseOperations dbOps = new databaseOperations(conn);

          if (conn != null) {
              System.out.println("Connected to PostgreSQL successfully!");
          } else {
              System.out.println("Failed to establish connection.");
          }


          /*Test run
          System.out.println("Getting Current Table info... \n");
          dbOps.getAllStudents();

          System.out.println("\n Adding new student... \n");
          dbOps.addStudent("Prit", "Kanani", "pritmukeshkumarkanan@cmail.carleton.ca", Date.valueOf("2005-06-16") );

          System.out.println("\n Updating Student's Email \n");
          dbOps.updateStudentEmail(3, "jim.beam@cmail.carleton.ca");

          System.out.println("Removing Student's Record ... \n");
          dbOps.deleteStudent(4);*/

          // close the connection
          conn.close();
      }
      //catch sqlExceptions
      catch (ClassNotFoundException | SQLException e) {
          e.printStackTrace();
      }


  }
}


