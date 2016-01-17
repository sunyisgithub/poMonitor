package pomonitor.servlet;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.pdfbox.util.operator.EndText;

import pomonitor.analyse.ArticleTendAnalyse;

/**
 * 网站综合评测页面
 * 
 * @author hengyi
 * 
 */
public class SiteEvaluationServlet extends HttpServlet {

	public SiteEvaluationServlet() {
		super();
	}

	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String start_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String method = request.getParameter("method");
		String userID = request.getParameter("userID");
		// String resJson = "";
		// switch (method) {
		// case "getWebTend":
		// resJson = getWebTend(start_time, end_time, userID);
		// break;
		// default:
		// break;
		// }
		// InputStreamReader reader = new InputStreamReader(
		// request.getInputStream());
		// reader.read();
		BufferedReader r = request.getReader();
		// while(r.read()!=-1){
		//
		// }
		String[] params = r.readLine().split("=");
		start_time = params[0];
		end_time = params[1];
		System.out.println(r.readLine());
		System.out.println(request.getParameter("data"));
		System.out.println(start_time);
		System.out.println(end_time);
		String resJson = getWebTend(start_time, end_time, userID);
		System.out.println(resJson);
		response.setContentType("application/json");
		response.setCharacterEncoding("UTF-8");
		response.getWriter().write(resJson);
	}

	public void init() throws ServletException {
		// Put your code here
	}

	/**
	 * 获取各网站的倾向性
	 * 
	 * getWebTend
	 * 
	 * @param start_time
	 * @param end_time
	 * @param userID
	 * @return
	 */
	private String getWebTend(String start_time, String end_time, String UserId) {
		String resJson = "";
		ArticleTendAnalyse articleTendAnalyse = new ArticleTendAnalyse();
		resJson = articleTendAnalyse.GenerateJSon(start_time, end_time, UserId);
		return resJson;
	}
}
