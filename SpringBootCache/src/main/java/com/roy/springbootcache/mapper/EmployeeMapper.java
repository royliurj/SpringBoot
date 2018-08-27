package com.roy.springbootcache.mapper;

import com.roy.springbootcache.bean.Employee;
import org.apache.ibatis.annotations.*;

@Mapper
public interface EmployeeMapper {

    @Select("select * from employee where id = #{id}")
    public Employee getEmployeeById(Integer id);

    @Update("update employee set lastName = #{lastName}, email = #{email}, gender =#{gender}, d_id = #{dId} where id = #{id}")
    public void updateEmployee(Employee employee);

    @Delete("delete from employee where id = #{id}")
    public void deleteEmpById(Integer id);

    @Insert("insert into employee (lastName, email, gender, d_id) values(#{lastName}, #{email}, #{gender}, #{dId})")
    public void insertEmp(Employee employee);
}
