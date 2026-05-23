import java.sql.Date;
import java.util.List;

public class Task4Demo {

    public static void main(String[] args) {
        StudentDao studentDao = new StudentDao();

        // 1. Insert
        System.out.println("--- Testing Insert ---");
        Student newStudent = new Student("Frank", "male", "Biology", Date.valueOf("2000-01-01"), 2.0);
        studentDao.insertStudent(newStudent);
        System.out.println("Inserted new student: Frank");

        // 2. Fuzzy Search
        System.out.println("\n--- Testing Fuzzy Search (Keyword: 'a') ---");
        List<Student> searchResults = studentDao.searchStudentsByName("a");
        for (Student s : searchResults) {
            System.out.println(s);
        }

        // 3. Pagination
        System.out.println("\n--- Testing Pagination (Page 1, Size 3) ---");
        List<Student> pageResults = studentDao.getStudentsByPage(1, 3);
        for (Student s : pageResults) {
            System.out.println(s);
        }

        // 4. Delete
        // Just deleting student with id 4 as an example.
        System.out.println("\n--- Testing Delete (id: 4) ---");
        studentDao.deleteStudent(4);
        System.out.println("Deleted student with ID 4");
    }
}
