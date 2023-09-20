package hello.servlet.basic.request;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Enumeration;


/*
* 1. 파라미터 전송 기능
* http://localhost:8080/request-param?username=hello&age=20
* */

@WebServlet(name="requestRaramServlet",urlPatterns = "/request-param")
public class RequestRaramServlet extends HttpServlet{
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 전체 파라미터 조회방법
        System.out.println("[전체 파라미터 조회] - start");
        request.getParameterNames().asIterator()
                        .forEachRemaining(paramName -> System.out.println(paramName+": "+request.getParameter(paramName)));
        System.out.println("[전체 파라미터 조회] - end");
        System.out.println();

        // 단일 파라미터 조회방법
        System.out.println("[단일 파라미터 조회] - start");
        String username = request.getParameter("username");
        System.out.println("username = " + username);
        String age = request.getParameter("age");
        System.out.println("age = " + age);
        System.out.println("[단일 파라미터 조회] - end");
        System.out.println();

        // 이름이 같은 복수 파라미터 조회방법
        System.out.println("[이름이 같은 복수 파라미터 조회]");
        
        // 중복일때 request.getParameterValues()를 사용
        // 중복일때 request.getParameter() 사용하면
        // request.getParameterValues() 첫번째 값이 반환됨 (중복으로 보내는 일은 거의없음)
        String [] usernames = request.getParameterValues("username");
        // iter 입력하면 아래와 같이 입력됨
        for (String name : usernames) {
            System.out.println("username = " + name);

        }
        response.getWriter().write("ok");

    }
}
