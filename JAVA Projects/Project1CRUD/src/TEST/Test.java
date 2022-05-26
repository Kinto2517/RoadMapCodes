package TEST;

import DAO.StudentDAO;
import DAO.StudentDAOImp;
import com.company.Student;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {


        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        System.out.println("Application context loaded");

        StudentDAOImp studentDAOImp = context.getBean("StudentDAO",StudentDAOImp.class);

        Student st1 = new Student();

        st1.setId(002);
        st1.setName("Ersin Yılm");
        st1.setAddress("Adresss St.");


        studentDAOImp.insert(st1);

    }

}
