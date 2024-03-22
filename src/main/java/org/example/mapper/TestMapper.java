package org.example.mapper;

import org.apache.ibatis.annotations.Select;
import org.example.entry.Student;

public interface TestMapper {
    @Select("SELECT * FROM student where student_id = #{sid}")
    public Student getStudentById(int sid);
}
