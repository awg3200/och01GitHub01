package och01;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Add3
 */
@WebServlet("/Add3")  //@는 어드레스 주소 @은 annotation 아니면 xml로 셋팅하거나 (servlet-api.jar상속받아서 여기 있는 라이브러리 다 쓸수 있고 그걸 사용하는 방법은 @나xml)
public class Add3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Add3() { //생성자
        super(); // HttpServlet의 아버지? 아님 그냥  HttpServlet? 8.16 2:6
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		웹프로그래밍의 기본은 리퀘스트를 받아 사용자에게 리스폰스를 주는 것
//		url은 uniform resource locate의 줄임말로 ㅇㅇㅇ 자원이 있는 위치
//		url은 화면상의 주소 url로 요청하면 dns가 해당 주소와 맞는 ip주소 맵핑해서 주는 것
//		url은 도메인등록된 것? 도메인과 url의 차이는 뭐지?
		
		//이건 우리가 만든 메소드가 아니라 서블릿 만들면 자동으로 생기는 메소드
		//서버는 request객체와 response객체가 기본인자
		//리퀘스트는 add3에서 사용자가 입력하는 입력값을 리퀘스트 객체로 받아서 doGet안에 넣어주는거고
		//따라서 add3에서 사용자가 입력한 num, loc같은 파라미터는 request객체 안에 담겨 있음
		//내가 브라우저로부터 서버에게 요청하는게 리퀘스트 
		//리스폰스는 doGet에서의 결과를 받을 객체
		//서버로 부터 브라우저로 응답하는게 리스폰스
		System.out.println("doGet 여기왔네"); //add3실행시키고 올바르게 값 입력하고 확인 누르면 웹페이지엔 암것도 안뜨지만 콘솔창에 여기왔네 메세지 뜸
		//parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		//add3에서 자스로 isNaN써서 숫자 아니면 여기로 안넘어오게 했으므로 num은 다 숫자일 수밖에 없으므로 안심하고 parseInt써도 됨
		//int num = request.getParameter("num");
		//request.getParameter("num")는 문자열(add3에서 입력받은 것은 문자이므로 위처럼 그냥 이대로 두면 에러남 string->int로 바꿔줘야 함)
		//getParameter()로 request 객체 내에 있는 파라미터 꺼내줌
		
		String loc = request.getParameter("loc");
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
		//add3에서 사용자가 값 맞게 입력하고 확인 누르면 그 값들 request객체에 담겨서 여기로 오고 getParameter로 값 꺼냄
		//위에 syso실행 결과는 웹브라우저에 나타나는게 아니라 아래 콘솔에 나타남
		//근데 콘솔은 개발자끼리만 보는 것
		//따라서 사용자가 보게하기 위해선 response객체에 담아서 브라우저에 보이게 해야함
		
		//< 목표 : 1부터 누적값 전달>
		int sum = 0;
		for(int i = 1; i <=num; i++) {
			sum +=i;
		}
		System.out.println("sum->"+sum);
		
		//Encoding 적용
		//리스폰스 인코딩 시기 -> response 객체 사용하기 전에 미리 인코딩 해줘야 함
		response.setContentType("text/html;charset=utf-8");
//		response결과를 사용자에게 브라우저를 통해 한글로 보여주기 위해 필요한 인코딩 코드
//		없으면 아래에 out.print류 메소드에 적은 한글부분들 깨져서 나옴
		
		//request.setCharacterEncoding("utf-8");
		//사용자로부터 한글 입력받기 위해 리퀘스트를 utf-8로 인코딩 해주는 것 
		//여기선 당장 필요 없지만 나중에 필요할 때 참고하라고 적어둠
		//get방식에선 request인코딩 필요 없음 response에 대한 인코딩만 있어도 됨
		//dopost는 리퀘스트 리스폰스 둘다 해줘야 함 다만 시기는 해당 객체 사용전에 미리 인코딩해줘야 함
		
		//공식 => 사용자 Browser에 보여주는 객체 따라서 HTML태그까지 써줘야 함
		PrintWriter out = response.getWriter();
		/*- 웹 브라우저에 데이터를 전송하려면 response객체의 getWriter()를 호출해서 문자열 데이터를 출력할 수
있는 PrintWriter를 가져오고 print()나 println()을 이용해서 html
코드를 전송하면 됨*/
//				response는 화면에 보여주는 객체
//		출력하고자 하면 )출력을 하고자 하는 경우라면 response객체의 getWriter()를 호출해서
//		PriterWriter 객체를 받은 후 print 또는 println 메서드를 이용해서 html
//		코드를 리턴(print는 이어지는 문장을 계속 작성하고자 하는 경우
//		사용하고 println은 하나의 문장을 작성하기 위해서 사용)
//		따라서 out은 콘솔이 아니라 브라우저에 보여주는 객체
//		PrintWriter out = response.getWriter(); 이게 걍 공식
		out.println("<html><body>");
//		이제 syso가 아니라 위처럼 out 변수 선언하고 out.print로 씀
		out.printf("<h1>1부터 %d까지 합계 </h1>", num);
		out.printf("<h4>LOC--> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		//태그 잘 적용됐는지는 브라우저-우클릭-검사에서 확인 가능
		
		//
//		add3 실행 후 5와 이대 입력하면 브라우저에 리스폰스 결과 
//		1?? 5?? ??
//		LOC--> ??
//		15
//		이런 식으로 깨져서 나옴 
//		why? 서블릿 만든 사람 입장에선 한글이나 일본어등 영어외의 언어는 생각하지 않은 것
//		따라서 인코딩 해줘야 하는 것
//		인코딩은 out변수 선언 전에 먼저 해주기 인코딩을 먼저 해줘야 깨지지 않고 나올 수 있음
//		응답을 전송하고자 하는 경우는 response 객체의 setContentType()메서드를 이용해서
//		타입과 인코딩 방식을 지정.
//		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost 여기왔네");
		
		//리퀘스트 인코딩 시기 ->request Parameter 받기전 Encoding적용 해줘야 함
		request.setCharacterEncoding("utf-8");
		//아래에 getParameter로 리퀘스트 꺼내기 전에 인코딩해줘야 안깨짐
		
		//Parameter 받기
		int num = Integer.parseInt(request.getParameter("num"));
		String loc = request.getParameter("loc");
		System.out.println("num->"+num);
		System.out.println("loc->"+loc);
		
		//< 목표 : 1부터 누적값 전달>
		int sum = 0;
		for(int i = 1; i <=num; i++) {
			sum +=i;
		}
		System.out.println("sum->"+sum);
		
		//Encoding 적용
		response.setContentType("text/html;charset=utf-8");
		
		//공식 => 사용자 Browser에 보여주는 객체
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
//		이제 syso가 아니라 위처럼 out 변수 선언하고 out.print로 씀
		out.printf("<h1>1부터 %d까지 Post 합계 </h1>", num);
		out.printf("<h4>LOC--> %s</h4>", loc);
		out.println(sum);
		out.println("</body></html>");
		out.close();
		
		//결과 
//		1부터 7까지 Post 합계
//		LOC--> ì´ë
//		28
//		이렇게 깨져서 나옴 -> 값을 받을 때 깨지게 받아서 그런 것
//		따라서 리퀘스트를 인코딩해줘야 함 그래야 안깨지고 한글 나옴
//		단, 리퀘스트 객체 사용하기 전에 미리 인코딩해야함
		
		
//		8.16 3:12
	}

}
