package com.example.demo.Mapper;

import com.example.demo.Model.XieyjBill;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import java.util.List;
@Mapper
public interface BillMapper {

    @Select("select * from xieyj_bill")
    List<XieyjBill> findAll();

    @Insert("insert into xieyj_bill(code,name) values(#{code},#{name})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "id",
            before = false, resultType = Integer.class)
    void insert(XieyjBill xieyjBill);

}
