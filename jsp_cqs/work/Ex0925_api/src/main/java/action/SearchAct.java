package action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/list.do")
public class SearchAct extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// list.do?search_txt=value
		String search_txt = request.getParameter("search_txt");
		String search = URLEncoder.encode(search_txt, "UTF8");
		
		// 네이버 책 검색 API 설정 + 페이지 당 결과 수는 20으로 제한
		String urlStr = "https://openapi.naver.com/v1/search/book.json?query=" + search + "&display=20";
		
		URL url = new URL(urlStr);
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		
		// 발급받은 Client ID
		conn.setRequestProperty("X-Naver-Client-Id", "yxpLp0K1AzhnfTvv_gOn");
		
		// 발급받은 Client Secret
		conn.setRequestProperty("X-Naver-Client-Secret", "Cv1PzcSIiO");
		
		BufferedReader br = new BufferedReader( new InputStreamReader( conn.getInputStream() ) );
		
		String line;
		String resultJson = "";
		
		// API에서 읽어온 JSON 구조의 내용을 line 단위로 읽어 resultJson 변수에 저장
		while( ( line = br.readLine() ) != null ) {
			resultJson += line;
		}
		
		System.out.println(resultJson);
		
		br.close();
		conn.disconnect();
		// 자동으로 닫히지 않기 때문에 작업이 끝났다면 메모리 낭비를 막기 위해 모두 종료해준다
		
		// UTF-8 인코딩
		response.setContentType("text/plain;charset=UTF-8");
		response.getWriter().println("[" + resultJson + "]");
		
	}

}
