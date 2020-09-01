package com.syit.dem.controller;


import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.entity.Student;
import com.syit.dem.service.OrderService;
import com.syit.dem.service.StudentService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class StudentController {
    private Logger log = LoggerFactory.getLogger(getClass());


    @Resource
    public StudentService studentService;
    @RequestMapping(value = "/getStudentList")
    public void getOrderInvoiceList(){
        List<Student>  studentList=null;
        try{
            studentList=studentService.getStudentList();
        }catch (Exception e){
            log.info("--------出错----------");
        }
    }
}
