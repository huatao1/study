package com.syit.dem.Mapper;



import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.entity.Student;
import org.apache.ibatis.annotations.Select;

import java.util.List;


public interface StudentMapper {

    @Select("  select * from student where id='3333' ")
    List<Student> getStudents();
    @Select("  select * from student where id='3333' ")
    Student getStudent();
}
