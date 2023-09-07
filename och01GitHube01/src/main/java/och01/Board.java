package och01;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Board
 */
@WebServlet("/Board")
//@WebServlet("/Board") 만약 이부분이 주석처리 되거나 없으면 이 서블릿 못찾음 404에러남 =>이게 주소 역할
public class Board extends HttpServlet {
	private static final long serialVersionUID = 1L;
//	과제 아래처럼 출력되게 해라
//	게시판
//	제목 : 안시성
//	작성자 : 양만춘
//	작성일 : Wed Aug 16 15:47:37 KST 2023
//	내용
//	당태종 체포
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Board() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		
		PrintWriter out = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		
		Date date = new Date();
		
		//내답
//		out.println("<html><body>");
//		out.println("<h1>게시판</h1>");
//		out.printf("<p>제목 : %s</p>" , title);
//		out.printf("<p>작성자 : %s</p>" , writer);
//		out.printf("<p>작성일 : %s</p>", date);
//		out.printf("내용 <br> %s", content);
//		</html></body>태그 안닫음
//		out도 안닫음
		
		out.println("<html><body><h1>게시판</h1>");
		out.printf("<p>제목 : "+title+ "</p>" );
		out.printf("<p>작성자 : "+writer+"</p>" );
		out.printf("<p>작성일 : "+date+ "</p>" );
		out.printf("내용 <br><pre>"+ content+"</pre>");
		out.println("</body></html>");
		out.close();
		
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String title = request.getParameter("title");
		String writer = request.getParameter("writer");
		String content = request.getParameter("content");
		Date date = new Date();
		
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter out = response.getWriter();
		
//		내 답
//		out.println("<html><body>");
//		out.println("<h1>게시판</h1>");
//		out.printf("<p>제목 : %s</p>" , title);
//		out.printf("<p>작성자 : %s</p>" , writer);
//		out.printf("<p>작성일 : %s</p>", date);
//		out.printf("내용 <br> %s", content);
		
		
		out.println("<html><body><h1>게시판</h1>");
		out.printf("<p>제목 : "+title+ "</p>" );
		out.printf("<p>작성자 : "+writer+"</p>" );
		out.printf("<p>작성일 : "+date+ "</p>" );
		out.printf("내용 <br><pre>"+ content+"</pre>");
		out.println("</body></html>");
		out.close();
		}

}
