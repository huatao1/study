package com.syit.dem.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syit.dem.Mapper.OrderMapper;
import com.syit.dem.Mapper.StudentMapper;
import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.entity.Student;
import com.syit.dem.service.OrderService;
import com.syit.dem.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Resource
    private   StudentMapper StudentMapper;

    @Override
    public List<Student> getStudentList() {
       Student  s= new Student().selectOne(new QueryWrapper<Student>().lambda().eq(Student::getAge,14));
       return  new ArrayList<>();
    }
}
