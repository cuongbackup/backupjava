
import com.sun.org.apache.xerces.internal.impl.xs.SchemaGrammar;
import dao.StudentDAO;
import dbcontext.ConnectDB;
import java.sql.Connection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
/**
 *
 * @author Administrator
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
//        try {
//            // TODO code application logic here
//            ConnectDB db = ConnectDB.getInstance();
//            Connection con = db.openConnection();
//        } catch (ClassNotFoundException ex) {
//            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
//        }

        StudentDAO studentDAO = new StudentDAO();
        System.out.println("" + studentDAO.getStudents());

        studentDAO.addStudent(new Student("TranUDA", "Ly", "uda@n.m"));
        List<Student> mylist = studentDAO.getStudents();
        System.out.println("===============");
        for (Student stu : mylist) {
            System.out.println("" + stu.toString());
        }

        studentDAO.updateStudent(new Student(2, "TranUDA2022", "Ly", "2022@n.m"));
        mylist = studentDAO.getStudents();
        System.out.println("===============");
        for (Student stu : mylist) {
            System.out.println("" + stu.toString());
        }

        studentDAO.deleteStudent("2");
        mylist = studentDAO.getStudents();
        System.out.println("===============");
        for (Student stu : mylist) {
            System.out.println("" + stu.toString());
        }
    }
}
