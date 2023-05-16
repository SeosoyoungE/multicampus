package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @WebServlet은 서블릿을 등록하기 위한 어노테이션
//@WebServlet의 name속성은 서블릿의 이름을 등록하기 위해서 사용하는 속성
//urlPatterns은 여러개를 등록할수 있으므로 배열로 관리
//마찬가지로 서버를 내렸다올려야함
//서블릿명이 중복되면 안된다.
@WebServlet(name="annotation_servlet", urlPatterns = {"/test/anno.do"})
public class AnnotationServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("어노테이션으로 서블릿등록하기");
	}
	
}
