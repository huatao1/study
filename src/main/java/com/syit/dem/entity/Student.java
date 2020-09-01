package com.syit.dem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

@Data
 @NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@TableName("student")
public class Student extends Model<Student> {

    private Integer id ;
    private String name ;
    private Integer age ;

    @Override
    protected Serializable pkVal() {
        return this.id;
    }
}
