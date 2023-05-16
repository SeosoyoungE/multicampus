package kr.multicampus.erp.user;

import java.util.ArrayList;


public interface EmpDAO {
	public int insert(EmpDTO emp);
	public ArrayList<EmpDTO> select();
	public int delete(String id);
	public EmpDTO read(String id);
	public EmpDTO login(String id,String pass);
}

