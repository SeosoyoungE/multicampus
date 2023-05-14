package com.multi.dao.dept;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class DeptDAOImpl implements DeptDAO {

	@Autowired
	JdbcTemplate tem;
	
	@Override
	public List<DeptDTO> select() {
		List<DeptDTO> list = new ArrayList<DeptDTO>();
		list = tem.query("select * from dept",new DeptRowMapper());
		System.out.println(list.get(1).getDeptname());
		return list;
	}

	@Override
	public int delete(String deptno) {
		String sql = "delete from dept where deptno = ?";
		int result = tem.update(sql, new Object[] {deptno} , new DeptRowMapper());
		return 0;
	}

	@Override
	public DeptDTO read(String deptno) {
		return tem.queryForObject("select * from dept where deptno = ?", 
				new Object[] {deptno} , new DeptRowMapper());
	}

	@Override
	public int update(DeptDTO dept) {
		return 0;
	}

}
