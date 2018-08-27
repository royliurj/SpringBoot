package com.roy.springbootcache;

import com.roy.springbootcache.bean.Employee;
import com.roy.springbootcache.mapper.EmployeeMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringbootcacheApplicationTests {

	@Autowired
	DataSource dataSource;

	@Autowired
	EmployeeMapper employeeMapper;

	@Test
	public void contextLoads() throws SQLException {

		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		Employee employee = employeeMapper.getEmployeeById(1);
		System.out.println(employee);
	}

}
