import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Task2Transaction {

    private static final String URL = "jdbc:mysql://localhost:3306/score_management_system?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL, USER, PASSWORD);
            conn.setAutoCommit(false); 

            System.out.println("Transaction started...");

            updateStudentCredit(conn, 1, 4.0);

            int nonExistentSid = 999;
            int rows = updateStudentCredit(conn, nonExistentSid, 1.0);
            if (rows == 0) {
                throw new SQLException("Update failed: Student with ID " + nonExistentSid + " does not exist!");
            }

            conn.commit();
            System.out.println("Transaction committed successfully.");

        } catch (SQLException e) {
            System.err.println("Exception caught: " + e.getMessage());
            try {
                if (conn != null) {
                    conn.rollback(); 
                    System.out.println("Transaction rolled back successfully.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        } finally {
            try {
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static int updateStudentCredit(Connection conn, int sid, double newCredit) throws SQLException {
        String sql = "UPDATE students SET scredit_points = ? WHERE sid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDouble(1, newCredit);
            ps.setInt(2, sid);
            int rows = ps.executeUpdate();
            System.out.println("Updated credit for student " + sid + " - Rows affected: " + rows);
            return rows;
        }
    }
}
