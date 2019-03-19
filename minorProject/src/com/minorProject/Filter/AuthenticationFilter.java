package com.minorProject.Filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.minorProject.Daos.UserDao;
@WebFilter("/*")
public class AuthenticationFilter implements Filter {

	private ServletContext context;

	public void init(FilterConfig fConfig) throws ServletException {
		this.context = fConfig.getServletContext();
		this.context.log("AuthenticationFilter initialized");
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest req = (HttpServletRequest) request;
		HttpServletResponse res = (HttpServletResponse) response;

		String uri = req.getRequestURI();
		this.context.log("Requested Resource::" + uri);

		if (uri.endsWith("Loginform2") ||uri.endsWith("ForgotPassController")||uri.endsWith("changepass")|| uri.endsWith("LoginServlet") || uri.endsWith("Registrationform2") ||uri.endsWith("RegistrationServlet") ||uri.endsWith("Forgot_password") ||uri.endsWith("ForgotPassController")||uri.endsWith("EnterOTP")||uri.endsWith("html") || uri.endsWith("js")
				|| uri.endsWith("css") || uri.endsWith("png") || uri.endsWith("jpg")) {
			this.context.log("Home Page Access");
			chain.doFilter(request, response);
		} else {
			HttpSession session = req.getSession();
			System.out.println(session);
			int uid = 0;
			String username = new String();
			String password = new String();
			if (session != null) {
				Integer sessionId = (Integer) session.getAttribute("uid");
				username = (String) session.getAttribute("user name");
				password = (String) session.getAttribute("password");
				if (sessionId != null && username != null && password != null) {
					uid = UserDao.checkAvailablity(username,password);
					if (uid == sessionId) {
						chain.doFilter(request, response);
					} else {
						res.sendRedirect("Loginform2");
					}
				} else
					res.sendRedirect("Loginform2");
			}
		}

	}

	public void destroy() {
		// close any resources here
	}

}
