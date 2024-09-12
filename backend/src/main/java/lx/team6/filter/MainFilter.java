package lx.team6.filter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpFilter;

public class MainFilter extends HttpFilter implements Filter {
 
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		
		System.out.println("MainFilter.doFilter() start!");
		chain.doFilter(request, response);
		System.out.println("MainFilter.doFilter() end!");
	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

	
}
