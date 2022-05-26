package DAO;

import com.company.Student;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;


public class StudentDAOImp implements StudentDAO {
    private JdbcTemplate jdbcT;

    @Override
    public void insert(Student student) {

        String sql = "INSERT INTO `school`.`student` VALUES(" + student.getId() + ",\"" + student.getName() + "\",\"" + student.getAddress() + "\")";

        jdbcT.update(sql);

    }


    public void setJdbcT(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }
}
