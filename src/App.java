import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



// Task 1 First

// public class App {
//     private static final String URL = "jdbc:mysql://localhost:3306/ScoreManagement?allowPublicKeyRetrieval=true&useSSL=false";
//     private static final String USER = "root";
//     private static final String PASSWORD = "@2";

//     public static void main(String[] args) {
//         int sid = args.length > 0 ? Integer.parseInt(args[0]) : 2;

//         try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
//              PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE sid = ?");
//              ResultSet rs = executeQuery(stmt, sid)) {

//             if (rs.next()) {
//                 ResultSetMetaData meta = rs.getMetaData();
//                 int columnCount = meta.getColumnCount();
//                 int[] columnWidths = new int[columnCount];
//                 String[] headers = new String[columnCount];

//                 for (int i = 1; i <= columnCount; i++) {
//                     headers[i - 1] = meta.getColumnName(i);
//                     columnWidths[i - 1] = headers[i - 1].length();
//                 }

//                 List<String[]> rows = new ArrayList<>();
//                 do {
//                     String[] row = new String[columnCount];
//                     for (int i = 1; i <= columnCount; i++) {
//                         String value = rs.getString(i);
//                         if (value == null) {
//                             value = "NULL";
//                         }
//                         row[i - 1] = value;
//                         columnWidths[i - 1] = Math.max(columnWidths[i - 1], value.length());
//                     }
//                     rows.add(row);
//                 } while (rs.next());

//                 StringBuilder formatBuilder = new StringBuilder();
//                 for (int width : columnWidths) {
//                     formatBuilder.append("%-")
//                                  .append(width + 2)
//                                  .append("s");
//                 }
//                 String rowFormat = formatBuilder.toString();

//                 System.out.printf(rowFormat + "%n", (Object[]) headers);
//                 for (String[] row : rows) {
//                     System.out.printf(rowFormat + "%n", (Object[]) row);
//                 }
//             }
//         } catch (SQLException e) {
//             System.err.println("JDBC error: " + e.getMessage());
//             e.printStackTrace();
//         }
//     }

//     private static ResultSet executeQuery(PreparedStatement stmt, int sid) throws SQLException {
//         stmt.setInt(1, sid);
//         return stmt.executeQuery();
//     }
// }






// Task 1 (Second)

public class App {
    private static final String URL = "jdbc:mysql://localhost:3306/ScoreManagement?allowPublicKeyRetrieval=true&useSSL=false";
    private static final String USER = "root";
    private static final String PASSWORD = "@2";

    public static void main(String[] args) {
        int sid = args.length > 0 ? Integer.parseInt(args[0]) : 2;

        try (Connection conn = DriverManager.getConnection(URL, USER, PASSWORD);
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM students WHERE sid = ?")) {

            stmt.setInt(1, sid);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    System.out.println("Student ID: " + rs.getInt("sid"));
                    System.out.println("Student Name: " + rs.getString("sname"));
                    System.out.println("Student Email: " + rs.getString("sgender"));
                    System.out.println("Student Major: " + rs.getString("smajor"));
                }
            }
        } catch (SQLException e) {
            System.err.println("JDBC error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}


