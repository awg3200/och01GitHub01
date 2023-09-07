package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class GuGu
 */
//@WebServlet("/GuGu") xml로 서버 연결하는 법하려고 주석처리함 xml로 연결하거나 자바로 서블릿 만들어서?하거나 서블릿 만드는 법 2가지? 단 xml로 하려면 이거 주석처리 해야 함 안그러면 서블릿이 두개됨 xml로도 서블릿 만들었으니까
public class GuGu extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GuGu() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		response.getWriter().append("Served at: ").append(request.getContextPath());
		int num = Integer.parseInt(request.getParameter("num")); 
		//숫자로 입력했어도 value는 문자로 들어오니 캐스팅해야함
		
		response.setContentType("text/html;charset=utf-8"); 
		//인코딩은 response쓰기 전에 미리 해야지 안그러면 인코딩 안됨 PrintWrite줄이랑 인코딩 줄 위치 바뀌니까 인코딩 제대로 안돼서 나옴
		PrintWriter out = response.getWriter();
		
		out.print("<html><body>");
		out.printf("<h1>보고싶은 구구단 %s단</h1>",num);
//		쌤 답 out.printf("<h1>보고싶은 구구단 "+num+"단</h1>",);
		for( int i = 1; i <= 9; i++) {
			out.println("<p>" + i + " * " + num + " = " + i*num + "</p>" );
//		out.printf("%d * %d = %d<br>", num,i,(num*i));
		};
		out.print("</body></html>");
		out.close();
	
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
