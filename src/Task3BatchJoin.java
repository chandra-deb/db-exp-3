import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Task3BatchJoin {

    private static final String URL = "jdbc:mysql://localhost:3306/score_management_system?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD)) {
            
            System.out.println("=== Executing Batch Operations ===");
            executeBatchInsert(conn);

            System.out.println("\n=== Executing JOIN Query ===");
            executeJoinQuery(conn);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void executeBatchInsert(Connection conn) throws Exception {
        String sql = "INSERT INTO students (sname, sgender, smajor, sbirthday, scredit_points) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            // Add multiple records to batch
            ps.setString(1, "David");
            ps.setString(2, "male");
            ps.setString(3, "Physics");
            ps.setString(4, "2001-05-12");
            ps.setDouble(5, 3.2);
            ps.addBatch();

            ps.setString(1, "Eva");
            ps.setString(2, "female");
            ps.setString(3, "Mathematics");
            ps.setString(4, "2002-11-20");
            ps.setDouble(5, 3.9);
            ps.addBatch();

            // Execute batch
            int[] results = ps.executeBatch();
            System.out.println("Batch execution completed. Rows inserted: " + results.length);
        }
    }

    private static void executeJoinQuery(Connection conn) throws Exception {
        String sql = "SELECT s.sname, c.cname, t.tname, sc.score " +
                     "FROM students s " +
                     "JOIN scores sc ON s.sid = sc.sid " +
                     "JOIN courses c ON sc.cid = c.cid " +
                     "JOIN teachers t ON c.tid = t.tid";
                     
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            System.out.printf("%-15s %-35s %-15s %-10s%n", "Student Name", "Course Name", "Teacher Name", "Score");
            System.out.println("---------------------------------------------------------------------------------");
            while (rs.next()) {
                System.out.printf("%-15s %-35s %-15s %-10.2f%n",
                        rs.getString("sname"),
                        rs.getString("cname"),
                        rs.getString("tname"),
                        rs.getDouble("score"));
            }
        }
    }
}
