package DAO;

import org.springframework.jdbc.core.JdbcTemplate;
import SERVICE.StudentRowMapper;
import MAIN.Student;

import java.util.List;


public class StudentDAOImp implements StudentDAO {
    private JdbcTemplate jdbcT;

    @Override
    public List<Student> findAllStudents() {

        String selectsql = "Select * from `school`.`student`";
        List<Student> slist = jdbcT.query(selectsql,new StudentRowMapper());

        return slist;
    }

    @Override
    public void insert(Student student) {

        String sql = "INSERT INTO `school`.`student` VALUES(" + student.getId() + ",\"" + student.getName() + "\",\"" + student.getAddress() + "\")";

        jdbcT.update(sql);

    }

    @Override
    public void insert(List<Student> students) {
        for(Student tstudent : students){

            String sql = "INSERT INTO `school`.`student` VALUES(" + tstudent.getId() + ",\"" + tstudent.getName() + "\",\"" + tstudent.getAddress() + "\")";
            jdbcT.update(sql);

        }



    }

    @Override
    public boolean deleteRecordID(int id) {
        String sql = "Delete from school.student where id="+id+"";

        int a = jdbcT.update(sql);

        return a==1 ;

    }


    public void setJdbcT(JdbcTemplate jdbcT) {
        this.jdbcT = jdbcT;
    }
}
