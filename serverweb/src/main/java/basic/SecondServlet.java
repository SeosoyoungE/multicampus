package basic;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SecondServlet extends HttpServlet{ 
	  public void service(HttpServletRequest req, HttpServletResponse res) throws ServletException,IOException{ 
		  //7단출력하기 - 비즈니스로직
		  for(int i=1;i<=9;i++) {
			  System.out.println("7 * "+i+" = "+7*i);
		  }

  } 
	  }
 
