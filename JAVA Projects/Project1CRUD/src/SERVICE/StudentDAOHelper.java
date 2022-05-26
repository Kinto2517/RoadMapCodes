package SERVICE;

import DAO.StudentDAOImp;
import MAIN.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
public class StudentDAOHelper {

    public void setUpStudentTable(){
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDAOImp studentDAOImp = context.getBean("StudentDAO",StudentDAOImp.class);
        System.out.println("Application context loaded");


        Student st1 = new Student();
        Student st2 = new Student();
        Student st3 = new Student();

        st1.setId(004);
        st1.setName("Er");
        st1.setAddress("Adresss St.");

        st2.setId(005);
        st2.setName("Ersi");
        st2.setAddress("Adresss St.");

        st3.setId(006);
        st3.setName("Ers");
        st3.setAddress("Adresss St.");

        ArrayList<Student> studentList = new ArrayList<>();
        studentList.add(st1);
        studentList.add(st2);
        studentList.add(st3);

        studentDAOImp.insert(studentList);


    }
}
