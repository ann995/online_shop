package Servlets;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter("/*")
public class SecurityFilter implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String usernameAttribute = (String) request.getSession().getAttribute("username");
        String requestUri = request.getRequestURI();

        if (usernameAttribute != null || requestUri.endsWith("login") || requestUri.endsWith("login.jsp") || requestUri.endsWith("register.jsp") || requestUri.endsWith("register") || requestUri.endsWith(".css") || requestUri.endsWith(".png")) {
            filterChain.doFilter(request, response);
        } else {
            response.sendRedirect(response.encodeRedirectURL("login.jsp"));
        }
    }
}
