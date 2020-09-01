package com.syit.dem;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.syit.dem.Mapper.StudentMapper;
import com.syit.dem.entity.OrderInvoice;
import com.syit.dem.entity.Student;
import com.syit.dem.service.OrderService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

@SpringBootTest
class DemApplicationTests {


    @Resource
    private StudentMapper   studentMapper;

    @Value("${demo.url}")
    private String url ;
    @Test
    void contextLoads() {
    }

    @Test
    public void  sorfted(){
        Student s1= new Student();
        s1.setAge(17);
        Student s2= new Student();
        s2.setAge(18);
        List<Student>  lists= new ArrayList<>();
        lists.add(s1);
        lists.add(s2);
        lists=lists.stream().sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
        System.out.println(lists.size());
    }
    @Test
    public void com1(){
        BigDecimal money= new BigDecimal(11);
        if(money.compareTo(BigDecimal.ZERO)==0){
            System.out.println(11);
        }
        else if(money.compareTo(BigDecimal.TEN)==1){
            System.out.println(22);
        }
        else{
            System.out.println(33);
        }
    }

    @Test
    public void multiply(){
        BigDecimal money1= new BigDecimal(10);
        BigDecimal money2= new BigDecimal(10);
        money2=money1.multiply(money2);
        money2=money2.add(money1.multiply(money2));

    }
    @Test
    public  void date(){
        Date TIME_0 = new Date(0);
        SimpleDateFormat format=new SimpleDateFormat("YYYY-MM-dd ");
        String str= format.format(TIME_0);
    }

    @Test
    public void test(){
        Student s=Student.builder().id(1).age(21).build();
        studentMapper.updateById(s);
    }
    @Test
    public void test1(){
//       List<Student> s=new Student().selectList(new QueryWrapper<Student>()).stream().filter(s ->s::getAge>16).collect(Collectors.toList());.map(student -> {
//           student.setName("姓名："+student.getName());
//           return student;
//
//       }).collect(Collectors.toList());
        List<Student> s=new Student().selectList(new QueryWrapper<Student>().lambda().likeRight(Student::getName,"22332322").gt(Student::getAge,20)).stream().map(student -> {
            student.setName("姓名："+student.getName());
            return student;

        }).collect(Collectors.toList());
    }


    @Test
    public void test2(){
        String s=",2,3,4,1,";
        String  s1=s.replaceAll(",","6");
        System.out.println(2222);
    }

    @Test
    public void test3(){
        List<Student> s=new Student().selectList(new QueryWrapper<Student>()).stream().map(student -> {
            student.setName("姓名："+student.getName());
            return student;

        }).sorted(Comparator.comparing(Student::getAge).reversed()).collect(Collectors.toList());
    }

    @Test
    public void test4(){
        List<Student> s=new Student().selectList(new QueryWrapper<Student>()).stream().map(student -> {
            student.setName("姓名："+student.getName());
            return student;

        }).sorted().collect(Collectors.toList());
    }

    @Test
    public void test5(){
       String  s=null;
       s= Optional.ofNullable(s).orElse("123");
       System.out.println("-------s-----------");
       s= Optional.ofNullable(s).orElse("1233");
       System.out.println("-------s-----------");
    }

    @Test
    public void test6(){
      Student s= null;
      s=Optional.ofNullable(s).orElseGet(()-> Student.builder().build());
      s.setName("222");
      System.out.println(s);
    }
}
