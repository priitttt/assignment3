import java.sql.*;

public class databaseOperations {
    private static Connection conn;
    // Making a constructor
    public databaseOperations(Connection conn) {
        this.conn = conn;
    }
    // function to Retrive entire student table
    public static void getAllStudents() throws SQLException{
        //Creating a Statement & executing it in SQL
        Statement stmt = conn.createStatement();
        String SQL = "SELECT * FROM students";
        ResultSet rs = stmt.executeQuery(SQL);
        while(rs.next()){
            //Retrieving Results and storing them in variable
            int student_id = rs.getInt("student_id");
            String first_name = rs.getString("first_name");
            String last_name = rs.getString("last_name");
            String email = rs.getString("email");
            Date date = rs.getDate("enrollment_date");
            System.out.println("Student ID: " + student_id +" First Name: " + first_name + " Last Name: " + last_name + " Email: " + email + " Date: " + date);
        }
        // Closing everything...
        rs.close();
        stmt.close();
    }
    // Query to add a new record
    public void addStudent(String first_name, String last_name, String email, Date enrollment_date) throws SQLException{
        //Creating SQL Statement & Executing the Query
        Statement stmt = conn.createStatement();
        String insertSQL = "INSERT INTO students(first_name, last_name, email, enrollment_date) " +
                           "VALUES ('" + first_name + "', '" + last_name + "', '" + email + "', '" + enrollment_date + "')";


        int rowsInserted = stmt.executeUpdate(insertSQL);
        //Printing if adding was a success or not
        if(rowsInserted > 0){
            System.out.println("Successfully added student.");
        }
        else{
            System.out.println("Failed to add student.");
        }
        // closing statement
        stmt.close();
    }
    public void updateStudentEmail(int student_id,  String new_email) throws SQLException{
        //Creating SQL statement and executing Query
        Statement stmt = conn.createStatement();
        String SQL = "UPDATE students SET email = '" + new_email + "' WHERE student_id = " + student_id;
        int rowsUpdated = stmt.executeUpdate(SQL);
        //Message to check if it was a success
        if(rowsUpdated > 0){
            System.out.println("Successfully updated student email.");
        }
        else {
            System.out.println("Failed to update student email.");
        }
        stmt.close();
    }
    public void deleteStudent(int student_id) throws SQLException{
        //Creating Query & executing it
        Statement stmt = conn.createStatement();
        String SQL = "DELETE FROM students WHERE student_id = " + student_id;
        int rowsDeleted = stmt.executeUpdate(SQL);
        // Confirmation message
        if(rowsDeleted > 0){
            System.out.println("Successfully deleted student record.");
        }
        else {
            System.out.println("Failed to delete student record.");
        }
        //Closing Statement
        stmt.close();
    }
}

