/**
 * @author taylor
 */
package br.com.lucro.server.service.filter;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @author taylor
 *
 */
@Component("httpCorsFilter")
public class CorsFilter extends OncePerRequestFilter {

	private static final String ORIGIN = "Origin";
	
	private static final Logger logger = LoggerFactory.getLogger(CorsFilter.class);
	
	/* (non-Javadoc)
	 * @see org.springframework.web.filter.OncePerRequestFilter#doFilterInternal(javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse, javax.servlet.FilterChain)
	 */
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
		response.addHeader("Access-Control-Allow-Origin", "*");
		
		if (request.getHeader(ORIGIN)!=null && request.getHeader(ORIGIN).equals("null")) {
			response.addHeader("Access-Control-Allow-Methods", "GET,POST,PUT,OPTIONS,DELETE");			
            response.addHeader("Access-Control-Allow-Headers", "Authorization,Content-Type");
            response.addHeader("Access-Control-Allow-Credentials", "true");
			response.addHeader("Access-Control-Max-Age", "1");			
		}
		
		if (request.getMethod().equals("OPTIONS")) {
            try {
                response.getWriter().print("OK");
                response.getWriter().flush();
            } catch (IOException e) {
                logger.error(e.getMessage(), e);
            }
        }else{
        	filterChain.doFilter(request, response);
        }
	}

}
