package TEST;

import SERVICE.StudentDAOHelper;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import MAIN.Student;

import DAO.StudentDAOImp;

import java.util.List;

public class Test {
    public static void main(String[] args) {

        StudentDAOHelper helper = new StudentDAOHelper();


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        StudentDAOImp studentDAOImp = context.getBean("StudentDAO",StudentDAOImp.class);

        List<Student> slist = studentDAOImp.findAllStudents();

        System.out.println(slist);

    }

}
