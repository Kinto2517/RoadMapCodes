package SERVICE;

import MAIN.Student;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentRowMapper implements RowMapper<Student> {

    @Override
    public Student mapRow(ResultSet rs, int rowNum) throws SQLException {

        Student a = new Student();

        a.setId(rs.getInt("id"));
        a.setName(rs.getString("student_name"));
        a.setAddress(rs.getString("student_address"));

        rs.getString("student_name");

        rs.getString("student_address");
        return a;
    }
}
