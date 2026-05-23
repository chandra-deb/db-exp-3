import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Task1Query {

    private static final String URL = "jdbc:mysql://localhost:3306/score_management_system?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             Scanner scanner = new Scanner(System.in)) {
            
            System.out.println("=== All Students ===");
            queryAllStudents(conn);
            
            System.out.print("\nEnter Student ID to search: ");
            if (scanner.hasNextInt()) {
                int sid = scanner.nextInt();
                queryStudentById(conn, sid);
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void queryAllStudents(Connection conn) throws Exception {
        String sql = "SELECT * FROM students";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                printStudent(rs);
            }
        }
    }

    private static void queryStudentById(Connection conn, int sid) throws Exception {
        String sql = "SELECT * FROM students WHERE sid = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sid);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    printStudent(rs);
                } else {
                    System.out.println("No student found with ID: " + sid);
                }
            }
        }
    }

    private static void printStudent(ResultSet rs) throws Exception {
        System.out.printf("ID: %d, Name: %s, Gender: %s, Major: %s, Birthday: %s, Credit Points: %.1f%n",
                rs.getInt("sid"),
                rs.getString("sname"),
                rs.getString("sgender"),
                rs.getString("smajor"),
                rs.getDate("sbirthday"),
                rs.getDouble("scredit_points")
        );
    }
}
