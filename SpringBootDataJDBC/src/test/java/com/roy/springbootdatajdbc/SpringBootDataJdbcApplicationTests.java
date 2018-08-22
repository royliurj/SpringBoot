package com.roy.springbootdatajdbc;

import com.roy.springbootdatajdbc.entity.Customer;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ArrayHandler;
import org.apache.commons.dbutils.handlers.BeanHandler;
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
public class SpringBootDataJdbcApplicationTests {

	@Autowired
	DataSource dataSource;


	QueryRunner queryRunner = null;


	@Test
	public void contextLoads() throws SQLException {

		System.out.println(dataSource.getClass());

		Connection connection = dataSource.getConnection();
		System.out.println(connection);

		queryRunner = new QueryRunner();

		Customer query = queryRunner.query(connection, "select c.id as id, c.customer_name as name from jpa_customer c", new BeanHandler<Customer>(Customer.class));
		System.out.println(query);

		connection.close();

	}


}
