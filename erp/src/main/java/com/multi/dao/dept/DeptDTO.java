package com.multi.dao.dept;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*@Setter
@Getter
@ToString*/
@Data //위에 세개를 한번에 포함
@AllArgsConstructor //전체 멤버변수를 매개변수로하는 생성자 정의
@NoArgsConstructor //변수가없는 생성자
@RequiredArgsConstructor //원하는 변수를 넣은 생성자
public class DeptDTO {
	@NonNull
	private String deptno;
	@NonNull
	private String deptname;
	private String deptStartDay;
	private String deptEndDay;
	private String deptlevel;
	private String deptstep;
	private String deptuppercode;
	private String job_category;
	private String mgr_id;
	private String deptaddr;
	private String depttel;
}