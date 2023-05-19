package com.multi.erp.etc;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/*
 * 인터셉터를 만들기
 * - HandlerInterceptorAdapter 상속하기
 * - 사용하고 싶은 기능을 구현할 수 있는 메소드를 오버라이딩
 * 1) preHandle
 *  >> 컨트롤러 호출전에 실행되는 메소드
 *  >> return값이 true면 다음을 진행 (인터셉터 > 컨트롤러 > 서비스 > DAO)
 *  >> false면 더이상 진행하지 않겠다는 의미
 * 2) postHandle
 *  >> 컨트롤러 실행 후에 호출되는 메소드
 * 3) afterCompletion
 *  >> 뷰가 렌더링 된 후에 호출되는 메소드
*/
//컨트롤러가 실행되는 시간을 측정하는 인터셉터
public class TimeCheckInterceptor extends HandlerInterceptorAdapter {
	private long start;
	private long end;
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		System.out.println("=====================preHandle=====================");
		System.out.println("접속한 IP: "+request.getRemoteHost());
		start=System.nanoTime();
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		end=System.nanoTime();
		System.out.println("************PostHandle************");
		String handlerClass=handler.getClass().getName();
		System.out.println("실행객체: "+handlerClass+"  실행시간: "+(end-start));
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		super.afterCompletion(request, response, handler, ex);
	}
	
}
