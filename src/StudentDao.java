import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDao {

    private static final String URL = "jdbc:mysql://localhost:3306/score_management_system?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    private Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }

    public void insertStudent(Student student) {
        String sql = "INSERT INTO students (sname, sgender, smajor, sbirthday, scredit_points) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            ps.setString(1, student.getSname());
            ps.setString(2, student.getSgender());
            ps.setString(3, student.getSmajor());
            ps.setDate(4, student.getSbirthday());
            ps.setDouble(5, student.getScreditPoints());
            ps.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void deleteStudent(int sid) {
        String sql = "DELETE FROM students WHERE sid = ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, sid);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Student> searchStudentsByName(String keyword) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE sname LIKE ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + keyword + "%");
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(extractStudent(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    public List<Student> getStudentsByPage(int page, int pageSize) {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students LIMIT ? OFFSET ?";
        try (Connection conn = getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             
            int offset = (page - 1) * pageSize;
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    students.add(extractStudent(rs));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return students;
    }

    private Student extractStudent(ResultSet rs) throws SQLException {
        Student student = new Student();
        student.setSid(rs.getInt("sid"));
        student.setSname(rs.getString("sname"));
        student.setSgender(rs.getString("sgender"));
        student.setSmajor(rs.getString("smajor"));
        student.setSbirthday(rs.getDate("sbirthday"));
        student.setScreditPoints(rs.getDouble("scredit_points"));
        return student;
    }
}
