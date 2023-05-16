package kr.multicampus.erp.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.DBUtil;

public class EmpDAOImpl implements EmpDAO {
	public int insert(EmpDTO emp) {
		int result=0;
		String sql="insert into myemp value(?,?,?,?,?,1000,?)";
		Connection con=null;
		PreparedStatement ptmt=null;
		con=DBUtil.getConnect();
		try {
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, emp.getDeptno());
			ptmt.setString(2, emp.getName());
			ptmt.setString(3, emp.getId());
			ptmt.setString(4, emp.getPass());
			ptmt.setString(5, emp.getAddr());
			ptmt.setString(6, emp.getGrade());
			result=ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	public ArrayList<EmpDTO> select(){
		ArrayList<EmpDTO> emplist=new ArrayList<>();
		String sql="select * from myemp";
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		con=DBUtil.getConnect();
		try {
			ptmt=con.prepareStatement(sql);
			rs=ptmt.executeQuery();
			while(rs.next()) {
				EmpDTO emp=new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7));
				emplist.add(emp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return emplist;
	}
	
	public int delete(String id) {
		int result=0;
		String sql="delete from myemp where id=?";
		Connection con=null;
		PreparedStatement ptmt=null;
		con=DBUtil.getConnect();
		try {
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, id);
			result=ptmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(null, ptmt, con);
		}
		return result;
	}
	@Override
	public EmpDTO read(String id) {
		EmpDTO emp=null;
		String sql="select * from myemp where id=?";
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		con=DBUtil.getConnect();
		try {
			ptmt=con.prepareStatement(sql);
			ptmt.setString(1, id);
			rs=ptmt.executeQuery();
			if(rs.next()) {
				emp=new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}
		return emp;
	}
	
	@Override
	public EmpDTO login(String id, String pass) {
		EmpDTO emp=null;
		Connection con=null;
		PreparedStatement ptmt=null;
		ResultSet rs=null;
		String spl="select * from myemp where id=? and pass=?";
		
		con=DBUtil.getConnect();
		try {
			ptmt=con.prepareStatement(spl);
			
			ptmt.setString(1, id);
			ptmt.setString(2, pass);
			
			rs=ptmt.executeQuery();
			
			if(rs.next()) {
				emp=new EmpDTO(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getString(5), rs.getInt(6),rs.getString(7));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.close(rs, ptmt, con);
		}	
		return emp;
	}
	
}
