package com.multi.erp;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.fail;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.util.StopWatch;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/config/servlet-context.xml"})
@WebAppConfiguration
//@runwith는 단위테스트의 실행방법을 확장할때 사용하는 어노테이션으로
//()안에 정의하는 클래스를
//실행해서 단위테스트 => 스프링과 연돟애서 단위테스트
public class DatasourceTest {
	@Autowired
	private DataSource ds;
	@Autowired
	private JdbcTemplate template;
	@Test
	public void test() {
		try {
			StopWatch stopwatch = new StopWatch();
			stopwatch.start();
			Connection con1=ds.getConnection();
			Connection con2=ds.getConnection();
			Connection con3=ds.getConnection();
			Connection con4=ds.getConnection();
			Connection con5=ds.getConnection();
			Connection con6=ds.getConnection();
			Connection con7=ds.getConnection();
			Connection con8=ds.getConnection();	
			Connection con9=ds.getConnection();
			Connection con10=ds.getConnection();
			stopwatch.stop();
			System.out.println(con1);
			System.out.println(con2);
			System.out.println(con3);
			System.out.println(con4);
			System.out.println(con5);
			System.out.println(con6);
			System.out.println(con7);
			System.out.println(con8);
			System.out.println(con9);
			System.out.println(con10);
			System.out.println("================");
			System.out.println(stopwatch.prettyPrint());
		} catch (SQLException e) {
			e.printStackTrace();
		}//커넥션풀에서 커넥션을 만들기
		System.out.println("ds>> "+ds);
		System.out.println("template>> "+template);
		
	}

}
